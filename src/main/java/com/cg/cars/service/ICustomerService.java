package com.cg.cars.service;
/** This is an interface which defines CRUD methods for Customer service
 * 
 * @author Lavanya's
 *
 */

import java.util.List;
import com.cg.cars.exception.CustomerNotFoundException;
import com.cg.cars.exception.DuplicateCustomerException;
import com.cg.cars.beans.Customer;



public interface ICustomerService {

	public Customer addCustomer(Customer customer) throws DuplicateCustomerException;
	public Customer removeCustomer(long custId) throws CustomerNotFoundException;
	public Customer updateCustomer(long custId, Customer customer) throws CustomerNotFoundException;
	public Customer getCustomer(long custId)throws CustomerNotFoundException;
	public List<Customer> getAllCustomers()throws CustomerNotFoundException; 
	public List<Customer> getCustomersByLocation(String city)throws CustomerNotFoundException;
}
