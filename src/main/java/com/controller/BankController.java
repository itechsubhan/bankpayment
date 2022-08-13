package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.BankModel;
import com.model.RecievedPayments;
import com.service.BankService;

@RestController
public class BankController {
	@Autowired
	BankService bankservice;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/")
	public String Home() {
		return "welcome to the worst app made for a bank";
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/all")
	public List<String> allnames(){
		return bankservice.getAllNames();
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/allrows")
	public List<BankModel> getAllrows(){
		return bankservice.getAllrows();
	}
	@CrossOrigin(origins = "http://localhost:4200/")
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
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/checkfound")
	public String checks(@RequestParam String custid) {
		return bankservice.checkfound(custid);
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/checkBalance")
	public int checkbal(@RequestParam String custid) {
		return bankservice.checkBalance(custid);
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/sendMoney")
//	sendMoney(String custid,int sendBalance)
	public int sendMoney(@RequestBody RecievedPayments BIC,@RequestParam String custid,int sendBalance) {
		return bankservice.sendMoney(BIC,custid, sendBalance );
	}
	

}
