package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.RecievedPayments;
import com.service.BankService;

@RestController
public class BankController {
	@Autowired
	BankService bankservice;
	
	@GetMapping("/")
	public String Home() {
		return "welcome to the worst app made for a bank";
	}
	
	@GetMapping("/all")
	public List<String> allnames(){
		return bankservice.getAllNames();
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
	@PostMapping("/checkfound")
	public String checks(@RequestParam String custid) {
		return bankservice.checkfound(custid);
	}
	
	@PostMapping("/checkBalance")
	public int checkbal(@RequestParam String custid) {
		return bankservice.checkBalance(custid);
	}
	@PostMapping("/sendMoney")
//	sendMoney(String custid,int sendBalance)
	public int sendMoney(@RequestBody RecievedPayments BIC,@RequestParam String custid,int sendBalance) {
		return bankservice.sendMoney(BIC,custid, sendBalance );
	}
	

}
