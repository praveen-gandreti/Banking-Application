package BANKING.LoginAndRegistration.RestCalls;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import BANKING.LoginAndRegistration.ExceptionHandling.NoUserFoundException;
import BANKING.LoginAndRegistration.Model.Registration;
import BANKING.LoginAndRegistration.Services.RegistrationServices;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class Control {
	
	@Autowired
	RegistrationServices rs;
	@PostMapping("registration/save")
	public ResponseEntity<Registration> save(@RequestBody @Valid Registration r) throws Exception
	{
		try
		{
			return new ResponseEntity<>(rs.save(r),HttpStatus.CREATED);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DataIntegrityViolationException("Can't Proceed With Duplicate Data");
		}
		catch(Exception e)
		{
			throw new Exception("Some thing went wrong");
		}
	}
	@GetMapping("registration/user/{id}")
	public ResponseEntity<Registration> getUser(@PathVariable long id) throws Exception
	{
		try
		{
			return new ResponseEntity<>(rs.getUser(id),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Some thing went wrong");
		}
		
	}
	@GetMapping("registration/users/all")
	public ResponseEntity<List<Registration>> getAllUsers() throws Exception
	{
		try
		{
			return new ResponseEntity<>(rs.getAllUsers(),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Some thing went wrong");
		}
		
	}
	
	// CREATEING ACCOUNT WITH REGISTRATION DETAILS
	@GetMapping("create/account/{id}")
	public ResponseEntity<Boolean> createAccount(@PathVariable long id) throws Exception
	{
		try
		{
			return new ResponseEntity<>(rs.createAccount(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
			
		}
	}
	
	
	// DELETING REGISTRATION WITH REGISTRATION ID
	@GetMapping("delete/account/{id}")
	public ResponseEntity<Boolean> deleteRegistration(@PathVariable long id) throws Exception
	{
		try
		{
			return new ResponseEntity<>(rs.deleteRegistration(id),HttpStatus.OK);
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
			
		}
	}

}
