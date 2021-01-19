package com.cg.cars.service;

/** The ICustomerServiceImpl class provides access to repository methods to CRUD operations  
 * 
 * 
 * @author Lavanya's
 *
 */

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.ICustomerRepository;
import com.cg.cars.exception.CustomerNotFoundException;
import com.cg.cars.exception.DuplicateCustomerException;
import com.cg.cars.beans.Customer;

@Service
public class ICustomerServiceImp implements ICustomerService {
	
	private static final Logger logger = LogManager.getLogger(ICustomerServiceImp.class);
	
	@Autowired
	public ICustomerRepository cusRepository;

	public ICustomerRepository getRep() {
		return cusRepository;
	}

	public void setRep(ICustomerRepository cusRepository) {
		this.cusRepository = cusRepository;
	}

	@Override
	public Customer addCustomer(Customer customer) throws DuplicateCustomerException {
		Customer cus = cusRepository.save(customer);
		if (cus != null) {
			logger.info("Customer Added Successfully...!");
			return cus;
		} else {
			throw new DuplicateCustomerException(DuplicateCustomerException.MESSAGE);
		}
	}

	@Override
	public Customer removeCustomer(long custId) throws CustomerNotFoundException {
		Customer customer = cusRepository.findById(custId)
				.orElseThrow(() -> new CustomerNotFoundException(CustomerNotFoundException.MESSAGE));
		logger.info("Customer Removed Successfully...!");
		cusRepository.delete(customer);
		return customer;

	}

	@Override
	public Customer updateCustomer(long custId, Customer customer) throws CustomerNotFoundException {
		if (cusRepository.existsById(custId)) {
			logger.info("Customer Updated Successfully...!");
			return cusRepository.save(customer);
		} else

		{
			throw new CustomerNotFoundException(CustomerNotFoundException.MESSAGE);
		}
	}

	@Override
	public Customer getCustomer(long custId) throws CustomerNotFoundException {
		Optional<Customer> cus = cusRepository.findById(custId);
		if (cus.isPresent()) {
			 logger.info("Retrieved Customer Details By Id Successfully..!");
			 return cus.get();
		} else {
			throw new CustomerNotFoundException(CustomerNotFoundException.MESSAGE);
		}
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerNotFoundException {
		logger.info("Retrieved All Customers Successfully...!");
		return cusRepository.findAll();
	}

	@Override
	public List<Customer> getCustomersByLocation(String city) throws CustomerNotFoundException {
		logger.info("Retrieved All Payments  by Location Successfully...!");
		return cusRepository.findByAddress_City(city);
	}

}
