package com.groceryshop.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DuplicateRecordException  extends RuntimeException
{
	
	public DuplicateRecordException(String msg) {
		super(msg);
	}

	public DuplicateRecordException() {
		super("");
		// TODO Auto-generated constructor stub
	}

	public DuplicateRecordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateRecordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateRecordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
