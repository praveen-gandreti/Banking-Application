package BANKING.LoginAndRegistration.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import BANKING.LoginAndRegistration.ExceptionHandling.NoUserFoundException;
import BANKING.LoginAndRegistration.MIcroServiceCall.CallingMicroservices;
import BANKING.LoginAndRegistration.Model.Registration;
import BANKING.LoginAndRegistration.repository.RegistrationRepo;

@Service
public class RegistrationServices {
	@Autowired
	RegistrationRepo rr;
	@Autowired
	CallingMicroservices cm;
	
	// PERSIST USER REGISTRATION INTO DATABSE
	public Registration save(Registration r)
	{
		return rr.save(r);
	}

	// CHECKING THE USER REGISTRATION DETAILS BY ID
	public Registration getUser(long id)
	{
		return rr.findById(id).orElseThrow(()->new NoUserFoundException("No User Found With Given Id "+id));
	}
	
	// GET ALL REGISTRED USER DETAILS
	public List<Registration> getAllUsers()
	{
		List<Registration> r=rr.findAll();
		if(r.isEmpty())
		{
			throw new NoUserFoundException("No Users Found");
		}
		return r;
	}
	
	// CREATING ACCOUNT USING REGISTRATION DETAILS
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public boolean createAccount(long id) throws Exception
	{
		Registration r=getUser(id);
		cm.save(r);
		rr.deleteById(id);
		Registration reg=rr.findById(id).orElse(null);
		if(reg==null)
		{
			System.out.println("+++++++++++++++++++++++++");
			return true;
		}			
		else
			throw new Exception("Something went Wrong At LOGIN REG SERVICE");
	}
	
	// DELETEING USER REGISTRATION USING ID
	public boolean deleteRegistration(long id) throws Exception
	{
		rr.deleteById(id);
		Registration reg=rr.findById(id).orElse(null);
		if(reg==null)
			return true;
		else
			throw new Exception("User Not Found");
		
	}
}
