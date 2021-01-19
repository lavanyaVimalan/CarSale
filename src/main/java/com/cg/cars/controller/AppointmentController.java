package com.cg.cars.controller;
/** This is a Controller class for Payment module 
 * 
 *  
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.exception.AppointmentNotFoundException;
import com.cg.cars.exception.DuplicateAppointmentFoundException;
import com.cg.cars.beans.Appointment;
import com.cg.cars.service.IAppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private IAppointmentService service;
	
	/** This method adds the appointment details 
	 * 
	 * @param Appointment entity details
	 * 
	 * 
	 */
	
	//http://localhost:9090/appointments/addAppointment - method POST
	@PostMapping("/addAppointment")
	public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment) throws DuplicateAppointmentFoundException{
		Appointment appointment1=service.addAppointment(appointment);
		ResponseEntity<String> response;
		if(appointment1!=null) {
			response=new ResponseEntity<String>("Appointment with"+appointment.getAppointmentId()+" is added.",HttpStatus.CREATED);
		}else {
			response=new ResponseEntity<String>("Appointment with"+appointment.getAppointmentId()+"is not added.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
     
	/** This method deletes the appointment details 
	 * 
	 * @param Appointment entity details and Appointment - id
	 * 
	 * 
	 */
	
	// http://localhost:9090/appointments/deleteAppointment - method DELETE
	@DeleteMapping("/deleteAppointment/{id}")
	public ResponseEntity<String> removeAppointment(@PathVariable(value="id") long id) throws AppointmentNotFoundException{
		Appointment appointment=service.removeAppointment(id);
		ResponseEntity<String> response;
		if(appointment!=null) {
			response=new ResponseEntity<String>("Appointment with"+appointment.getAppointmentId()+" is deleted.",HttpStatus.CREATED);
		}else {
			response=new ResponseEntity<String>("Appointment with"+appointment.getAppointmentId()+"is not deleted.",HttpStatus.NOT_FOUND);
		}
		return response;
		}
  
	/** This method updates the Appointment details 
	 * 
	 * @param Appointment entity details and Appointment - id
	 * 
	 * 
	 */
	
	//http://localhost:9090/appointments/updateAppoitment - method UPDATE
	@PutMapping("/updateAppoitment/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable(value="id") long id,@RequestBody Appointment appointment) throws AppointmentNotFoundException {
		if(service.updateAppointment(id,appointment)!=null) {
			return new ResponseEntity<Appointment>(appointment,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity("Appointment with"+appointment.getAppointmentId()+"is not delet.",HttpStatus.NOT_FOUND);
		}
	}
	
	/** This method returns the appointment details
	 * 
	 * @param Appointment - id 
	 * 
	 * 
	 */
	
	// http://localhost:9090/appointments/getAppointment - method GET
	@GetMapping("/getAppointment/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable(value="id")long id) throws AppointmentNotFoundException{
		Appointment appointment=service.getAppointment(id);
		if(appointment==null) {
			 return new ResponseEntity("Appointment with"+appointment.getAppointmentId()+" is not found.",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Appointment>(appointment,HttpStatus.OK);
	}
	
	/** 
	 * 
	 *This method returns the list of appointment details  
	 * 
	 * 
	 */
	
	// http://localhost:9090/appointments/getAllAppointments- method GET
	@ResponseStatus(value=HttpStatus.OK)
	@GetMapping("/getAllAppointments")
	public List<Appointment> getAllAppointments(){
		return service.getAllAppointments();
	}
	
	/** 
	 * 
	 *This method returns the list of open appointment details  
	 * 
	 * 
	 */
	
	// http://localhost:9090/appointments/getOpenAppointments- method GET
	@ResponseStatus(value=HttpStatus.OK)
	@GetMapping("/getOpenAppointments")
	public List<Appointment> getOpenAppointments(){
		return service.getOpenAppointments();
	}
}