package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.BankModel;

public interface BankRepo extends JpaRepository<BankModel, String> {

}
