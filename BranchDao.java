package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.vo.BranchVo;

@Repository

public class BranchDao {
	@Autowired SessionFactory sessionFactory;
	public void save(BranchVo branchVo) {
		Session session = this.sessionFactory.openSession();
		session.save(branchVo);
	}

}
