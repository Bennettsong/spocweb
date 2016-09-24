package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.product;

@Repository("productdao")
public class productdao
{
	@Autowired
	private SessionFactory sessionfactory;
	public List<product> getpath()
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from product where flag=1");
		List<product> list=query.list();
		session.close();
		return list;
	}
	public List<product> getproducts()
	{
		Session session=sessionfactory.openSession();
		List<product> products=null;
		try
		{
			Query query=session.createQuery("from products");
			products=query.list();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			session.close();
		}
		return products;
	}
	public void deleteproducts(product pr)
	{
		Session session=sessionfactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
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
	public void updateproducts(product pr)
	{
		Session session=sessionfactory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.update(pr);
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
	public product getproduct(int pid)
	{
		product pr=null;
		Session session=sessionfactory.openSession();
		try
		{
			Query query=session.createQuery("from product where pid=?");
			query.setInteger(0, pid);
			pr=(product)query.uniqueResult();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			session.close();
		}
		return pr;
	}
	@SuppressWarnings("finally")
	public int addproduct(product pr)
	{
		int pid=0;
		String name=pr.getName();
		Session session=sessionfactory.openSession();
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
}
