package com.groceryshop.demo.exception;



public class RecordNotFoundException extends RuntimeException{




	/**
	 * @param msg
	 *            error message
	 */
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
