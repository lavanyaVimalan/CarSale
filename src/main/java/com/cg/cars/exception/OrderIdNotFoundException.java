package com.cg.cars.exception;

 

public class OrderIdNotFoundException extends Exception {
	public static final String MESSAGE="Order Id not found or unavailable";
	public OrderIdNotFoundException (final String MESSAGE)
	{
		super(MESSAGE);
	}
    
}