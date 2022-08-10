package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.BankModel;
import com.model.RecievedPayments;

public interface PaymentsRepo extends JpaRepository<RecievedPayments, Integer> {

}
