package com.cg.cars.exception;
/** The PaymentIdNotFoundException layer provides customized Exceptions
 * 
 * @author Jayasree's
 * 
 * 
 */
public class PaymentIdNotFoundException extends RuntimeException{
		 
	public static final String MESSAGE = "Payment with this Id is not found.";

	public PaymentIdNotFoundException(final String MESSAGE) {
		super(MESSAGE);
	}
	 
}