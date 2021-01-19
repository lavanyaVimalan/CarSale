package com.cg.cars.beans;

/*This is an entity class for Car module with getters, setters
 * 
 * @author Rukumbai's
 * 
 * */
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Car_Details11")
public class Car {
	
	@Id
	@Column(name="ID")
	private long carId;
	@Column(name="BRAND") 
	private String brand;
	@Column(name="MODEL") 
	private String model;
	@Column(name="VARIANT") 
	private String variant;
	@Column(name="REG_YEAR")
	private LocalDate registrationYear;
	@Column(name="REG_STATE") 
	private String registrationState;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Customer_Details")
	private Customer customer;
	
	
	
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public LocalDate getRegistrationYear() {
		return registrationYear;
	}
	public void setRegistrationYear(LocalDate registrationYear) {
		this.registrationYear = registrationYear;
	}
	public String getRegistrationState() {
		return registrationState;
	}
	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}

	
	public Car() {
		super();
	}
	
	public Car(long carId, String brand, String model, String variant, String registrationState) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.registrationState = registrationState;
	}
	public Car(long carId, String brand, String model, String variant, LocalDate registrationYear,
			String registrationState, Customer customer) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.registrationYear = registrationYear;
		this.registrationState = registrationState;
		this.customer = customer;
	}
	public Car(long carId, String brand, String model, String variant, LocalDate registrationYear,
			String registrationState) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.registrationYear = registrationYear;
		this.registrationState = registrationState;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", brand=" + brand + ", model=" + model + ", variant=" + variant
				+ ", registrationYear=" + registrationYear + ", registrationState=" + registrationState + "]";
	}
	

	

	
	
	

}