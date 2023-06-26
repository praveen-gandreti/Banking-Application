package BANKING.AccountAndUserCreation.RestCalls;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BANKING.AccountAndUserCreation.EmailServices.MailServices;
import BANKING.AccountAndUserCreation.GlobalExceptionHandler.InsufficientBalanceException;
import BANKING.AccountAndUserCreation.GlobalExceptionHandler.NoUserFoundException;
import BANKING.AccountAndUserCreation.Model.Account;
import BANKING.AccountAndUserCreation.Model.Registration;
import BANKING.AccountAndUserCreation.Model.UserData;
import BANKING.AccountAndUserCreation.Services.AccountServices;
import BANKING.AccountAndUserCreation.repository.AccountRepo;
import BANKING.AccountAndUserCreation.repository.UserDataRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Control {
	
	@Autowired
	MailServices mail;
	
	@Autowired
	UserDataRepo ur;
	
	@Autowired
	AccountServices as;
	
	@Autowired
	ModelMapper model;
	
	@Autowired
	AccountRepo ar;
	
	
	// CREATEING ACCOUNT AND USER DATA WITH REGISTRATION DETAILS.
	@PostMapping("create/account")
	public void save(@RequestBody Registration r) throws Exception
	{
		try
		{
			as.save(r);
			
		}
		catch(Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return;
		
	}
	
	// TRANSFER MONEY FROM SENDER TO RECEIVER
	@GetMapping("transfar/{sac}/{rac}" )
	public ResponseEntity<Account> transferMoney(@PathVariable("sac") long sac,@PathVariable("rac") long rac,@RequestParam("amount")long amount)
	{
		try
		{
			return new ResponseEntity<>(as.TransferMoney(sac, rac,amount),HttpStatus.OK);
		}
		catch(InsufficientBalanceException e)
		{
			throw new InsufficientBalanceException(e.getMessage());
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
	}
	
	// CHECKING BANK BALANCE
	@GetMapping("balance/check/{ac}")
	public ResponseEntity<Account> checkBalance(@PathVariable("ac") long ac)
	{
		try
		{
			return new ResponseEntity<>(as.getAccountDetails(ac),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		
	}
	
	// DIPOSIT AMOUNT INTO ACCOUNT *****
	@GetMapping("diposit/user/{ac}")
	public ResponseEntity<Account> dipositAmount(@PathVariable("ac") long ac,@RequestParam("amount") long amount) throws Exception
	{
		try
		{
			return new ResponseEntity<>(as.dipositAmount(ac, amount),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Something Went Wrong");
		}
	}
	
	// WITHDRAW AMONT FROM ACCOUNT  ******
	@GetMapping("withdraw/user/{ac}")
	public ResponseEntity<Account> withdrawAmount(@PathVariable("ac") long ac,@RequestParam("amount") long amount) throws Exception
	{
		try
		{
			return new ResponseEntity<>(as.withdrawAmount(ac,amount),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		catch(InsufficientBalanceException e)
		{
			throw new InsufficientBalanceException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Something Went Wrong");
		}
		
	}
	
	// PROVIDEING ONLINE SERVICES   *****
	@PutMapping("online/{ac}")
	public ResponseEntity<Account> onlineServices(@PathVariable("ac") long ac) throws Exception
	{
		try
		{
			return new ResponseEntity<>(as.onlineServices(ac),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Something Went Wrong");
		}
		
	}
	
	// MODIFYING ACCOUNT DETAILS
	@PutMapping("update/account/{ac}")
	public ResponseEntity<Account> updateAccount(@PathVariable("ac") long ac,@RequestBody Account a) throws Exception
	{
		try
		{
			return new ResponseEntity<>(as.updateAccountData(ac, a),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Something Went Wrong");
		}
		
	}
	
	// MODIFYING USER_DATA
	@PutMapping("update/user/{userName}")
	public ResponseEntity<UserData> updateUser(@PathVariable("userName") String userName,@RequestBody UserData ud) throws Exception
	{
		try
		{
			return new ResponseEntity<>(as.updateUserData(userName,ud),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			throw new Exception("Something Went Wrong");
		}
	}
	
	@GetMapping("user/{username}")
	public ResponseEntity<UserData> getUserData(@PathVariable("username") String username)
	{
		try
		{
			return new ResponseEntity<>(as.getUserData(username),HttpStatus.OK);
		}
		catch(NoUserFoundException e)
		{
			throw new NoUserFoundException(e.getMessage());
		}
	}
	
	// SEND OTP
	@GetMapping("send")
	public ResponseEntity<Boolean> sendOtp(@RequestParam("otp")Long otp,@RequestParam("username") String userName)
	{
		
		System.out.println("########******************######");
		System.out.println(otp);
		System.out.println(userName);
		System.out.println("###############################");
		boolean b=as.generateOtp(otp, userName);
		return new ResponseEntity<>(b,HttpStatus.OK);
		
	}
	
	
	
	
	

}
