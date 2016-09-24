package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Charge_Standard;

@Repository("charge_StandardDao")
public class Charge_StandardDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void deleteCharges(int acid)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		List<Charge_Standard> list=null;
		try{
		transaction=session.beginTransaction();
		Query query=session.createQuery("from Charge_Standard where acid=?");
		query.setInteger(0, acid);
		list=query.list();
		for(Charge_Standard cs:list)
		{
			session.delete(cs);
		}
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
	
	public void doChargeStandard(Charge_Standard cs)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.save(cs);
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
	
	public void updateChargeStandard(Charge_Standard cs)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.update(cs);
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
	
	public void deleteChargeStandard(int csid)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		Charge_Standard cs=(Charge_Standard) session.get(Charge_Standard.class, csid);
		session.delete(cs);
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
	
	public List<Charge_Standard> getTypes()
	{
		Session session = sessionFactory.openSession();
		List<Charge_Standard> list=null;
		try{
		Query query = session.createQuery("from Charge_Standard");
		list= query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
}
