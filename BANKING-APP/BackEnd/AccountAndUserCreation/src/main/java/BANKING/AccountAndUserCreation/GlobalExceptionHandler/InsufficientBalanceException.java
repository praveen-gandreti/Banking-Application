package BANKING.AccountAndUserCreation.GlobalExceptionHandler;

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 792407779442296136L;

	public InsufficientBalanceException(String message) {
		super(message);
		
	}
	

}
