package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.CitiCustomer;

@Repository
public interface CitiCustomerRepo extends JpaRepository<CitiCustomer,Integer>,CrudRepository<CitiCustomer,Integer>{
	public CitiCustomer findByAccountNo(int accNo);
	public CitiCustomer findByEkyc(long ekyc);
}