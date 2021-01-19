package com.cg.cars.exception;
/** The DuplicateIdFoundException layer provides customized Exceptions
 * 
 * @author Rukumbai's
 * 
 * 
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateCarIdFoundException extends RuntimeException {
	public static final String MESSAGE="Car already exists";
	public DuplicateCarIdFoundException(final String  MESSAGE) {
		super(MESSAGE);
	}
	

}
