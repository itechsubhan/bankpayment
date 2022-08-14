package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.BankModel;
import com.model.RecievedPayments;
import com.repo.BankRepo;
import com.service.BankService;

@RestController
@CrossOrigin(origins = "*" )
//@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If-Match")
public class BankController {
	@Autowired
	BankService bankservice;
	
	@Autowired
	BankRepo bankrepo;

	@GetMapping("/")
	public String Home() {
		return "welcome to the worst app made for a bank";
	}
	@GetMapping("/all")
	public List<String> allnames(){
		return bankservice.getAllNames();
	}
	
	
	@GetMapping("/allrows")
	public List<BankModel> getAllrows(){
		return bankservice.getAllrows();
	}
	@GetMapping("/allTransctions")
	public List<RecievedPayments> getAllTransactions(){
		return bankservice.getAllTransactions();
	}
	
//	@PostMapping("/sendBalance")
//    public String sendbalance(@RequestBody BankModel obj,
//    		@RequestParam int sendingMoney
//    		) {
//		System.out.println(obj.getCustomer_ID());
//		System.out.println(sendingMoney);
//		return "hey";
////		return bankservice.sendBalance(obj.getCustomer_ID(),sendingMoney);
//		
//
//    }
//	
	@GetMapping("/checkfound")
	public BankModel checks(@RequestParam String custid) {
		return bankservice.checkfound(custid);
	}
	@GetMapping("/details/{id}")
	public BankModel getSenderDetailsById(@PathVariable String id) {
		
		return bankrepo.findById(id).orElse(null);
		
	}
	@GetMapping("/reciever/{id}")
	public String checkReciever(@PathVariable String id) {
		
		return bankservice.checkReciever(id);
		
	}

	
	@GetMapping("/checkBalance")
	public int checkbal(@RequestParam String custid) {
		return bankservice.checkBalance(custid);
	}

	@CrossOrigin(origins = "*" )
	@GetMapping("/sendMoney")
//	sendMoney(String custid,int sendBalance)
	public int sendMoney(@RequestParam String custid,int sendBalance,String paycode) {
		return bankservice.sendMoney(custid, sendBalance,paycode );
	}
	
	
	
	
//	@CrossOrigin(origins = "*" )
//	String custid;int sendBalance;String paycode;
//	@GetMapping("/sendMoneyfinal/"+custid+"/"+)
////	sendMoney(String custid,int sendBalance)
//	public int sendMoney(@RequestParam String custid,int sendBalance,String paycode) {
//		return bankservice.sendMoney(custid, sendBalance,paycode );
//	}
//	@CrossOrigin(origins = "http://localhost:4200/")
//	@PostMapping("/sendMoney")
////	sendMoney(String custid,int sendBalance)
//	public int sendMoney(@RequestBody RecievedPayments BIC,@RequestParam String custid,int sendBalance,int pno) {
//		return bankservice.sendMoney(BIC,custid, sendBalance );
//	}
//	

}
