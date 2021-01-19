package com.cg.cars.beans;
/**This is an entity class for Payment module with getters, setters
* 
*  @author Jayasree's 
*   
*/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {
	
	@Id	
	@Column(name = "PAYMENT_ID")
	private long paymentId;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "BANKNAME")
	private String bankName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "card_id")
	private Card card;
	
	public Payment() {
		super();
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Payment(long paymentId, String type, String status, String bankName, Card card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.bankName = bankName;
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", bankName=" + bankName
				+ ", card=" + card + "]";
	}
	

}