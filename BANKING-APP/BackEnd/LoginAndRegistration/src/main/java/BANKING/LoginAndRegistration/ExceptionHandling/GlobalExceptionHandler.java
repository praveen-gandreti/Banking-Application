package BANKING.LoginAndRegistration.ExceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String,String> h=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			h.put(error.getField(),error.getDefaultMessage());
		});
		return new ResponseEntity<>(h,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> exception(DataIntegrityViolationException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
		
	}
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<?> exception(NoUserFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
