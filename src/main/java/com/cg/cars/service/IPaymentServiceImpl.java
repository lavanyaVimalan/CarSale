package com.cg.cars.service;
/** The IPaymentServiceImpl class provides access to repository methods to CRUD operations Cart details 
 * 
 * 
 * @author Jayasree's
 *
 */
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.beans.Payment;
import com.cg.cars.dao.IPaymentRepository;
import com.cg.cars.exception.DuplicatePaymentException;
import com.cg.cars.exception.PaymentIdNotFoundException;

@Service
public class IPaymentServiceImpl implements IPaymentService {

	private static final Logger logger = LogManager.getLogger(IPaymentServiceImpl.class);
	
	@Autowired
	private IPaymentRepository paymentRepository;
	
	
	
	public IPaymentRepository getPaymentRepository() {
		return paymentRepository;
	}

	public void setPaymentRepository(IPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment addPayment(Payment payment) throws DuplicatePaymentException{
		Payment payment1 = paymentRepository.save(payment);
		if(payment1 != null) {
			logger.info("Payment Added Successfully...!");
			return payment1;
		}
		else {
			throw new DuplicatePaymentException(DuplicatePaymentException.MESSAGE);
		}
	}

	@Override
	public Payment removePayment(long id) throws PaymentIdNotFoundException{
		Payment payment = paymentRepository.findById(id).orElseThrow(() -> new PaymentIdNotFoundException(PaymentIdNotFoundException.MESSAGE));
		paymentRepository.delete(payment);
		logger.info("Payment Deleted Successfully..!");
		return payment;
	}

	@Override
	public Payment updatePayment(long id, Payment payment) throws PaymentIdNotFoundException{
		if(paymentRepository.existsById(id)) {
			logger.info("Payment Updated Successfully...!");
			return paymentRepository.save(payment);
		}
		throw new PaymentIdNotFoundException(PaymentIdNotFoundException.MESSAGE);
	}

	@Override
	public  Payment getPaymentDetails(long id) throws PaymentIdNotFoundException{
		 Optional<Payment> payment = paymentRepository.findById(id);
		 if(payment.isPresent()) {
			 logger.info("Retrieved Payment By Id Successfully..!");
			 return payment.get();
		 }
		 throw new PaymentIdNotFoundException(PaymentIdNotFoundException.MESSAGE);
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		logger.info("Retrieved All Payments Successfully...!");
		return paymentRepository.findAll();
	}

	 
}