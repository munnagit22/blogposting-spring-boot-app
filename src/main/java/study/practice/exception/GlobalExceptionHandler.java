package study.practice.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	
	@Value("${blog.message}")
	 String blogmsg;
	 @Value("${blog.messageExist}")
	String blogExistMsg;

	 @ExceptionHandler(value =BlogNotFoundException.class)
	    public ResponseEntity<String> blogNotFoundException(BlogNotFoundException blogNotFoundException) {
	        return new ResponseEntity<String>(blogmsg, HttpStatus.CONFLICT);
	    }
	 @ExceptionHandler(value = BlogAllreadyExistException.class)
	 public ResponseEntity<String> blogAlReadyExistException(BlogAllreadyExistException blogexist)
	 {
		 return new ResponseEntity<String>(blogExistMsg,HttpStatus.CONFLICT);
	 }
	 
}
