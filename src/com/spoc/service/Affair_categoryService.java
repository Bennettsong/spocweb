package com.spoc.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.Affair_categoryDao;
import com.spoc.dao.Charge_StandardDao;
import com.spoc.po.Affair_category;
import com.spoc.po.Member;

@Service("affair_categoryService")
public class Affair_categoryService {

	@Autowired
	private Affair_categoryDao affair_categoryDao;
	@Autowired
	private Charge_StandardDao charge_StandardDao;
	
	public List<Affair_category> getAffairCa()
	{
		return affair_categoryDao.getAffairCa();
	}
	
	public Affair_category getAffairType(String affairtype)
	{
		return affair_categoryDao.getAffairType(affairtype);
	}
	
	public void doAffairType(String name,int flag,int rank)
	{
	  Affair_category ac=new Affair_category();
	  ac.setName(name);
	  ac.setFlag(flag);
	  ac.setRank(rank);
	  affair_categoryDao.doAffairType(ac);
	}
	
	public void deleteType(String[] str)
	{
		Affair_category ac=null;
		int acid=0;
		for(int i=0;i<str.length;i++)
		{
			acid=Integer.valueOf(str[i]);
			ac=new Affair_category();
			ac.setAcid(acid);
			charge_StandardDao.deleteCharges(acid);
			affair_categoryDao.deleteType(ac);
			
		}
	}
	
	public void updateType(Affair_category ac)
	{
		affair_categoryDao.updateType(ac);
	}
	
	public boolean checkAff_ca(int acid)
	{
		return affair_categoryDao.checkAff_ca(acid);
	}
}
