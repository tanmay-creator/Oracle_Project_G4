package com.bank.service;

import java.util.List;

import com.bank.exception.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.CitiCustomerDto;
import com.bank.model.CitiCustomer;
import com.bank.repository.CitiCustomerRepo;

@Service
@Transactional
public class CitiCustomerServiceImpl implements CitiCustomerService{
	@Autowired
	CitiCustomerRepo citiCustomerRepo;
	
	@Override
	public List<CitiCustomer> findAllAcc() {
		return citiCustomerRepo.findAll() ;
	}

	@Override
	public CitiCustomer findByAccNo(int accNo) throws AccountNotFoundException {
		CitiCustomer citiCustomer= citiCustomerRepo.findByAccountNo(accNo);
		if(citiCustomer!=null){
            return citiCustomer;
        }else{
            throw new AccountNotFoundException("user not found with id : "+accNo);
        }
	}

	@Override
	public CitiCustomer addAccount(CitiCustomerDto citiCustomerDto) {
		CitiCustomer citiCustomer=CitiCustomer.build(citiCustomerDto.getAccountNo(), citiCustomerDto.getName(),
				citiCustomerDto.getPassportNo(), citiCustomerDto.getCurrentAddress(), citiCustomerDto.getMobileNo(), citiCustomerDto.getEmailId(), citiCustomerDto.getOccupation(), citiCustomerDto.getBirthDate(),
				citiCustomerDto.getPanNo(), citiCustomerDto.getAadharNo(), citiCustomerDto.getPassportNo(), citiCustomerDto.getEkyc(), citiCustomerDto.getBalance());
		return citiCustomerRepo.save(citiCustomer);
	}

	@Override
	public CitiCustomer findEkyc(long ekyc) {
		
		return citiCustomerRepo.findByEkyc(ekyc);
	}

}
