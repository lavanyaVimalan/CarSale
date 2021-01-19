package com.cg.cars.exception;

public class DuplicateUserFoundException extends Exception{
	public static final String MESSAGE="DuplicateUserFoundException";
	public DuplicateUserFoundException( final String message)
	{
		super(message);
	}

}