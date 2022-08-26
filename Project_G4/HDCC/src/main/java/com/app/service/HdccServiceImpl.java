package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.HdccModel;
import com.app.repository.HdccRepo;

@Service
@Transactional
public class HdccServiceImpl implements HdccService {

	@Autowired
	HdccRepo hdccRepo;
	@Override
	public HdccModel addAccount(HdccModel hdccModel) {
		return hdccRepo.save(hdccModel);
	}
	@Override
	public boolean getEkyc(long ekyc) {
		
		return hdccRepo.existsByEkyc(ekyc);
	}
	@Override
	public List<HdccModel> findAllAcc() {
		return hdccRepo.findAll() ;
	}
	@Override
	public HdccModel findEkyc(long ekyc) {
		return hdccRepo.findByEkyc(ekyc);
	}

}
