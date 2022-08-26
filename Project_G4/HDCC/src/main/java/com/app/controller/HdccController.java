package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.HdccModel;
import com.app.model.HdccResponse;
import com.app.service.HdccService;

@RestController
@RequestMapping("/hdcc")
public class HdccController {
	@Autowired
	private HdccService hdccService;
	

	@GetMapping("/accounts")
	public  ResponseEntity<List<HdccModel>>  getAllAccounts(){
		 return ResponseEntity.ok(hdccService.findAllAcc());
	}
	
	@PostMapping("/accounts")
    public ResponseEntity<HdccModel> addCustomer(@RequestBody HdccModel hdccModel){
        return new ResponseEntity<>(hdccService.addAccount(hdccModel), HttpStatus.CREATED);
    }
	
	@GetMapping("/accounts/{ekyc}")
	public boolean checkEkyc(@PathVariable long ekyc)
	{
		return hdccService.getEkyc(ekyc);
	}
	
	@GetMapping("/hdcc-balance/{ekyc}")
	public ResponseEntity<HdccResponse> getBalance(@PathVariable long ekyc)
	{
		HdccModel hdccResp = hdccService.findEkyc(ekyc);
		HdccResponse resp = new HdccResponse();
		resp.setAccNo(hdccResp.getAccountNo());
		resp.setBalance(hdccResp.getBalance());
		return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
	}
}
