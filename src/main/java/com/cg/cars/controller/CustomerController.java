package com.cg.cars.controller;
/** This is a Controller class for Customer module 
 * 
 * @author Lavanya's
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.exception.CustomerNotFoundException;
import com.cg.cars.exception.DuplicateCustomerException;
import com.cg.cars.beans.Customer;
import com.cg.cars.service.ICustomerService;
@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	ICustomerService cusService;
	/** This method adds the customer details 
	 * 
	 * @param Customer entity details
	 * 
	 * 
	 */

	// http://localhost:9090/customers/addCustomer - method POST
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) throws DuplicateCustomerException {
		ResponseEntity<String> response;
		if (customer != null) {
			Customer cus = cusService.addCustomer(customer);
			response = new ResponseEntity<String>("Customer with " + cus.getcustId() + " is added.", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Customer with  is not added.", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	/** This method deletes the customer details 
	 * 
	 * @param Customer entity details and Payment - paymentId
	 * 
	 * 
	 */

	// http://localhost:9090/customers/deleteCustomer
	@DeleteMapping("/deleteCustomer/{custId}")
	public ResponseEntity<String> removeCustomer(@PathVariable(value = "custId") long custId)
			throws CustomerNotFoundException {
		Customer customer = cusService.removeCustomer(custId);
		ResponseEntity<String> response;
		if (customer != null) {
			response = new ResponseEntity<String>("Customer with " + customer.getcustId() + " is deleted.",
					HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<String>("Customer with " + customer.getcustId() + " is not found.",
					HttpStatus.NOT_FOUND);
		}
		return response;
	}
	/** This method updates the customer details 
	 * 
	 * @param Customer entity details and Customer - custId
	 * 
	 * 
	 */

	// http://localhost:9090/customers/updateCustomer - method UPDATE
	@PutMapping("/updateCustomer/{custId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "custId") long custId,
			@RequestBody Customer customer) throws CustomerNotFoundException {
		if (cusService.updateCustomer(custId, customer) != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity("Customer with " + customer.getcustId() + " is not found.", HttpStatus.NOT_FOUND);
	}
	/** This method returns the customer details based on custId
	 * 
	 * @param Customer - custId 
	 * 
	 * 
	 */

	// http://localhost:9090/customers/getcustomerById - method GET
	@GetMapping("/getcustomertById/{custId}")
	private ResponseEntity<Customer> getcustomertById(@PathVariable("custId") long custId)
			throws CustomerNotFoundException {
		Customer customer = cusService.getCustomer(custId);
		if (customer == null) {
			return new ResponseEntity("Customer with " + customer.getcustId() + " is not found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}
	/** 
	 * 
	 *This method returns the list of customer details  
	 * 
	 * 
	 */

	// http://localhost:9090/customers/getAllCustomers
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerNotFoundException {
		return new ResponseEntity<List<Customer>>(cusService.getAllCustomers(), HttpStatus.OK);
	}
	/** 
	 * 
	 *This method returns the list of customer details  based on location
	 * 
	 * 
	 */
	// http://localhost:9090/customers/getByLocation
	@GetMapping("getByLocation/{city}")
	public ResponseEntity<List<Customer>> getCustomersByLocation(@PathVariable String city)
			throws CustomerNotFoundException {
		return new ResponseEntity<List<Customer>>(cusService.getCustomersByLocation(city), HttpStatus.OK);
	}

	@ExceptionHandler(value = DuplicateCustomerException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Duplicate Customer Id Found")
	public void handleException(DuplicateCustomerException e) {

	}

	@ExceptionHandler(value = CustomerNotFoundException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Duplicate Customer Id Found")
	public void handleException(CustomerNotFoundException e) {

	}

}
