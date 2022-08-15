package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecievedPayments {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int paymentNO;
	String BIC;
	String RecieverAccountNo;
	String paymentCode;
	int amount;
	
	String CustomerId;
	public String getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	
	public String getRecieverAccountNo() {
		return RecieverAccountNo;
	}
	public void setRecieverAccountNo(String recieverAccountNo) {
		RecieverAccountNo = recieverAccountNo;
	}
	

	public String getBIC() {
		return BIC;
	}
	public void setBIC(String BIC) {
		this.BIC = BIC;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public RecievedPayments(String customerId,String bIC, String recieverAccountNo, String paymentCode, int amount) {
		super();
//		this.paymentNO = paymentNO;
		CustomerId=customerId;
		BIC = bIC;
		RecieverAccountNo = recieverAccountNo;
		this.paymentCode = paymentCode;
		this.amount = amount;
	}
	public RecievedPayments() {
		super();
	}
	public int getPaymentNO() {
		return paymentNO;
	}
	public void setPaymentNO(int paymentNO) {
		this.paymentNO = paymentNO;
	}

	
	

}
