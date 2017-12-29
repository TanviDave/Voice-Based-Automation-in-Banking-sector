package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;






import com.vo.CityVo;
import com.vo.StaffRegVo;
import com.vo.StateVo;

@Repository

public class StateDao {
	@Autowired SessionFactory sessionFactory;
	public void save(StateVo s) {
		Session session = this.sessionFactory.openSession();
		session.save(s);
	}
	public List select() {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from StateVo");
		List l=q.list();
		return l;
		
	}
	
	
	
	public void delete(StateVo svo)
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(svo);
		transaction.commit();
	   
				
	}
	
	public StateVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from StateVo where stateId="+id);
		StateVo l=(StateVo)q.uniqueResult();
		return l;
	}
	public void update(StateVo svo) {
		
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(svo);
		transaction.commit();
		
	}


}
