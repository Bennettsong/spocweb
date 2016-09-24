package com.spoc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spoc.po.member_product;
import com.spoc.po.product;

@Repository("productsdao")
public class productsdao
{
	@Autowired
	private SessionFactory sessionfactory;
	public void deleteproducts(int pid)
	{
		Session session=sessionfactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			Query query=session.createQuery("from member_product where pid=?");
			query.setInteger(0, pid);
			member_product pr=(member_product)query.uniqueResult();
			session.delete(pr);
			tx.commit();
		}
		catch(Exception ex)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.out.println(ex);
		}
		finally
		{
			session.close();
		}
	}
	public void updateproducts(member_product mpr)
	{
		Session session=sessionfactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.update(mpr);
			tx.commit();
		}
		catch(Exception ex)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.out.println(ex);
		}
		finally
		{
			session.close();
		}
	}
	public member_product getproducts(int pid)
	{
		member_product mpr=null;
		Session session=sessionfactory.openSession();
		try
		{
			Query query=session.createQuery("from member_product where pid=?");
			query.setInteger(0, pid);
			mpr=(member_product)query.uniqueResult();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			session.close();
		}
		return mpr;
	}
	public void addmember_product(member_product mpr)
	{
		Session session=sessionfactory.openSession();
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
