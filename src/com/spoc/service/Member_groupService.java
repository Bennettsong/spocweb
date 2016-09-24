package com.spoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.Member_groupDao;
import com.spoc.po.Member_group;

@Service("member_groupService")
public class Member_groupService {

	@Autowired
	private Member_groupDao member_groupDao;
	
	public void addMemberGroup(String[] groups,String loginid)
	{
		Member_group member_group=null;
		int groupid=0;
		for(String group:groups)
		{
			member_group=new Member_group();
			groupid=Integer.valueOf(group);
			System.out.println(groupid);
			member_group.setLoginid(loginid);
			member_group.setGid(groupid);
			member_groupDao.doMemberGroup(member_group);
		}
	}
	
	public void updateMemberGroup(String[] groups,String loginid)
	{
		Member_group member_group=null;
		int groupid=0;
		member_groupDao.deleteMember(loginid);
		for(String group:groups)
		{
			member_group=new Member_group();
			groupid=Integer.valueOf(group);
			member_group.setLoginid(loginid);
			member_group.setGid(groupid);			
			member_groupDao.doMemberGroup(member_group);
		}
	}
}
