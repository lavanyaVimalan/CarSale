package com.cg.cars.controller;
/** This is a Controller class for Payment module 
 * 
 * @author Jayasree's
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.beans.Payment;
import com.cg.cars.exception.DuplicatePaymentException;
import com.cg.cars.exception.PaymentIdNotFoundException;
import com.cg.cars.service.IPaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private IPaymentService service;
	
	/** This method adds the payment details 
	 * 
	 * @param Payment entity details
	 * 
	 * 
	 */
	
	//http://localhost:9090/payments/addPayment - method POST
	@PostMapping("/addPayment")
	public ResponseEntity<String> addPayment(@RequestBody Payment payment) throws DuplicatePaymentException{
		Payment payment1 = service.addPayment(payment);
		ResponseEntity<String> response;
		if(payment1 != null) {
			response = new ResponseEntity<String>("Payment with "+payment.getPaymentId()+" is added.",HttpStatus.CREATED);
		}
		else {
			response = new ResponseEntity<String>("Payment with "+payment.getPaymentId()+" is not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	/** This method deletes the payment details 
	 * 
	 * @param Payment entity details and Payment - paymentId
	 * 
	 * 
	 */
	
	//http://localhost:9090/payments/deletePayment - method DELETE
	@DeleteMapping("/deletePayment/{id}")
	public ResponseEntity<String> removePayment(@PathVariable(value = "id") long id) throws PaymentIdNotFoundException{
		Payment payment = service.removePayment(id);
		ResponseEntity<String> response;
		if(payment != null) {
			response = new ResponseEntity<String>("Payment with "+payment.getPaymentId()+" is deleted.", HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>("Payment with "+payment.getPaymentId()+" is not found.", HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	/** This method updates the payment details 
	 * 
	 * @param Payment entity details and Payment - paymentId
	 * 
	 * 
	 */
	
	//http://localhost:9090/payments/updatePayment - method PUT
	@PutMapping("/updatePayment/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value = "id") long id, @RequestBody Payment payment) {
		if(service.updatePayment(id, payment) != null) {
			return new ResponseEntity<Payment>(payment, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity("Payment with "+payment.getPaymentId()+" is not found.", HttpStatus.NOT_FOUND);
	}
	
	/** This method returns the payment details based on productId
	 * 
	 * @param Payment - paymentId 
	 * 
	 * 
	 */
	
	//http://localhost:9090/payments/getPayment - method GET
	@GetMapping("/getPayment/{id}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable(value = "id") long id) throws PaymentIdNotFoundException{
		Payment payment = service.getPaymentDetails(id);
		if(payment == null) {
			return new ResponseEntity("Payment with "+payment.getPaymentId()+" is not found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}
	
	/** 
	 * 
	 *This method returns the list of payment details  
	 * 
	 * 
	 */
	
	//http://localhost:9090/payments/getAllPayments - method GET
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/getAllPayments")
	public List<Payment> getAllPaymentDetails(){
		return service.getAllPaymentDetails();
	}
		 
}
