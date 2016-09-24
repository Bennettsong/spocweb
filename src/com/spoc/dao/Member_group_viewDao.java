package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.College;
import com.spoc.po.Member_group_view;

@Repository("member_group_viewDao")
public class Member_group_viewDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Member_group_view> getMemberGroup(String loginid)
	{
		Session session=sessionFactory.openSession();
		List<Member_group_view> list=null;
		try{
		Query query=session.createQuery("from Member_group_view where loginid=?");
		query.setString(0, loginid);
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
	public  List<Member_group_view> getMemberGroups()
	{
		Session session=sessionFactory.openSession();
		List<Member_group_view> list=null;
		try{
		Query query=session.createQuery("from Member_group_view");
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;

	}
}
