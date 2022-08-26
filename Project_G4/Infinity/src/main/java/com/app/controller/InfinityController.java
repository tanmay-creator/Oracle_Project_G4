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

import com.app.model.InfinityModel;
import com.app.model.InfinityResponse;
import com.app.service.InfinityService;

@RestController
@RequestMapping("/infinity")
public class InfinityController {
	@Autowired
	private InfinityService infinityService;	
	
	@GetMapping("/accounts")
	public  ResponseEntity<List<InfinityModel>>  getAllAccounts(){
		 return ResponseEntity.ok(infinityService.findAllAcc());
	}
	@PostMapping("/accounts")
    public ResponseEntity<InfinityModel> addCustomer(@RequestBody InfinityModel infinityModel){
        return new ResponseEntity<>(infinityService.addAccount(infinityModel), HttpStatus.CREATED);
    }
	
	@GetMapping("/accounts/{ekyc}")
	public boolean checkEkyc(@PathVariable long ekyc)
	{
		return infinityService.getEkyc(ekyc);
	}
	@GetMapping("/infinity-balance/{ekyc}")
	public ResponseEntity<InfinityResponse> getInfyBalance(@PathVariable long ekyc)
	{
		InfinityModel infinityResp = infinityService.findEkyc(ekyc);
		InfinityResponse resp = new InfinityResponse();
		resp.setAccNo(infinityResp.getAccountNo());
		resp.setBalance(infinityResp.getBalance());
		return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
	}
}
