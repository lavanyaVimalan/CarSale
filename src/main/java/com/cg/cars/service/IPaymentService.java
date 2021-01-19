package com.cg.cars.service;
/** This is an interface which defines CRUD methods for Payment service
 * 
 * @author Jayasree's
 *
 */
import java.util.List;

import com.cg.cars.beans.Payment;
import com.cg.cars.exception.DuplicatePaymentException;
import com.cg.cars.exception.PaymentIdNotFoundException;

public interface IPaymentService {
	public Payment addPayment(Payment payment) throws DuplicatePaymentException;
	public Payment removePayment(long id) throws PaymentIdNotFoundException;
	public Payment updatePayment(long id, Payment payment) throws PaymentIdNotFoundException;
	public Payment getPaymentDetails(long id) throws PaymentIdNotFoundException;
	public List<Payment> getAllPaymentDetails();
}