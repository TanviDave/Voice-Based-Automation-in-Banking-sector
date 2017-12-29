package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.StaffRegVo;
@Repository

public class staff_reg_dao {

	@Autowired SessionFactory sessionFactory;

	public void save(StaffRegVo r) {
		Session session = this.sessionFactory.openSession();
	System.out.println("jii");
		session.save(r);
		System.out.println("kii");
	}
	public List display()
	{
		
		Session session=this.sessionFactory.openSession();
		
		Query q=session.createQuery("from  StaffRegVo");
		List l =q.list();
		return l;
	}
	public void delete( StaffRegVo rvo )
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(rvo);
		transaction.commit();
	   
				
		
	}
	public StaffRegVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from StaffRegVo where staff_id="+id);
		StaffRegVo l=(StaffRegVo)q.uniqueResult();
		return l;
	}
	public void update(StaffRegVo sfvo) {
		
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(sfvo);
		transaction.commit();
		
	}

}
