package com.cg.cars.service;
/** This is an interface which defines CRUD methods for Appointment service
 * 
 * 
 *
 */
import java.util.List;

import com.cg.cars.exception.AppointmentNotFoundException;
import com.cg.cars.exception.DuplicateAppointmentFoundException;
import com.cg.cars.beans.Appointment;

public interface IAppointmentService {
		public Appointment addAppointment(Appointment appointment) throws DuplicateAppointmentFoundException;
	    public Appointment removeAppointment(long id) throws AppointmentNotFoundException; 
		public Appointment updateAppointment(long id, Appointment appointment)throws AppointmentNotFoundException;
		public Appointment getAppointment(long id)throws AppointmentNotFoundException;
		public List<Appointment> getAllAppointments(); 
		public List<Appointment> getOpenAppointments();
	
}