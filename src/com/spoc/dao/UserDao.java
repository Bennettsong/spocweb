package com.spoc.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spoc.po.Member;



@Repository("userDao")
public class UserDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public boolean find(String loginid,String password)
	{
		//System.out.println("UserDao.find()");
		boolean flag=false;		
		String hql="from Member u where u.loginid=? and u.password=?";
		Session session = sessionFactory.openSession();
		try{
        Query query = session.createQuery(hql).setParameter(0, loginid).setParameter(1, password);
        //使用List方法
        @SuppressWarnings("rawtypes")
		List userList = query.list();
        @SuppressWarnings("rawtypes")
		Iterator it=userList.iterator();
       if(it.hasNext())
	   {
	    	 flag=true;
	    }
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
	     return flag;
	
	}
	
	public boolean findAdmin(String loginid,String password)
	{
		//System.out.println("UserDao.find()");
		boolean flag=false;		
		String hql="from Member u where u.loginid=? and u.password=? and adminid=1";
		Session session = sessionFactory.openSession();
		try{
        Query query = session.createQuery(hql).setParameter(0, loginid).setParameter(1, password);
        //使用List方法
        @SuppressWarnings("rawtypes")
		List userList = query.list();
        @SuppressWarnings("rawtypes")
		Iterator it=userList.iterator();
       if(it.hasNext())
	   {
	    	 flag=true;
	    }
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
	     return flag;
	
	}
	
	public int getAdminId(String loginid)
	{
		Session session = sessionFactory.openSession();
		Member member=null;
		try{
	        Query query = session.createQuery("from Member where loginid=?");
	        query.setString(0, loginid);
	        member=(Member) query.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return member.getAdminid();
	}
}
