package com.exam.helper;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("Username not found!! No such user exists!!");
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
