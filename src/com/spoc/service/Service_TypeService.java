package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.ServiceTypeDao;
import com.spoc.po.Affair_category;
import com.spoc.po.Service_type;

@Service("service_TypeService")
public class Service_TypeService {

	@Autowired
	private ServiceTypeDao serviceTypeDao;
	
	public List<Service_type> getServiceTypes()
	{
		return serviceTypeDao.getServiceTypes();
	}
	
	public void addServicetype(String str)
	{
		Service_type st=new Service_type();
		st.setType(str);
		serviceTypeDao.doServiceType(st);
	}
	
	public void deleteType(String[] str)
	{
		Service_type st=null;
		int stid=0;
		for(int i=0;i<str.length;i++)
		{
			stid=Integer.valueOf(str[i]);
			st=new Service_type();
			st.setStid(stid);
			serviceTypeDao.deleteType(st);
		}
			
	}
	
	public List<Service_type> searchType(String type)
	{
		return serviceTypeDao.getType(type);
	}
}
