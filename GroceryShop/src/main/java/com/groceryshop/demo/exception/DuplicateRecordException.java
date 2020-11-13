package com.groceryshop.demo.exception;




public class DuplicateRecordException  extends RuntimeException
{
	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException() {
		super();
	}
	
	public DuplicateRecordException(String msg) {
		super(msg);
	}
	public DuplicateRecordException(String msg,Throwable clause) {
		super(msg,clause);
	}
	
	public DuplicateRecordException(Throwable clause) {
		super(clause);
	}
}
