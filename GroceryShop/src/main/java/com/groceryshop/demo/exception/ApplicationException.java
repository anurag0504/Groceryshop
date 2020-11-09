package com.cg.gsm.app.exception;



public class ApplicationException  extends RuntimeException
{
	public ApplicationException() {
		super();
	}
	
	public ApplicationException(String msg) {
		super(msg);
	}
	
	public ApplicationException(String msg,Throwable clause) {
		super(msg,clause);
	}
	
	public ApplicationException(Throwable clause) {
		super(clause);
	}
	
}
