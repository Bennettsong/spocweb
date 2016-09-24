package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.AdminDao;
import com.spoc.dao.UserDao;
import com.spoc.po.Member;


@SuppressWarnings("unused")
@Service("userService")
public class UserService
{
	@Autowired
	private UserDao userDao;
	@Autowired
	private AdminDao adminDao;
	

	public boolean find(String loginid,String password)
	{
		boolean flag=userDao.find(loginid,password);	
		return flag;
	}
	
	public boolean findAdmin(String loginid,String password)
	{
		boolean flag=userDao.findAdmin(loginid,password);	
		return flag;
	}
	
	public boolean checkAuthority(int userValue,int functionValue)
	{
		functionValue=(int)Math.pow(2, functionValue);
		int value=userValue&functionValue;
		//System.out.println(value+" "+functionValue);
		if(value==functionValue)
		{
			return true;
		}else{
			return false;
		}
		
	}
	
	public int getAuthority(String loginid)
	{
		int adminid=userDao.getAdminId(loginid);		
		int value=adminDao.getValue(adminid);
		return value;
	}
	
	public UserDao getUserDao()
	{
		return userDao;
	}
	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

}



