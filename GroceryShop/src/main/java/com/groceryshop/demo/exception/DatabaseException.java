package com.cg.gsm.app.exception;

@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException {
    public DatabaseException() {
        super();
    }

    public DatabaseException(String msg) {
        super(msg);
    }

    public DatabaseException(String msg, Throwable clause) {
        super(msg, clause);
    }

    public DatabaseException(Throwable clause) {
        super(clause);
    }
}
