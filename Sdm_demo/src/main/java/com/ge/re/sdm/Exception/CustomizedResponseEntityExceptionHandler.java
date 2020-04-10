package com.ge.re.sdm.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ge.re.sdm.ExceptionResponse.ExceptionResponse;

/* This class can be used for customized exceptions */
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	/* This method returns common internal server error when you get exceptions in complete application*/
	public final ResponseEntity<Object> handleAllExceptions(Exception exception,WebRequest request )
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	/* This method returns HttpStatusserver.NOT_FOUND exception when BookNotFoundException throws */
	@ExceptionHandler(BookNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(BookNotFoundException status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), status.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	/* This method returns  HttpStatus.BAD_REQUEST exception when validation Failed */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}	

}
