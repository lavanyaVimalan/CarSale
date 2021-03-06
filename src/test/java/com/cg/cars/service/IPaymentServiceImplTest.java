package com.cg.cars.service;
/** The IPaymentServiceImplTest class provides testing of IPaymentServiceImpl layer
 *   
 * @author Jayasree's
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.beans.Card;
import com.cg.cars.beans.Payment;
import com.cg.cars.dao.IPaymentRepository;

@SpringBootTest
class IPaymentServiceImplTest {

	@Autowired
	private IPaymentService service;
	
	@MockBean
	private IPaymentRepository paymentRepository;	
	
	/*
	 * 
	 * This method tests whether the payment details are added or not
	 * 
	 */
	@Test
	void testAddPaymentShouldAddPaymentToDatabase() throws Exception {
		Card card = new Card(201, "Suji", "3739 3450 2989", LocalDate.of(2025, 9, 8), 123);
		Payment paymentToAdd = new Payment(101, "Debit", "success", "hdfc",card);
		when(paymentRepository.save(paymentToAdd)).thenReturn(paymentToAdd);
		assertEquals(paymentToAdd, service.addPayment(paymentToAdd)); 
	}	

	/*
	 * 
	 * This method tests whether the payment details are updated or not
	 * 
	 */
	
	@Test
	void testUpdatePaymentShouldUpdatePaymentByIds() {
		Payment paymentToUpdate = new Payment();
		paymentToUpdate.setPaymentId(104L); 
		when(paymentRepository.existsById(104L)).thenReturn(true);
		when(paymentRepository.findById(104L)).thenReturn(Optional.of(paymentToUpdate));
		when(paymentRepository.save(paymentToUpdate)).thenReturn(paymentToUpdate);
		Payment payment = service.updatePayment(104L, paymentToUpdate);
		assertEquals(payment, paymentToUpdate);
	}
	
	/*
	 * 
	 * This method tests whether the payment details are deleted or not
	 * 
	 */
	
	@Test
	void testRemovePaymentShouldDeletePayment() throws Exception{
		Card card1 = new Card(202, "Suma", "3738 3450 2987", LocalDate.of(2025, 5, 28), 158);
		Payment payment = new Payment(101, "Debit", "success", "hdfc",card1);
		long paymentId = payment.getPaymentId();
		Optional<Payment> paymentToDelete = Optional.of(payment);
		Mockito.when(paymentRepository.findById(paymentId)).thenReturn(paymentToDelete );		
		payment = service.removePayment(paymentId);
		Optional<Payment> payment1 = Optional.of(payment);
	    assertEquals(payment1, paymentToDelete);
	} 	

	/*
	 * 
	 * This method is used to get the payment details based on paymentId
	 * 
	 */
	
	@Test
	void testGetPaymentDetailsBasedOnId() {
		Card card3 = new Card(204, "Suji", "4739 5470 2989", LocalDate.of(2023, 7, 15), 147);
		Payment payment = new Payment(101, "Debit", "success", "hdfc",card3);
		long paymentId = payment.getPaymentId();
		Optional<Payment> getPayment = Optional.of(payment);
		Mockito.when(paymentRepository.findById(paymentId)).thenReturn(getPayment);
		Payment payment1 = service.getPaymentDetails(paymentId);
		Optional<Payment> payment2 = Optional.of(payment1);
		assertEquals(payment2, getPayment);
	    	
	}

	/*
	 * 
	 * This method is used to get all the payment details 
	 * 
	 */
	
	@Test
	void testGetAllPaymentDetailsShouldGiveAllPayments() {
		Card card4 = new Card(204, "Suji", "4739 5470 2989", LocalDate.of(2023, 7, 15), 147);
		Payment payment1= new Payment(101, "Debit", "success", "hdfc",card4);
		Payment payment2 = new Payment(101, "Debit", "success", "hdfc",card4);
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(payment1);
		payments.add(payment2);
		Mockito.when(paymentRepository.findAll()).thenReturn(payments);
		assertEquals(service.getAllPaymentDetails(), payments);
	}

}
