package com.cg.cars.exception;

public class DuplicateCustomerException extends Exception {
	public static final String MESSAGE = "Duplicate Customer ID found";

	public DuplicateCustomerException(final String MESSAGE) {
		super(MESSAGE);
	}

}
