package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Affair_category;
import com.spoc.po.Affairs;

@Repository("affair_categoryDao")
public class Affair_categoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Affair_category> getAffairCa() {
		Session session = sessionFactory.openSession();
		List<Affair_category> list = null;
		try {

			Query query = session.createQuery("from Affair_category order by rank asc");
			list = query.list();

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}

	public Affair_category getAffairType(String affairtype) {
		Session session = sessionFactory.openSession();
		Affair_category type = null;
		try {
			Query query = session
					.createQuery("from Affair_category where name=?");
			query.setString(0, affairtype);
			type = (Affair_category) query.uniqueResult();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return type;
	}

	public void doAffairType(Affair_category at)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction=session.beginTransaction();
		    session.save(at);
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

	public void deleteType(Affair_category at) {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction=session.beginTransaction();
		    session.delete(at);
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

	public void updateType(Affair_category ac) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;		
		try{
		transaction=session.beginTransaction();		
		session.update(ac);
		session.getTransaction().commit();
		}catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();// 回滚事务，撤消查询语句
			}
			System.out.println(ex);
		} finally {
			session.close();// 关闭会话状态，清空资源
		}	
	}
	
	public boolean checkAff_ca(int acid)
	{
		Session session = sessionFactory.openSession();
		Affair_category type = null;
		boolean flag=false;
		try {
			Query query = session.createQuery("from Affair_category where acid=?");
			query.setInteger(0, acid);
			type = (Affair_category) query.uniqueResult();
			if(type!=null)
			{
				flag=true;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return flag;
	}
}
