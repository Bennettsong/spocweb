package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Affairs;

@Repository("affairsDao")
public class AffairsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Affairs> getAffairs(String name)
	{
		Session session=sessionFactory.openSession();
		List<Affairs> affairs=null;
		try{
		Query query=session.createQuery("from Affairs where name=?");
		query.setString(0,name);
		affairs=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return affairs;
	}

}
