package com.cg.cars.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler {
	

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),"Enter valid data", request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DuplicatePaymentException.class)
	public ResponseEntity<?> duplicatePaymentException(DuplicatePaymentException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PaymentIdNotFoundException.class)
	public ResponseEntity<?> paymentNotFoundException(PaymentIdNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<?> DuplicateCustomerException(DuplicateCustomerException ex,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> CustomerNotFoundException(CustomerNotFoundException ex,WebRequest request)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DuplicateOrderException.class)
		public ResponseEntity<?> duplicateOrderException(DuplicateOrderException ex,WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	@ExceptionHandler(OrderIdNotFoundException.class)
		public ResponseEntity<?> OrderIdNotFoundException(OrderIdNotFoundException ex,WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(CarIdNotFoundException.class)
	public ResponseEntity<?> CarIdNotFoundException(CarIdNotFoundException ex,WebRequest request){
	ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),"CarIdFoundException");
	return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(DuplicateCarIdFoundException.class)
	public ResponseEntity<?> DuplicateIdFoundException(DuplicateCarIdFoundException ex,WebRequest request){
	ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),"DuplicateId Found");
	return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(InvalidCarTypeException.class)
	public ResponseEntity<?> InvalidCarTypeException(InvalidCarTypeException ex,WebRequest request){
	ErrorDetails errorDetails=new ErrorDetails(new Date(),ex.getMessage(),"Invalid Car Type Entered");
	return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);

	}
	
}
