package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;





import com.vo.LoanVo;
import com.vo.PostVo;

@Repository
public class PostDao {
	@Autowired SessionFactory sessionFactory;

	
	public void save(PostVo p) {
		Session session = this.sessionFactory.openSession();
		session.save(p);
	}
	public List select() {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from PostVo");
		List l=q.list();
		return l;
	
}
	public List display()
	{
		
		Session session=this.sessionFactory.openSession();
		
		Query q=session.createQuery("from PostVo");
		List l =q.list();
		return l;
	}
	public void delete( PostVo pvo )
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(pvo);
		transaction.commit();
	   
	}
	public PostVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from PostVo where postId="+id);
		PostVo l=(PostVo)q.uniqueResult();
		return l;
	}
	public void update(PostVo pvo) {
		
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(pvo);
		transaction.commit();
		
	}
	
}

