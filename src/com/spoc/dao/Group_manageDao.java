package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Apply;
import com.spoc.po.College;
import com.spoc.po.Group_manage;

@Repository("group_manageDao")
public class Group_manageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Group_manage> getGroups()
	{
		Session session=sessionFactory.openSession();
		List<Group_manage> list=null;
		try{
		Query query=session.createQuery("from Group_manage");
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
	public void doGroup(Group_manage gm)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction=session.beginTransaction();
			session.save(gm);
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
	
	public void deleteGroup(int gid)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction=session.beginTransaction();
			Group_manage gm=(Group_manage) session.get(Group_manage.class, gid);
			session.delete(gm);
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
	
	public void updateGroup(Group_manage gm)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction=session.beginTransaction();	
			System.out.println(gm.getGid()+gm.getName()+gm.getDescription());
			session.update(gm);
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
}
