package com.cg.cars.exception;

public class CustomerNotFoundException extends RuntimeException {
	public static final String MESSAGE = "Customer Id not found or unavailable";

	public CustomerNotFoundException(final String MESSAGE) {
		super(MESSAGE);
	}

}
