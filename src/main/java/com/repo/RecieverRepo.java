package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.RecieverModel;

public interface RecieverRepo extends JpaRepository<RecieverModel, String> {

}
