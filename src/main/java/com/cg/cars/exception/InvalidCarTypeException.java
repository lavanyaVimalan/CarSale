package com.cg.cars.exception;
/** The InvalidCarTypeException layer provides customized Exceptions
 * 
 * @author Rukumbai's
 * 
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidCarTypeException extends Exception {
	public static final String MESSAGE="The type of Car Specified is Not Available";
	public InvalidCarTypeException(final String  MESSAGE) {
		super(MESSAGE);
	}
}
