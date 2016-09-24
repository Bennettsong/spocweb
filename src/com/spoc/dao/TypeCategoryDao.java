package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Service_type;
import com.spoc.po.Type_category;

@Repository("TypeCategoryDao")
public class TypeCategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void doTypeCategory(Type_category tc)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.save(tc);
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
	
	public void updateTypeCategory(Type_category tc)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.update(tc);
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
	
	public void deleteTypeCategory(int tcid)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		Type_category tc=(Type_category) session.get(Type_category.class, tcid);
		session.delete(tc);
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
	
	public List<Type_category> getTypes()
	{
		Session session = sessionFactory.openSession();
		List<Type_category> list =null;
		try{
		Query query = session.createQuery("from Type_category");
		list= query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<Type_category> getType(String str)
	{
		Session session=sessionFactory.openSession();
		List<Type_category> list=null;
		try{
		Query query=session.createQuery("from Type_category where description=?");
		query.setString(0, str);
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
}
