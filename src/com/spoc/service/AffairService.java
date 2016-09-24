package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spoc.dao.AffairDao;
import com.spoc.po.Affair;

@Service("affairService")
public class AffairService {

	@Autowired
	private AffairDao affairDao;
	
	public void add(Affair affair)
	{
		affairDao.add(affair);
		
	}
	
	public List<Affair> getAffairs()
	{
		return affairDao.getAffairs();
	}
	
	public void updateAffair(int aff_id,String dealname)
	{
		affairDao.updateAffair(aff_id, dealname);
	}
	
	public void deleteAffair(String[] str)
	{
		int aff_id=0;
		for(String id:str)
		{
			aff_id=Integer.valueOf(id);
			affairDao.deleteAffair(aff_id);
		}
	}
}
