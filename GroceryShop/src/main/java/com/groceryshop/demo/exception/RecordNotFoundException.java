package com.cg.gsm.app.exception;


public class RecordNotFoundException extends RuntimeException
{
	public RecordNotFoundException() {
		super();
	}
	
	public RecordNotFoundException(String msg) {
		super(msg);
	}
	
	public RecordNotFoundException(String msg,Throwable clause) {
		super(msg,clause);
	}
	
	public RecordNotFoundException(Throwable clause) {
		super(clause);
	}
}
