package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.CityVo;
import com.vo.LoanRateVo;
@Repository
public class LoanRateDao {
	@Autowired SessionFactory sessionFactory;
	public void save(LoanRateVo loanRateVo) {
		Session session = this.sessionFactory.openSession();
		session.save(loanRateVo);
	}

}
