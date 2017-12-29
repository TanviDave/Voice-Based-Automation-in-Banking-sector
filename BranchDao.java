package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;




import com.vo.BranchVo;
import com.vo.LoanVo;

@Repository

public class BranchDao {
	@Autowired SessionFactory sessionFactory;
	public void save(BranchVo branchVo) {
		Session session = this.sessionFactory.openSession();
		session.save(branchVo);
	}
	public List select() {
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from BranchVo");
		List l=q.list();
		return l;

}
	public void delete( BranchVo bvo )
	{
		
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(bvo);
		transaction.commit();
	   
				
		
	}
	public BranchVo selectById(int id)
	{
		Session session = this.sessionFactory.openSession();
		Query q=session.createQuery("from BranchVo where branchId="+id);
		BranchVo l=(BranchVo)q.uniqueResult();
		return l;
	}
	public void update(BranchVo bvo) {
		
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(bvo);
		transaction.commit();
		
	}
}
