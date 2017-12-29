package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;

import com.vo.AreaVo;
import com.vo.BranchVo;


@Repository
public class AreaDao {
	@Autowired SessionFactory sessionFactory;
	public void save(AreaVo areaVo) {
		Session session = this.sessionFactory.openSession();
		session.save(areaVo);
	}
	public List search(int cityId) {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from AreaVo where cityId="+cityId);
		List l=q.list();
		return l;
		
	}
	public List select() {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from AreaVo");
		List l=q.list();
		return l;

}
	
	public void delete( AreaVo avo )
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(avo);
		transaction.commit();
	   
				
		
	}
	public AreaVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from AreaVo where areaId="+id);
		AreaVo l=(AreaVo)q.uniqueResult();
		return l;
	}
	public void update(AreaVo avo) {
		
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(avo);
		transaction.commit();
		
	}

}
