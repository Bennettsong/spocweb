package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Affair_category;
import com.spoc.po.Service_type;

@Repository("serviceTypeDao")
public class ServiceTypeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Service_type> getServiceTypes() {
		Session session = sessionFactory.openSession();
		List<Service_type> list=null;
		try{
		Query query = session.createQuery("from Service_type");
		list = query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
	public void doServiceType(Service_type st)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.save(st);
		transaction.commit();
		}catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();// 回滚事务，撤消查询语句
			}
			System.out.println(ex);
		} finally {
			session.close();// 关闭会话状态，清空资源
		}	
	}
	
	public void deleteType(Service_type st)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.delete(st);
		transaction.commit();
		}catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();// 回滚事务，撤消查询语句
			}
			System.out.println(ex);
		} finally {
			session.close();// 关闭会话状态，清空资源
		}	
	}
	
	public List<Service_type> getType(String type)
	{
		Session session=sessionFactory.openSession();
		List<Service_type> list=null;
		try{
		Query query=session.createQuery("from Service_type where type=?");
		query.setString(0, type);
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
}
