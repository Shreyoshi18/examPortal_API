package com.exam.helper;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User with this username already exists in database.");
		// TODO Auto-generated constructor stub
	}

	public UserFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
