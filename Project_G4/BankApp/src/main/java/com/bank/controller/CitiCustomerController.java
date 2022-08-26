package com.bank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank.dto.CitiCustomerDto;
import com.bank.exception.AccountNotFoundException;
import com.bank.model.CitiBal;
import com.bank.model.CitiCustomer;
import com.bank.model.CityResponse;
import com.bank.model.HdccBal;
import com.bank.model.InfinityBal;
import com.bank.repository.CitiCustomerRepo;
import com.bank.service.CitiCustomerService;

@RestController
@RequestMapping("/citi")
public class CitiCustomerController {

	@Autowired
	private CitiCustomerService citiCustomerService;

	@Autowired
	private CitiCustomerRepo citiCustomerRepo;
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/accounts")
	public ResponseEntity<List<CitiCustomer>> getAllAccounts() {
		return ResponseEntity.ok(citiCustomerService.findAllAcc());
	}

	@GetMapping("/accounts/{accountNo}")
	public ResponseEntity<CitiCustomer> getByAccount(@PathVariable int accountNo) throws AccountNotFoundException {
		return ResponseEntity.ok(citiCustomerService.findByAccNo(accountNo));
	}

	@GetMapping("/hdcc-ekyc/{ekycNo}")
	public boolean getByEkycNo(@PathVariable int ekycNo) {
		boolean hdccflag = restTemplate.getForObject("http://localhost:8091/bankapp/hdcc/accounts/" + ekycNo,
				Boolean.class);

		return hdccflag;

	}

	@GetMapping("/infinity-ekyc/{ekycNo}")
	public boolean getByEkycNoInfinity(@PathVariable int ekycNo) {
		boolean infinityflag = restTemplate.getForObject("http://localhost:8093/bankapp/infinity/accounts/" + ekycNo,
				Boolean.class);

		return infinityflag;

	}

	@PostMapping("/accounts")
	public ResponseEntity<CitiCustomer> addCustomer(@RequestBody @Valid CitiCustomerDto citiCustomerDto)
			throws AccountNotFoundException {
		boolean flag = restTemplate.getForObject(
				"http://localhost:8092/bankapp/citi/hdcc-ekyc/" + citiCustomerDto.getEkyc(), Boolean.class);
		boolean flag1 = restTemplate.getForObject(
				"http://localhost:8092/bankapp/citi/infinity-ekyc/" + citiCustomerDto.getEkyc(), Boolean.class);
		if (!flag1 && !flag) {
			throw new AccountNotFoundException("Account Can Not Be Created.");
		}

		return new ResponseEntity<>(citiCustomerService.addAccount(citiCustomerDto), HttpStatus.CREATED);

	}
	
	
	@GetMapping("/aggBal/{ekycNo}")
	public ResponseEntity<CityResponse> getBalance(@PathVariable long ekycNo) throws AccountNotFoundException
	{
		InfinityBal infinity = restTemplate.getForObject("http://localhost:8093/bankapp/infinity/infinity-balance/" + ekycNo,
				InfinityBal.class);
		HdccBal hdcc = restTemplate.getForObject("http://localhost:8091/bankapp/hdcc/hdcc-balance/" + ekycNo,
				HdccBal.class);
		CitiCustomer citiC = citiCustomerService.findEkyc(ekycNo);
		CitiBal citi = new CitiBal();
		citi.setAccNo(citiC.getAccountNo());
		citi.setBalance(citiC.getBalance());
		
		CityResponse res = new CityResponse();
		res.setCiti(citi);
		res.setHdcc(hdcc);
		res.setInfinity(infinity);
		return  new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	

}
