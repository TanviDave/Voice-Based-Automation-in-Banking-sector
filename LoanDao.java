package com.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;











import com.vo.LoanVo;

@Repository
public class LoanDao {
	@Autowired SessionFactory sessionFactory;
	public void save(LoanVo l) {
		Session session = this.sessionFactory.openSession();
		session.save(l);
	}
	public List select() {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from LoanVo");
		List l=q.list();
		return l;
		
	}
	public List display()
	{
		
		Session session=this.sessionFactory.openSession();
		System.out.print("hii");
		Query q=session.createQuery("from LoanVo");
		System.out.print("hii");
		List l =q.list();
		System.out.print("hii");
		return l;
	}
	public void delete( LoanVo lvo )
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(lvo);
		transaction.commit();
	   
	}
	public LoanVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from LoanVo where loanId="+id);
		LoanVo l=(LoanVo)q.uniqueResult();
		return l;
	}
	public void update(LoanVo lvo) {
		
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(lvo);
		transaction.commit();
		
	}
	
	

}
