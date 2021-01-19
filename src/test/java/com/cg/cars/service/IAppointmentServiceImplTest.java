package com.cg.cars.service;

/** The IAppointmentServiceImplTest class provides testing of IPaymentServiceImpl layer
 *   
 * 
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.beans.Address;
import com.cg.cars.beans.Appointment;
import com.cg.cars.beans.Card;
import com.cg.cars.beans.Customer;
import com.cg.cars.beans.Payment;
import com.cg.cars.dao.IAppointmentRepository;
import com.cg.cars.exception.AppointmentNotFoundException;
import com.cg.cars.exception.DuplicateAppointmentFoundException;

@SpringBootTest
class IAppointmentServiceImplTest {

	@Autowired
	private IAppointmentService service;

	@MockBean
	private IAppointmentRepository appRepository;

	/*
	 * 
	 * This method tests whether the appointment details are added or not
	 * 
	 */

	@Test
	void testForAddingTheAppointmentSuccessfully() throws DuplicateAppointmentFoundException {
		Address address = new Address("321", "Sri krishna nagar", "Cbe", "Cbe", "Tamilnadu", 5556);
		Customer c = new Customer(1, "Karthi", "abc@gmail.com", "988754321", LocalDate.of(1999, 9, 8), address);
		Card card = new Card(8944L, "HDFC", "78994509", LocalDate.of(1999, 9, 8), 108);
		Payment p = new Payment(101, "Debit", "success", "hdfc",card);
		Appointment app = new Appointment(101908L, "TamilNadu", "home", LocalDate.of(2020, 12, 15),
				LocalTime.of(11, 30), c, p);
		System.out.println(app);
		when(appRepository.save(app)).thenReturn(app);
		assertEquals(app, service.addAppointment(app));
	}

	/*
	 * 
	 * This method tests whether the appointment details are updated or not
	 * 
	 */
	@Test
	void testForUpdatingAppointmentSuccessfully() throws AppointmentNotFoundException {
		Appointment appToUpdate = new Appointment();
		appToUpdate.setAppointmentId(100L);
		when(appRepository.existsById(104L)).thenReturn(true);
		when(appRepository.findById(104L)).thenReturn(Optional.of(appToUpdate));
		when(appRepository.save(appToUpdate)).thenReturn(appToUpdate);
		Appointment app = service.updateAppointment(104L, appToUpdate);
		assertEquals(app, appToUpdate);
	}	
	
	/*
	 * 
	 * This method tests whether the appointment details are deleted or not
	 * 
	 */

	@Test 
	void testForRemovingTheAppointmentSuccessfully() throws AppointmentNotFoundException{ 
		Address address = new Address("321","Sri krishna nagar","Cbe","Cbe","Tamilnadu",5556); 
		Customer c = new Customer(1,"Karthi", "abc@gmail.com","988754321",LocalDate.of(1999, 9, 8),address); 
		Card card = new Card(8944L, "HDFC", "78994509", LocalDate.of(1999, 9, 8), 108); 
		Payment p = new Payment(101, "Debit", "success", "hdfc",card);
		Appointment app = new Appointment(101908L,"TamilNadu","home",LocalDate.of(2020, 12,	15),LocalTime.of(11, 30),c,p); 
		long appointmentId = app.getAppointmentId();
	    Optional<Appointment> appToDelete=Optional.of(app);
	    Mockito.when(appRepository.findById(appointmentId)).thenReturn(appToDelete);
	    app = service.removeAppointment(appointmentId);
	    Optional<Appointment> app1 = Optional.of(app);
	    assertEquals(app1, appToDelete);
	  
	  }

	/*
	 * 
	 * This method is used to get all the appointment details 
	 * 
	 */
	
	@Test
	void testGetAllAppointmentDetails() {
		Address address = new Address("321", "Sri krishna nagar", "Cbe", "Cbe", "Tamilnadu", 5556);
		Customer c = new Customer(1, "Karthi", "abc@gmail.com", "988754321", LocalDate.of(1999, 9, 8), address);
		Card card = new Card(8944L, "HDFC", "78994509", LocalDate.of(1999, 9, 8), 108);
		Payment p = new Payment(101, "Debit", "success", "hdfc",card);
		Appointment app = new Appointment(101908L, "TamilNadu", "home", LocalDate.of(2020, 12, 15),
				LocalTime.of(11, 30), c, p);
		Appointment app2 = new Appointment(101909L, "AP", "home", LocalDate.of(2020, 12, 15), LocalTime.of(11, 30), c,
				p);
		List<Appointment> apps = new ArrayList<Appointment>();
		apps.add(app);
		apps.add(app2);
		Mockito.when(appRepository.findAll()).thenReturn(apps);
		assertEquals(service.getAllAppointments(), apps);
	}

	/*
	 * 
	 * This method is used to get all the open appointment details 
	 * 
	 */
	
	@Test
	void testGetOpenAppointmentDetails() {
		Address address = new Address("321", "Sri krishna nagar", "Cbe", "Cbe", "Tamilnadu", 5556);
		Customer c = new Customer(1, "Karthi", "abc@gmail.com", "988754321", LocalDate.of(1999, 9, 8), address);
		Card card = new Card(8944L, "HDFC", "78994509", LocalDate.of(1999, 9, 8), 108);
		Payment p= new Payment(101, "Debit", "success", "hdfc",card);
		Appointment app = new Appointment(101908L, "TamilNadu", "home", LocalDate.of(2020, 12, 15),
				LocalTime.of(11, 30), c, p);
		Appointment app2 = new Appointment(101909L, "AP", "home", LocalDate.of(2020, 12, 15), LocalTime.of(11, 30), c,
				p);
		List<Appointment> apps = new ArrayList<Appointment>();
		apps.add(app);
		apps.add(app2);
		Mockito.when(appRepository.findAll()).thenReturn(apps);
		assertEquals(service.getOpenAppointments(), apps);
	}

}
