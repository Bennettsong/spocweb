package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.Charge_StandardDao;
import com.spoc.po.Charge_Standard;

@Service("chargeStandardService")
public class ChargeStandardService {

	@Autowired
	private Charge_StandardDao charge_StandardDao;
	
	public void addChargeStandard(Charge_Standard cs)
	{
		charge_StandardDao.doChargeStandard(cs);
	}
	
	public void deleteChargeStandard(String[] str)
	{
		int csid=0;
		for(int i=0;i<str.length;i++)
		{
			csid=Integer.valueOf(str[i]);
			charge_StandardDao.deleteChargeStandard(csid);;
		}
	}
	
	public List<Charge_Standard> getTypes()
	{
		return charge_StandardDao.getTypes();
	}
	
	
	
	public void update(Charge_Standard cs)
	{
		charge_StandardDao.updateChargeStandard(cs);
	}
}
