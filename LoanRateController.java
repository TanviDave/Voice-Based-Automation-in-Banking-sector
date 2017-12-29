package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.LoanDao;
import com.dao.LoanRateDao;
import com.vo.LoanRateVo;
import com.vo.LoanVo;

@Controller
public class LoanRateController {
	@Autowired LoanRateDao loanRateDao;
	@Autowired LoanDao ld1;
	@RequestMapping(value="/manageLoanRate",method=RequestMethod.GET)
	public ModelAndView insertLoanRate(HttpServletRequest request)
	{
		
		HttpSession ss=request.getSession();
		List l=this.ld1.select();
		ss.setAttribute("loanList", l);
		

		return new ModelAndView("addLoanRate","loanRateVo",new LoanRateVo());
		
		
	}
	@RequestMapping("/saveLoanRate")
	public ModelAndView saveLoanRate(HttpServletRequest request,@ModelAttribute("loanRateVo") LoanRateVo loanRateVo)
	{
		System.out.println("done");
		this.loanRateDao.save(loanRateVo);
		System.out.println("done1");
		LoanRateVo lrnew=new LoanRateVo();
		return new ModelAndView("addLoanRate","loanRateVo",lrnew);
		
		
	}
	@RequestMapping("/searchLoanRate")
	public ModelAndView searchLoanRate(HttpServletRequest request,HttpServletResponse response)
	{
		
		List ls=this.loanRateDao.display();
		HttpSession ses=request.getSession();
		ses.setAttribute("loanRateList1", ls);
		//ses.setAttribute("set", true);
		/*try{
		response.sendRedirect("searchLoan.jsp");
		}catch(Exception e){System.out.print("error");}*/
		return new ModelAndView("searchLoanRate");
		
	}
	@RequestMapping("/deleteLoanRate")
	public ModelAndView deleteLoanRate(HttpServletRequest request)
	{
		String s1=request.getParameter("loanRateId");
		int i=Integer.parseInt(s1);
		LoanRateVo lr=new LoanRateVo();
		lr.setLoanRateId(i);
		this.loanRateDao.delete(lr);
		System.out.println("hio");
		List ls=this.loanRateDao.display();
		HttpSession ses=request.getSession();
		ses.setAttribute("loanRateList1", ls);
		return new ModelAndView("searchLoanRate");
	}
	@RequestMapping("/editLoanRate")
	public ModelAndView editLoanRate(HttpServletRequest request)
	{
		HttpSession ses=request.getSession();
		int loanRateId=(Integer.parseInt(request.getParameter("loanRateId")));
		LoanRateVo lrv=this.loanRateDao.selectById(loanRateId);
		ses.setAttribute("editLoanRateList", lrv);
		List ls=this.loanRateDao.display();
		System.out.print("done");
		
		ses.setAttribute("loanRateList1", ls);
		LoanRateVo lrnew=new LoanRateVo();
		return new ModelAndView("searchLoanRate","lrvo",lrnew);
		
	}
	
	@RequestMapping("/updateLoanRate")
	public ModelAndView updateLoanRate(HttpServletRequest request,@ModelAttribute("lrvo") LoanRateVo lrv)
	{
		HttpSession ses=request.getSession();
		
		this.loanRateDao.update(lrv);
		ses.removeAttribute("editLoanRateList");
		List ls=this.loanRateDao.display();
		System.out.print("done");
		
		ses.setAttribute("loanRateList1", ls);
		return new ModelAndView("searchLoanRate");
	}
	
	


}
