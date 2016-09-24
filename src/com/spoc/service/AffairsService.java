package com.spoc.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.AffairsDao;
import com.spoc.po.Affairs;

@Service("affairsService")
public class AffairsService {

	@Autowired
	private AffairsDao affairsDao;
	
	public List<Affairs> getAffairs(String name)
	{
		System.out.println(name);
		return affairsDao.getAffairs(name);
	}
}
