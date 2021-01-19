package com.cg.cars.beans;
/*
* 
* This is an entity class for Address module with getters, setters   
*   
*/
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
	
	private static final long serialVersionUID =1L;
	@Column(name="DOOR_NO")
	private String doorNo;
	@Column(name="STREET")
	private String street;
	@Column(name="AREA")
	private String area;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="PINCODE")
	private int pincode;
	
	public Address(){}
	
	public Address(String doorNo,String street, String area, String city, String state, int pincode) {
		this.doorNo=doorNo;
		this.street=street;
		this.area=area;
		this.city=city;
		this.state=state;
		this.pincode=pincode;		
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
	
