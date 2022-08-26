package com.app.service;

import java.util.List;

import com.app.model.InfinityModel;

public interface InfinityService {
	public List<InfinityModel> findAllAcc();
	public InfinityModel addAccount(InfinityModel infinityModel);
	public boolean getEkyc(long ekyc);
	public InfinityModel findEkyc(long ekyc);
}
