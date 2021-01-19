package com.cg.cars.dao;
/** This is a repository class for Payment module 
 * 
 * @author Jayasree's
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cars.beans.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long>{

	 
	 
}