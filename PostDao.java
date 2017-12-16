package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.vo.PostVo;

@Repository
public class PostDao {
	@Autowired SessionFactory sessionFactory;

	
	public void save(PostVo p) {
		Session session = this.sessionFactory.openSession();
		session.save(p);
	}
	
}

