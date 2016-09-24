package com.spoc.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spoc.service.HibernateUtils;

import com.spoc.po.member_product;
import com.spoc.po.product;

public class uploadproduct
{
	public int addproduct(product pr)
	{
		int pid=addproduct1(pr);
		return pid;
	}
	public void addmember_product(member_product mpr)
	{
		addmember_product1(mpr);
	}
	@SuppressWarnings("finally")
	public int addproduct1(product pr)
	{
		Session session=HibernateUtils.getSession();
		int pid=0;
		String name=pr.getName();
//		Session session=sessionfactory.openSession();
		Transaction transaction = null;
		product pr1=null;
		try
		{
			transaction=session.beginTransaction();
			session.save(pr);
			transaction.commit();
			Query query=session.createQuery("from product where name=?");
			query.setString(0, name);
			pr1=(product)query.uniqueResult();
			pid=pr1.getPid();
		}
		catch (Exception ex)
		{
			if (transaction != null) 
			{
				transaction.rollback();// 回滚事务，撤消查询语句
			}
			System.out.println(ex);
		} 
		finally 
		{
			session.close();// 关闭会话状态，清空资源
			return pid;
		}	
	}
	public void addmember_product1(member_product mpr)
	{
//		Session session=sessionfactory.openSession();
		Session session=HibernateUtils.getSession();
		Transaction transaction = null;
		try
		{
			transaction=session.beginTransaction();
			session.save(mpr);
			transaction.commit();
		}
		catch(Exception ex)
		{
			if (transaction != null) 
			{
				transaction.rollback();// 回滚事务，撤消查询语句
			}
			System.out.println(ex);
		}
		finally
		{
			session.close();// 关闭会话状态，清空资源
		}
	}
}
