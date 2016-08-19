package com.spoc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spoc.po.Affair;
import com.spoc.po.College;

@Repository("affairDao")
public class AffairDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void add(Affair affair)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction=session.beginTransaction();
		    session.save(affair);
		    transaction.commit();
		}catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();// �ع����񣬳�����ѯ���
			}
			System.out.println(ex);
		} finally {
			session.close();// �رջỰ״̬�������Դ
		}	

	}
	
	public List<Affair> getAffairs()
	{
		Session session=sessionFactory.openSession();
		List<Affair> list=null;
		try{
		Query query=session.createQuery("from Affair");
		list=query.list();
		}catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return list;
	}
	
	public void updateAffair(int aff_id,String loginid)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		Affair af=null;
		try{
		transaction=session.beginTransaction();
		af=(Affair) session.get(Affair.class, aff_id);
		af.setLoginid(loginid);
		af.setFlag(1);
		session.update(af);
		transaction.commit();
		}catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();// �ع����񣬳�����ѯ���
			}
			System.out.println(ex);
		} finally {
			session.close();// �رջỰ״̬�������Դ
		}	
	}
	
	public void deleteAffair(int aff_id)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try{
		transaction=session.beginTransaction();
		Affair af=(Affair) session.get(Affair.class,aff_id);
		session.delete(af);
		transaction.commit();
		}catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();// �ع����񣬳�����ѯ���
			}
			System.out.println(ex);
		} finally {
			session.close();// �رջỰ״̬�������Դ
		}	
	}
}
