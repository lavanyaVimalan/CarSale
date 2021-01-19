package com.cg.cars.exception;

public class AppointmentNotFoundException extends Exception {
	public static final String MESSAGE="Appointment Id entered is Not found";
	public AppointmentNotFoundException(final String  MESSAGE) {
		super(MESSAGE);
	}
	
}
