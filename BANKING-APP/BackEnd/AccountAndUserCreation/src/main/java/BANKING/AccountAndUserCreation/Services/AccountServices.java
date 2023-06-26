package BANKING.AccountAndUserCreation.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import BANKING.AccountAndUserCreation.EmailServices.MailServices;
import BANKING.AccountAndUserCreation.GlobalExceptionHandler.InsufficientBalanceException;
import BANKING.AccountAndUserCreation.GlobalExceptionHandler.NoUserFoundException;
import BANKING.AccountAndUserCreation.Model.Account;
import BANKING.AccountAndUserCreation.Model.Registration;
import BANKING.AccountAndUserCreation.Model.UserData;
import BANKING.AccountAndUserCreation.repository.AccountRepo;
import BANKING.AccountAndUserCreation.repository.UserDataRepo;

@Service
public class AccountServices {
	
	@Autowired
	AccountRepo ar;
	
	@Autowired
	UserDataRepo ur;
	
	@Autowired
	ModelMapper model;
	
	@Autowired 
	MailServices mail;
	
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void save(Registration r) throws Exception
	{
		Account a=model.map(r,Account.class);
		a=ar.save(a);
		UserData u=new UserData(r.getEmail(),"abc","user",a.getAccount());
		u=ur.save(u);
		mail.sendEmail(u.getUserName(),"WELCOME TO ROYAL BANK OF INDIA",
				"Dear "+a.getFirstName()+" "+a.getLastName()+
				       ".    Your Account is Successfully Created       ACCOUNT NUMBER : "+a.getAccount()+"  USERNAME : "+a.getEmail()
				+"      PASSWORD : "+u.getPassword());
		System.out.println("******");
		if(ar.findById(a.getAccount())==null)
		{
			throw new Exception("Something Went Wrong");
		}
		if(ur.findById(u.getAccount())==null)
		{
			throw new Exception("Can't Create With Duplicate Data");
		}
		return;
	}
	
	// TRANSFER MONEY FROM SENDER TO RECEIVER
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public Account TransferMoney(long sac,long rac,long money)
	{
		Account a=ar.findById(sac).orElse(null);
		if(a!=null)
		{
			Account b=ar.findById(rac).orElse(null);
			if(b!=null)
			{
				long bal=a.getBalance();
				if(bal>=money)
				{
					a.setBalance(a.getBalance()-money);
					b.setBalance(b.getBalance()+money);
					ar.save(a);
					ar.save(b);
					return a;
				}
				else
				{
					throw new InsufficientBalanceException("Insufficient Balance");
				}
			}
			else
			{
				throw new NoUserFoundException("NO RECEVER ACCOUNT FOUND");
			}
		}
		else
		{
			throw new NoUserFoundException("NO SENDER ACCOUNT FOUND");
		}
	}
	
	// FETCHING ACCOUNT WITH ACCOUNT NUMBER
	public Account getAccountDetails(long ac)
	{
		return ar.findById(ac).orElseThrow(()-> new NoUserFoundException("User Account FOUND"));
	}
	
	// DIPOSIT AMOUNT TO USER ACCOUNT
	public Account dipositAmount(long ac,long amount)
	{
		Account a=ar.findById(ac).orElseThrow(()-> new NoUserFoundException("Account Not Found"));
		a.setBalance(a.getBalance()+amount);
		return ar.save(a);
	}
	
	// WITHDRAW AMOUNT TO USER ACCOUNT
		public Account withdrawAmount(long ac,long amount)
		{
			Account a=ar.findById(ac).orElseThrow(()-> new NoUserFoundException("Account Not FOUND"));
			if(a.getBalance()>=amount)
			{
				a.setBalance(a.getBalance()-amount);
				a=ar.save(a);
				return a;
			}
			else
			{
				throw new InsufficientBalanceException("Insufficient Balance");
			}
		}
		
	//PROVIDE ONLINE SERVICES
		public Account onlineServices(long ac)
		{
			Account a=ar.findById(ac).orElseThrow(()-> new NoUserFoundException("User Not FOUND"));
				a.setOnline(true);
				return ar.save(a);
		}
	// MODIFY USER ACCOUNT DETAILS
		@Transactional
		public Account updateAccountData(long ac,Account a)
		{
			Account acc=ar.findById(ac).orElseThrow(()-> new NoUserFoundException("User Not FOUND"));
			acc=model.map(a,Account.class);
			return ar.save(acc);
		}
		
	// MODIFY USER  DETAILS
		@Transactional
		public UserData updateUserData(String userName,UserData a)
		{
			UserData u=ur.findByUserName(userName);
			if(u!=null)
			{
				u.setPassword(a.getPassword());
				if(!(u.getUserName().equals(a.getUserName())))
				{
					u.setUserName(a.getUserName());
				}
				u.setUserName(a.getUserName());
				//u=model.map(a,UserData.class);
				ur.save(u);
				return u;
			}
			else
			{
				throw new NoUserFoundException("User Not FOUND");
			}
		}
	
	// GETTING USER DATA BY USERNAME
		public UserData getUserData(String username)
		{
			
			UserData u=ur.findByUserName(username);
			System.out.println(u);
			if(u==null)
			{
				throw new NoUserFoundException("User Not FOUND");
			}
			else
			{
				return u;
			}
		}
		
		
		// SENDING OTP TO EMIAL
		public boolean generateOtp(long otp,String userName)
		{
			System.out.println("###############################");
			System.out.println(otp);
			System.out.println(userName);
			System.out.println("###############################");
			mail.sendEmail(userName,"OTP FROM ROYAL BANK OF INDIA","This is "
					+ "information is very confidential Please don't share OTP :"+otp+"  with others");
			System.out.println("OTP SENDED*****************");
			return true;
		}

}
