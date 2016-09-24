package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Member_group;

@Repository("member_groupDao")
public class Member_groupDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void doMemberGroup(Member_group member_group)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.save(member_group);
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
	
	public void deleteMember(String loginid)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		Query query=session.createQuery("from Member_group where loginid=?");
		query.setString(0, loginid);
		List<Member_group> list=query.list();
		for(Member_group mg:list)
		{
			session.delete(mg);
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
	
	public void updateMember(Member_group mg)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.update(mg);
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
