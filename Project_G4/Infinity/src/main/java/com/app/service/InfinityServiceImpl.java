package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.InfinityModel;
import com.app.repository.InfinityRepo;

@Service
@Transactional
public class InfinityServiceImpl implements InfinityService{
	@Autowired
	InfinityRepo infinityRepo;

	@Override
	public InfinityModel addAccount(InfinityModel infinityModel) {
		return infinityRepo.save(infinityModel);
	}

	@Override
	public boolean getEkyc(long ekyc) {
		return infinityRepo.existsByEkyc(ekyc);
	}

	@Override
	public List<InfinityModel> findAllAcc() {
		return infinityRepo.findAll() ;
	}

	@Override
	public InfinityModel findEkyc(long ekyc) {
		try {
		return infinityRepo.findByEkyc(ekyc);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	
	

}
