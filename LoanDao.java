package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	

}
