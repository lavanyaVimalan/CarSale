package com.cg.cars.exception;
/** The CarIdNotFoundException layer provides customized Exceptions
 * 
 * @author Rukumbai's
 * 
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarIdNotFoundException extends Exception {
		public static final String MESSAGE="CarId entered is  Not found";
		public CarIdNotFoundException(final String  MESSAGE) {
			super(MESSAGE);
		}
	}
