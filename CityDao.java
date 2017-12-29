package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import com.vo.AreaVo;
import com.vo.CityVo;


@Repository
public class CityDao {
	@Autowired SessionFactory sessionFactory;
	public void save(CityVo cv) {
		Session session = this.sessionFactory.openSession();
		session.save(cv);
	}
	public List search(int stateId) {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from CityVo where stateId="+stateId);
		List l=q.list();
		return l;
		
	}
	public List select() {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from CityVo");
		List l=q.list();
		return l;

}
	
	public void delete( CityVo cvo )
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(cvo);
		transaction.commit();
	   
				
		
	}
	public CityVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from CityVo where cityId="+id);
		CityVo l=(CityVo)q.uniqueResult();
		return l;
	}
	public void update(CityVo cvo) {
		
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(cvo);
		transaction.commit();
		
	}

}
