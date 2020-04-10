package com.ge.re.sdm.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
/* this class will be invoked when BookNotFoundException occurred */
public class BookNotFoundException extends RuntimeException
{
   
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message) 
	{
	super(message);
		
	}

	
}
