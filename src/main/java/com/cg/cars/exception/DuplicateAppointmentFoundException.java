package com.cg.cars.exception;

public class DuplicateAppointmentFoundException extends Exception {
	public static final String MESSAGE="Appointment already made";
	public DuplicateAppointmentFoundException(final String  MESSAGE) {
		super(MESSAGE);
	}
	
}
