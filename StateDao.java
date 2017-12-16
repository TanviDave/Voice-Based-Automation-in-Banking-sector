package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




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

}
