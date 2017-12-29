package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import com.vo.CityVo;
import com.vo.LoanRateVo;
import com.vo.LoanVo;
@Repository
public class LoanRateDao {
	@Autowired SessionFactory sessionFactory;
	public void save(LoanRateVo loanRateVo) {
		Session session = this.sessionFactory.openSession();
		session.save(loanRateVo);
	}
	public List display()
	{
		
		Session session=this.sessionFactory.openSession();
		
		Query q=session.createQuery("from LoanRateVo");
		List l =q.list();
		return l;
	}
	public void delete( LoanRateVo lrvo )
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(lrvo);
		transaction.commit();
	   
				
		
	}
	public LoanRateVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from LoanRateVo where loanRateId="+id);
		LoanRateVo l=(LoanRateVo)q.uniqueResult();
		return l;
	}
	public void update(LoanRateVo lrvo) {
		
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(lrvo);
		transaction.commit();
		
	}
	
	



}
