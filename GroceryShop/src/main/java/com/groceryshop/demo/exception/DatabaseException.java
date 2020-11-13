package com.groceryshop.demo.exception;





public class DatabaseException  extends RuntimeException
{
	/**
    * @param msg
    *            : Error message
    */
	public DatabaseException() {
		super();
	}
   public DatabaseException(String msg) {
       super(msg);
   }
   public DatabaseException(String msg,Throwable clause) {
		super(msg,clause);
	}
	
	public DatabaseException(Throwable clause) {
		super(clause);
	}
}

