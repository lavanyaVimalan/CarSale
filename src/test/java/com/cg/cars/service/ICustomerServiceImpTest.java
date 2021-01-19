package com.cg.cars.service;
/** The ICustomerServiceImplTest class provides testing of ICustomerServiceImpl layer
 *   
 * @author Lavanya's
 * 
 */

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.cars.beans.Address;
import com.cg.cars.dao.ICustomerRepository;
import com.cg.cars.exception.CustomerNotFoundException;
import com.cg.cars.exception.DuplicateCustomerException;
import com.cg.cars.beans.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
class ICustomerServiceImpTest {

	@MockBean
	private ICustomerRepository cusRepository;
	@Autowired
	private ICustomerService cusService;
	/*
	 * 
	 * This method tests whether the customer details are added or not
	 * 
	 */
	@Test
	void testAddCustomerInThedataBase() throws DuplicateCustomerException {
		Address obj = new Address("111", "muthusamy street", "shevapet", "salem", "TamilNadu", 636002);
		Customer customer = new Customer(101, "lavanya", "8523697412", "lavanyavimalan@gmail.com",
				LocalDate.of(1997, 04, 23), obj);
		Mockito.when(cusRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, cusService.addCustomer(customer));
	}
	/*
	 * 
	 * This method tests whether the customer details are deleted or not
	 * 
	 */

	@Test
	void testRemoveCustomerFromTheDataBase() throws CustomerNotFoundException {
		Customer customer = new Customer();
		customer.setcustId(101);
		customer.setName("lavanya");
		customer.setContactNo("8523697412");
		customer.setEmail("lavanyavimalan@gmail.com");
		customer.setDob(LocalDate.of(1997, 04, 23));
		Address obj = new Address("111", "muthusamy street", "shevapet", "salem", "TamilNadu", 636002);
		customer.setAddress(obj);
		long id = customer.getcustId();
		Optional<Customer> customerDelete = Optional.of(customer);
		Mockito.when(cusRepository.findById(id)).thenReturn(customerDelete);
		customer = cusService.removeCustomer(id);
		Optional<Customer> customer1 = Optional.of(customer);
		assertEquals(customer1, customerDelete);

	}
	/*
	 * 
	 * This method tests whether the customer details are updated or not
	 * 
	 */
	@Test
	void testUpdateCustomerInTheDataBase() throws CustomerNotFoundException {
		Customer updateCustomer = new Customer();
		updateCustomer.setcustId(103L);
		when(cusRepository.existsById(103L)).thenReturn(true);
		when(cusRepository.findById(103L)).thenReturn(Optional.of(updateCustomer));
		when(cusRepository.save(updateCustomer)).thenReturn(updateCustomer);
		Customer customer = cusService.updateCustomer(103L, updateCustomer);
		assertEquals(customer, updateCustomer);

	}
	/*
	 * 
	 * This method is used to get the customer details based on customer Id
	 * 
	 */
	@Test
	void testGetCustomerFromTheDataBase() throws CustomerNotFoundException {

		Address obj = new Address("111", "muthusamy street", "shevapet", "salem", "TamilNadu", 636002);
		Customer customer = new Customer(101, "lavanya", "8523697412", "lavanyavimalan@gmail.com",
				LocalDate.of(1997, 04, 23), obj);
		long id = customer.getcustId();
		Optional<Customer> getCustomer = Optional.of(customer);
		Mockito.when(cusRepository.findById(id)).thenReturn(getCustomer);
		customer = cusService.getCustomer(id);
		Optional<Customer> customer1 = Optional.of(customer);
		assertEquals(customer1, getCustomer);

	}
	/*
	 * 
	 * This method is used to get all the customer's details
	 * 
	 */

	@Test
	void testGetAllCustomersFromTheDataBase() throws CustomerNotFoundException {

		Address obj = new Address("111", "muthusamy street", "shevapet", "salem", "TamilNadu", 636002);
		Customer customer = new Customer(101, "lavanya", "8523697412", "lavanyavimalan@gmail.com",
				LocalDate.of(1997, 04, 23), obj);
		Address obj1 = new Address("101", "muthu street", "shet", "salem", "TamilNadu", 636002);
		Customer customer1 = new Customer(102, "lav", "9523697412", "lavanyavimalan@gmail.com",
				LocalDate.of(1998, 05, 24), obj1);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer);
		customerList.add(customer1);
		Mockito.when(cusRepository.findAll()).thenReturn(customerList);
		assertThat(cusService.getAllCustomers()).isEqualTo(customerList);

	}
	/*
	 * 
	 * This method is used to get all the customers based on location
	 * 
	 */

	@Test
	void testGetCustomersByLocationFromTheDataBase() throws CustomerNotFoundException {
		Address obj = new Address("111", "muthusamy street", "shevapet", "salem", "TamilNadu", 636002);
		Customer customer = new Customer(101, "lavanya", "8523697412", "lavanyavimalan@gmail.com",
				LocalDate.of(1997, 04, 23), obj);
		Address obj1 = new Address("101", "muthu street", "shet", "salem", "TamilNadu", 636002);
		Customer customer1 = new Customer(102, "lav", "9523697412", "lavanyavimalan@gmail.com",
				LocalDate.of(1998, 05, 24), obj1);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer);
		customerList.add(customer1);
		Mockito.when(cusRepository.findByAddress_City("salem")).thenReturn(customerList);
		assertEquals(cusService.getCustomersByLocation("salem"), customerList);
	}

}
