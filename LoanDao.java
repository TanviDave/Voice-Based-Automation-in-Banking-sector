package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.vo.LoanVo;

@Repository
public class LoanDao {
	@Autowired SessionFactory hibernate4AnnotatedSessionFactory;
	public void save(LoanVo l) {
		Session session = this.hibernate4AnnotatedSessionFactory.openSession();
		session.save(l);
	}
	

}
