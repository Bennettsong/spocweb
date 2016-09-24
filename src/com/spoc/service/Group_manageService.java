package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.Group_manageDao;
import com.spoc.po.Group_manage;
import com.spoc.po.Member;


@Service("group_manageService")
public class Group_manageService {

	@Autowired
	private Group_manageDao group_manageDao;
	
	public List<Group_manage> getGroup()
	{
		return group_manageDao.getGroups();
	}
	
	public void addGroup(Group_manage gm)
	{
		group_manageDao.doGroup(gm);
	}
	
	public void deleteGroups(String[] str)
	{
	  
		for(int i=0;i<str.length;i++)
		{
			System.out.println(Integer.valueOf(str[i]));
			group_manageDao.deleteGroup(Integer.valueOf(str[i]));
		}
	}
	
	public void updateGroup(Group_manage gm)
	{
		System.out.println(gm.getGid()+gm.getName()+gm.getDescription());
		group_manageDao.updateGroup(gm);
	}
}
