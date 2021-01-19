package com.cg.cars.exception;

 

public class DuplicateOrderException extends Exception {
	public static final String MESSAGE="Duplicate Order  found ";
	public DuplicateOrderException (final String MESSAGE)
	{
		super(MESSAGE);
	}
}