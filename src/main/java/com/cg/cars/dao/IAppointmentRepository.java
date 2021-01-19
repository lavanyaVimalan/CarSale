package com.cg.cars.dao;
/* 
 * 
 * This is a repository class for Appointment module 
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cars.beans.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment,Long>{

}
