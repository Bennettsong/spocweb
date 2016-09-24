package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Affair;
import com.spoc.po.Apply;
import com.spoc.po.Member;


@Repository("applyDao")
public class ApplyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void doApply(Apply apply)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.save(apply);
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
	
	public List<Apply> getApply()
	{
		Session session=sessionFactory.openSession();
		List<Apply> list=null;
		try{
		Query query=session.createQuery("from Apply");
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	} 
	public void updateApply(int apply_id)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		Apply ap=(Apply) session.get(Apply.class,apply_id);
		session.update(ap);
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
@SuppressWarnings("unchecked")
	public void deleteApply(int apply_id)
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Apply> list = null;
		try
		{
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Apply where apply_id=?");
			query.setLong(0, apply_id);
			list = query.list();
			for (Apply cs : list)
			{
				session.delete(cs);
			}
			transaction.commit();
		} catch (Exception ex)
		{
			if (transaction != null)
			{
				transaction.rollback();// 回滚事务，撤消查询语句
			}
			System.out.println(ex);
		} finally
		{
			session.close();// 关闭会话状态，清空资源
		}
	}
}
