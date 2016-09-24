package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.ApplyDao;
import com.spoc.po.Affair;
import com.spoc.po.Apply;

@Service("applyService")
public class ApplyService {

	@Autowired
	private ApplyDao applyDao;
	
    public void userApply(Apply apply)
    {
    	applyDao.doApply(apply);
    }
    
    public List<Apply> getApply()
    {
    	return applyDao.getApply();
    }
    public void updateApply(int apply_id)
    {
		applyDao.updateApply(apply_id);
    }
    public void deleteAffair(String[] str)
	{
		int apply_id=0;
		for(String id:str)
		{
			apply_id=Integer.valueOf(id);
			applyDao.deleteApply(apply_id);
		}
	}
	
}
