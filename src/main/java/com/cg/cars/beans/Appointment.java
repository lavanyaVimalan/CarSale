package com.cg.cars.beans;
/*
* 
* This is an entity class for Appointment module with getters, setters   
*   
*/
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Appointment_Details")
public class Appointment {
	
	@Id
	@Column(name="ID")
	private long appointmentId;
	@Column(name="LOCATION")
	private String location;
	@Column(name="INSPECT_TYPE")
	private String inspectionType;
	@Column(name="PREFERRED_Date")
	private LocalDate preferredDate;
	@Column(name="PREFERRED_TIME")
	private LocalTime preferredTime;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Customer_Details")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getInspectionType() {
		return inspectionType;
	}
	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}
	public LocalDate getPreferredDate() {
		return preferredDate;
	}
	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}
	public LocalTime getPreferredTime() {
		return preferredTime;
	}
	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Appointment(long appointmentId, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, Customer customer, Payment payment) {
		super();
		this.appointmentId = appointmentId;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.customer = customer;
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", location=" + location + ", inspectionType="
				+ inspectionType + ", preferredDate=" + preferredDate + ", preferredTime=" + preferredTime
				+ ", customer=" + customer + ", payment=" + payment + "]";
	}
	public Appointment() {
		super();
	}
	
	

}
