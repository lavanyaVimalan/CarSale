package com.cg.cars.dao;
/** This is a repository class for Customer module 
 * 
 * @author Lavanya's
 *
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cars.beans.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long>{
	public List<Customer> findByAddress_City(String city);

}
