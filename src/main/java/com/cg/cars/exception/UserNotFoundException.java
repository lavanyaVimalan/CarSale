package com.cg.cars.exception;

public class UserNotFoundException extends Exception{
	public static final String MESSAGE="UserNotFound or Unavailable";
	public UserNotFoundException(final String message)
	{
		super(message);
	}
}