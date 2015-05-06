package com.shopsmart.common.exception.dao;

public class UserDAOException extends Exception {

	public UserDAOException() {
		super();
	}

	public UserDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDAOException(String message) {
		super(message);
	}

	public UserDAOException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -5530289226444978165L;

}
