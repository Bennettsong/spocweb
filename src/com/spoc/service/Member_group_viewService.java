package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.Member_group_viewDao;
import com.spoc.po.Member_group_view;


@Service("member_group_viewService")
public class Member_group_viewService {

	@Autowired
	private Member_group_viewDao member_group_viewDao;
	
	public String getMemberGroup(String loginid)
	{
		String str="";
		List<Member_group_view> list=member_group_viewDao.getMemberGroup(loginid);
		for(Member_group_view view:list)
		{
			str=str+view.getName()+" ";
		}
		return str;
	}
	
	public List<Member_group_view> getMemberGroups()
	{
		return member_group_viewDao.getMemberGroups();
	}
}
