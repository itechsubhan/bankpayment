//package com.model;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class BankModel {
//	@Id
//	String CustomerName;
//	String AccountHolderName;
//	
//	
//
//}
package com.model;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class BankModel {
	@Id
	String Customer_ID;
	String Account_Holder_Name;
	int balance;
	String Overdraft;
	public String getCustomer_ID() {
		return Customer_ID;
	}
	public void setCustomer_ID(String customer_ID) {
		Customer_ID = customer_ID;
	}
	public String getAccount_Holder_Name() {
		return Account_Holder_Name;
	}
	public void setAccount_Holder_Name(String account_Holder_Name) {
		Account_Holder_Name = account_Holder_Name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getOverdraft() {
		return Overdraft;
	}
	public void setOverdraft(String overdraft) {
		Overdraft = overdraft;
	}
	public BankModel(String customer_ID, String account_Holder_Name, int balance, String overdraft) {
		super();
		Customer_ID = customer_ID;
		Account_Holder_Name = account_Holder_Name;
		this.balance = balance;
		Overdraft = overdraft;
	}
	public BankModel() {
		super();
	}
	
		

}
