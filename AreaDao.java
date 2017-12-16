package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.AreaVo;


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

}
