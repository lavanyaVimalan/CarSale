package com.cg.cars.beans;
/*
* 
* This is an entity class for Customer module with getters, setters   
*   
*/
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="Customer_Details")
public class Customer implements Serializable {
	private static final long serialVersionUID =1L;
	@Id
	@Column(name="ID")
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="CONTACT_NO")
	private String contactNo;
	@Column(name="DARE_OF_BIRTH")
	private  LocalDate dob;

	@Embedded
	private Address address;
	
	@Transient
	private List<Order> orders=new ArrayList<Order>();
	
	@Transient
	private List<Appointment> appointments=new ArrayList<Appointment>();
	
	@Transient
	private List<Car> car=new ArrayList<Car>();	
	
	public Customer() {
		
	}
	public Customer(long custId, String name, String email, String contactNo, LocalDate dob, Address address) {
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.contactNo=contactNo;
		this.dob=dob;
		this.address=address;
	}
	public Customer(long custId, String name, String email, String contactNo, Car car2) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
	}
	public Customer(long id, String name, String email, String contactNo, LocalDate dob, Address address,
            List<Order> orders, List<Appointment> appointments) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.dob = dob;
        this.address = address;
        this.orders = orders;
        this.appointments = appointments;
    }
	public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }


	public long getcustId() {
		return id;
	}
	public void setcustId(long string) {
		this.id = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + "]";
	}
	public Customer(long custId, String name, String email, String contactNo, LocalDate dob, Address address,
			List<Car> car) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
		this.car = car;
	}
	public Customer(long custId, String name, String email, String contactNo, LocalDate dob) {
		super();
		this.id= id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
	}

	
	
	
}
	


