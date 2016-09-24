package com.spoc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Admin;
import com.spoc.po.Member;

@Repository("adminDao")
public class AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public int getValue(int id)
	{
		Session session = sessionFactory.openSession();
		int value=2;
		try{	        
	        Admin admin=(Admin) session.get(Admin.class,id);
	        value=admin.getValue();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return value;
	}
}
