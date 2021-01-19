package com.cg.cars.exception;
/** The DuplicatePaymentException layer provides customized Exceptions
 * 
 * @author Jayasree's
 * 
 * 
 */
public class DuplicatePaymentException extends Exception {

public static final String MESSAGE = "Payment already exists with this id.";
	
	public DuplicatePaymentException(final String MESSAGE) {
		super(MESSAGE);
	}
	 
}
