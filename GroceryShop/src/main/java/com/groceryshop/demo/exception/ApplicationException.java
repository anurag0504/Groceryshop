package com.groceryshop.demo.exception;





public class ApplicationException  extends RuntimeException
{
	/**
	 * @param msg
	 *            : Error message
	 */
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

