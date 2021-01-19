package com.cg.cars.service;
/** The IAppointmentServiceImpl class provides access to repository methods to CRUD operations Appointment details 
 * 
 * 
 * 
 *
 */
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.beans.Appointment;
import com.cg.cars.dao.IAppointmentRepository;
import com.cg.cars.exception.AppointmentNotFoundException;
import com.cg.cars.exception.DuplicateAppointmentFoundException;
import com.cg.cars.exception.PaymentIdNotFoundException;



@Service
public class IAppointmentServiceImpl implements IAppointmentService {
	
	private static final Logger logger = LogManager.getLogger(IAppointmentServiceImpl.class);

	@Autowired
	private IAppointmentRepository appointmentRepository;
	

	public IAppointmentRepository getAppointmentRepository() {
		return appointmentRepository;
	}

	public void setAppointmentRepository(IAppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public Appointment addAppointment(Appointment appointment) throws DuplicateAppointmentFoundException {
		Appointment	app1 = appointmentRepository.save(appointment);
		if(app1 != null) {
			logger.info("Appointment Added Successfully...!");
			return app1;
		}
		else {
			throw new DuplicateAppointmentFoundException(DuplicateAppointmentFoundException.MESSAGE);
		}
	}

	@Override
	public Appointment removeAppointment(long id) throws AppointmentNotFoundException {
	 Appointment app2 = appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(AppointmentNotFoundException.MESSAGE));
	 logger.info("Appointment Deleted Successfully...!");	
	 appointmentRepository.delete(app2);
		return app2;
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) throws AppointmentNotFoundException {

		if(appointmentRepository.existsById(id)) {
			 logger.info("Appointment Updated Successfully...!");
			return appointmentRepository.save(appointment);
		}
		throw new PaymentIdNotFoundException(AppointmentNotFoundException.MESSAGE);
	
	}

	@Override
	public Appointment getAppointment(long id) throws AppointmentNotFoundException {
		 Optional<Appointment> app3 = appointmentRepository.findById(id);
		 if(app3.isPresent()) {
			 logger.info("Appointment retrieved Successfully...!");
			 return app3.get();
		 }
		 throw new AppointmentNotFoundException(AppointmentNotFoundException.MESSAGE);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		 logger.info("All Appointments retrieved  Successfully...!");
		return appointmentRepository.findAll();
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		 logger.info("Opened Appointment retrieved Successfully...!");
	        List<Appointment> appointmentList=appointmentRepository.findAll();
	        return appointmentList;
	}
}

	 
