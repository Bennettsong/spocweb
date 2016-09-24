package com.spoc.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.College;
import com.spoc.po.Member;

@Repository("memberDao")
public class MemberDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean checkLoginid(String loginid)
	{
		Session session=sessionFactory.openSession();
		boolean flag=false;
		try{
			Query query=session.createQuery("from Member where loginid=?");	
			query.setString(0, loginid);
			List<Member> list=query.list();
			Iterator<Member> it=list.iterator();
			if(it.hasNext())
			{
				flag=true;
			}
			}catch (Exception ex) {
				System.out.println(ex);
			} finally {
				session.close();
			}
			return flag;
	}
	public List<Member> getStudents()
	{
		Session session=sessionFactory.openSession();
		List<Member> list=null;
		try{
		Query query=session.createQuery("from Member where flag=?");
		query.setInteger(0, 2);
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<Member> getTeachers()
	{
		Session session=sessionFactory.openSession();
		List<Member> list=null;
		try{
		Query query=session.createQuery("from Member where flag=?");
		query.setInteger(0, 1);
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<Member> getMember(Member member)
	{
		Session session=sessionFactory.openSession();
		List<Member> members=null;
		try{
		Query query=session.createQuery("from Member where name=? and flag=?");
		query.setString(0, member.getName());
		query.setInteger(1, member.getFlag());
		members=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return members;
		
	}
	
	public void deleteMember(Member member)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.delete(member);
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
	
	public Member getMember(String loginid)
	{

		Session session=sessionFactory.openSession();
		Member member=null;
		try{
		Query query=session.createQuery("from Member where loginid=?");
		query.setString(0, loginid);
		member=(Member) query.uniqueResult();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return member;
		
	}
	
	public void doMember(Member member)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		session.save(member);
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
	
	public void updateMember(Member member,String hide)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		if(member.getLoginid().equals(hide))
		{
		session.update(member);
		}else{
			Member memberFormal=(Member) session.get(Member.class, hide);
			session.delete(memberFormal);
			session.save(member);
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
}
