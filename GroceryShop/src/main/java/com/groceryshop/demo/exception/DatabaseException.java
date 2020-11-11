package com.groceryshop.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DatabaseException  extends Exception
{

   public DatabaseException(String msg) {
       super(msg);
   }

public DatabaseException() {
	super();

}

public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
	
}

public DatabaseException(String message, Throwable cause) {
	super(message, cause);
	
}

public DatabaseException(Throwable cause) {
	super(cause);

}
   
   
}

