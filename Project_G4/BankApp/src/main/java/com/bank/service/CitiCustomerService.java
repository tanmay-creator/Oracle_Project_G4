package com.bank.service;

import java.util.List;

import com.bank.exception.AccountNotFoundException;

import com.bank.dto.CitiCustomerDto;
import com.bank.model.CitiCustomer;


public interface CitiCustomerService {
	
	public List<CitiCustomer> findAllAcc();
	public CitiCustomer findByAccNo(int accNo) throws AccountNotFoundException;
	public CitiCustomer addAccount(CitiCustomerDto citiCustomerDto);
	public CitiCustomer findEkyc(long ekyc);
    
}
