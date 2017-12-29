package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;





import com.dao.LoanDao;
import com.vo.LoanVo;

@Controller
public class LoanController {
	@Autowired LoanDao ld1;
	
	@RequestMapping("/manageLoanType") 
	public ModelAndView insertLoan()
	{
		 LoanVo l=new LoanVo();
		return new ModelAndView("addLoan","lvo",l);
	}
	@RequestMapping("/saveLoan")
	public ModelAndView save(HttpServletRequest request,@ModelAttribute("lvo") LoanVo l)
	{
		System.out.println("done");
		this.ld1.save(l);
		System.out.println("done1");
		LoanVo lnew=new LoanVo();
		return new ModelAndView("addLoan","lvo",lnew);
		
		
	}
	@RequestMapping("/searchloan")
	public ModelAndView searchLoan(HttpServletRequest request,HttpServletResponse response)
	{
		
		List ls=this.ld1.display();
		System.out.print("done");
		HttpSession ses=request.getSession();
		ses.setAttribute("list", ls);
		//ses.setAttribute("set", true);
		/*try{
		response.sendRedirect("searchLoan.jsp");
		}catch(Exception e){System.out.print("error");}*/
		return new ModelAndView("searchLoan");
		
	}
	@RequestMapping("/deleteLoan")
	public ModelAndView deleteLoan(HttpServletRequest request)
	{
		String s1=request.getParameter("id");
		int i=Integer.parseInt(s1);
		LoanVo l=new LoanVo();
		l.setLoanId(i);
		this.ld1.delete(l);
		System.out.println("hio");
		List ls=this.ld1.display();
		HttpSession ses=request.getSession();
		ses.setAttribute("list", ls);
		return new ModelAndView("searchLoan");
	}
	@RequestMapping("/editLoan")
	public ModelAndView editLoan(HttpServletRequest request)
	{
		HttpSession ses=request.getSession();
		int id=(Integer.parseInt(request.getParameter("id")));
		LoanVo lv=this.ld1.selectById(id);
		ses.setAttribute("editLoanList", lv);
		List ls=this.ld1.display();
		System.out.print("done");
		
		ses.setAttribute("list", ls);
		LoanVo lnew=new LoanVo();
		return new ModelAndView("searchLoan","lvo",lnew);
		
	}
	
	@RequestMapping("/updateLoan")
	public ModelAndView updateLoan(HttpServletRequest request,@ModelAttribute("lvo") LoanVo lv)
	{
		HttpSession ses=request.getSession();
		
		this.ld1.update(lv);
		ses.removeAttribute("editLoanList");
		List ls=this.ld1.display();
		System.out.print("done");
		
		ses.setAttribute("list", ls);
		return new ModelAndView("searchLoan");
	}
	
	

}
