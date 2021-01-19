package com.cg.cars.beans;
/**This is an entity class for Payment module with getters, setters
* 
*  @author Nagasri's 
*   
*/

 

import java.time.LocalDate;

 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @Column(name="ID")
    private long orderId;
    @Column(name="AMOUNT")
    private double amount;
    @Column(name="BILLING_DATE")
    private LocalDate billingDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CUSTOMER_DETAILS")
    private Customer customer;
    
    private String payment;
    public Order() {
        super();
    }
	public Order(long orderId, double amount, LocalDate billingDate, Customer customer, String payment) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
		this.payment = payment;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + ", payment=" + payment + "]";
	}
   
    
    }
