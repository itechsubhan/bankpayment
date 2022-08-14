package com.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.BankModel;
import com.model.RecievedPayments;
import com.model.RecieverModel;
import com.repo.BankRepo;
import com.repo.PaymentsRepo;
import com.repo.RecieverRepo;

@Service
public class BankService {
	@Autowired
	BankRepo bankrepo;

	@Autowired
	RecieverRepo reciverrepo;

	@Autowired
	PaymentsRepo recievedpayments;

	public List<String> getAllNames() {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		List<BankModel> b = bankrepo.findAll();
		for (BankModel itr : b) {
			names.add(itr.getAccount_Holder_Name());
			System.out.println();
		}

		return names;

	}
	public List<BankModel> getAllrows() {
		// TODO Auto-generated method stub
		List<BankModel> b = bankrepo.findAll();
		return b;
	}
	public List<RecievedPayments> getAllTransactions() {
		// TODO Auto-generated method stub
		List<RecievedPayments> transarray = recievedpayments.findAll();
		return transarray;
	}

	
//	the code to get all the payments
	/*
	 * 	int paymentNO;
	String BIC;
	String paymentCode;
	int amount;
	 * */
	
//	public List<String> getAllTransactions() {
//		// TODO Auto-generated method stub
//		List<String> transactionObj = new ArrayList<String>();
//		List<> b = bankrepo.findAll();
//		for (BankModel itr : b) {
//			names.add(itr.getAccount_Holder_Name());
//			System.out.println();
//		}
//
//		return transactionObj;
//
//	}
	
//	public boolean checkEligiblity(String name) {
//		//  check the eligiblity if sanction is placed on the reciever or not
////		if(name)
//		
//		
////		do this at frontend
//		
//		return false;
//	}

	public BankModel checkfound(String custid) {
		// TODO Auto-generated method stub
//		this returns the account holders name
		BankModel b = bankrepo.findById(custid).orElse(null);
		return b;
	}

	public String checkReciever(String BIC) {
//		this returns the account holders name of reciever
		RecieverModel R = reciverrepo.findById(BIC).orElse(null);
		return R.getRecInstitutionName();
	}

//	for checking balance
	public int checkBalance(String custid) {
		try {
			BankModel b = bankrepo.findById(custid).orElse(null);			
			return b.getBalance();
		} catch (Exception e) {
			return 0;
//			return e;
			// TODO: handle exception
		}
	}

	public boolean checkOverDraft(String custid) {
		BankModel b = bankrepo.findById(custid).orElse(null);
		String availablity = b.getOverdraft().toLowerCase();
		if (availablity.equals("yes"))
			return true;
		else
			return false;
	}

	public int sendMoney(String custid, int sendBalance , String paycode) {
		// TODO Auto-generated method stub
		BankModel b = bankrepo.findById(custid).orElse(null);
		int availableMoney = checkBalance(custid);
		boolean overdraftcheck = checkOverDraft(custid);

			if (availableMoney > sendBalance || overdraftcheck) {

//			TODO check eligiblity function to be stuffed here
//			check sanction in frontend
//			then select the reciever

//			saving the reciever
				RecievedPayments transaction = new RecievedPayments(custid,paycode,sendBalance);
				
				recievedpayments.save(transaction);

				int availableBalanceAfterSending = availableMoney - sendBalance;
				b.setBalance(availableMoney - sendBalance);
				bankrepo.save(b);
				return availableBalanceAfterSending;
		} else
			return availableMoney;
	}

}

//public int sendMoney(RecievedPayments BIC,String custid, int sendBalance) {
//	// TODO Auto-generated method stub
//	BankModel b = bankrepo.findById(custid).orElse(null);
//	int availableMoney = checkBalance(custid);
//	boolean overdraftcheck = checkOverDraft(custid);
//
//		if (availableMoney > sendBalance || overdraftcheck) {
//
////		TODO check eligiblity function to be stuffed here
////		check sanction in frontend
////		then select the reciever
//
////		saving the reciever
//			recievedpayments.save(BIC);
//
//			int availableBalanceAfterSending = availableMoney - sendBalance;
//			b.setBalance(availableMoney - sendBalance);
//			bankrepo.save(b);
//			return availableBalanceAfterSending;
//	} else
//		return availableMoney;
//}

//}

//public String sendBalance(String customer_ID, int sendingMoney) {
////code to subtract balance and check the transfer validity
////Optional<BankModel> customer = bankrepo.findById(customer_ID);
//
////trying code
//String res = "";
//
////try {
//	BankModel existBankAccount = bankrepo.findById(customer_ID).orElse(null);
//	
////	List<BankModel> existBankAccount = bankrepo.findById(customer_ID);
////	List<BankModel> b = bankrepo.findById(customer_ID);
//	if((existBankAccount != null) && (existBankAccount.getBalance() > sendingMoney )||(existBankAccount.getOverdraft() == "yes") ) {
////		return "transaction success";
//		
//		res = "balance to be detucted success";
//	}
//    else {
//        res = "Account not Found";
//    }
//    
////}catch(Exception e) {
////    res = "problem occured while sending money";
////    e.printStackTrace();
////}
//
//
//return res;

//
//}
