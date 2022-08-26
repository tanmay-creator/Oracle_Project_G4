package com.app.service;
import java.util.List;

import com.app.model.HdccModel;

public interface HdccService {
	public List<HdccModel> findAllAcc();
	public HdccModel addAccount(HdccModel hdccModel);
	public boolean getEkyc(long ekyc);
	public HdccModel findEkyc(long ekyc);
}
