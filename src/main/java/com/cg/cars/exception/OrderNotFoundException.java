package com.cg.cars.exception;

public class OrderNotFoundException extends Exception {

	public static final String MESSAGE = "Order not found or unavailable";

	public OrderNotFoundException(final String MESSAGE) {
		super(MESSAGE);
	}

	private static final long serialVersionUID = 1L;

}