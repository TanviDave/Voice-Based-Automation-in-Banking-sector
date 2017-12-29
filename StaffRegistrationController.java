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

import com.dao.BranchDao;
import com.dao.PostDao;
import com.dao.staff_reg_dao;
import com.vo.StaffRegVo;
import com.vo.StateVo;
@Controller

public class StaffRegistrationController {
	@Autowired staff_reg_dao srdao;
	@Autowired BranchDao branchDao;
	 @Autowired PostDao pd;
	@RequestMapping("/staffreg") 
	public ModelAndView insert2(HttpServletRequest request,@ModelAttribute("srvo") StaffRegVo r)
	{
		HttpSession ses=request.getSession();
		
		List l=this.branchDao.select();
		ses.setAttribute("branchList", l);
		List l1=this.pd.select();
		ses.setAttribute("postList", l1);
		if(ses.getAttribute("flag")!=null)
		{
		String flag=(String)ses.getAttribute("flag");
		
		if(flag.equals("true"))
		{
			ses.removeAttribute("flag");
			return new ModelAndView("staffregistration","Message","Data Entered Successfully");
		}
			
		
		else{
		return new ModelAndView("staffregistration","srvo",r);}}
		else{return new ModelAndView("staffregistration","srvo",r);}
	}
	
	@RequestMapping(value="save.htm",method=RequestMethod.POST)
	public ModelAndView saveStaffRegistration(HttpServletRequest request,@ModelAttribute("srvo") StaffRegVo r,HttpServletResponse response)
	{
		System.out.print("hii");
		this.srdao.save(r);
		
		
		try{
			HttpSession ses=request.getSession();
			ses.setAttribute("flag","true");
		response.sendRedirect("staffreg.htm");}catch(Exception e1){
			System.out.println("error");
		}
		return new ModelAndView("staffregistration","Message","Data Entered Successfully");
		
		
	}
	@RequestMapping("/searchstaff")
	public ModelAndView searchStaff(HttpServletRequest request,HttpServletResponse response)
	{
		
		List ls=this.srdao.display();
		HttpSession ses=request.getSession();
		ses.setAttribute("staffList1", ls);
		//ses.setAttribute("set", true);
		/*try{
		response.sendRedirect("searchLoan.jsp");
		}catch(Exception e){System.out.print("error");}*/
		return new ModelAndView("searchStaff");
		
	}
	@RequestMapping("/deleteStaff")
	public ModelAndView deleteStaff(HttpServletRequest request)
	{
		String s1=request.getParameter("id");
		int i=Integer.parseInt(s1);
		StaffRegVo s=new StaffRegVo();
		s.setStaff_id(i);
		this.srdao.delete(s);
		System.out.println("hio");
		List ls=this.srdao.display();
		HttpSession ses=request.getSession();
		ses.setAttribute("staffList1", ls);
		return new ModelAndView("searchStaff");
	}
	@RequestMapping("/editStaff")
	public ModelAndView editStaff(HttpServletRequest request)
	{
		HttpSession ses=request.getSession();
		int staffId=(Integer.parseInt(request.getParameter("id")));
		StaffRegVo sv=this.srdao.selectById(staffId);
		ses.setAttribute("editStaffList1", sv);
		List ls=this.srdao.display();
		System.out.print("done");
		
		ses.setAttribute("staffList1", ls);
		StaffRegVo snew=new StaffRegVo();
		return new ModelAndView("searchStaff","sfvo",snew);
		
	}

	@RequestMapping("/updateStaff")
	public ModelAndView updateStaff(HttpServletRequest request,@ModelAttribute("svo") StaffRegVo sfv)
	{
		HttpSession ses=request.getSession();
		
		this.srdao.update(sfv);
		ses.removeAttribute("editStaffList");
		List ls=this.srdao.display();
		System.out.print("done");
		
		ses.setAttribute("staffList1", ls);
		return new ModelAndView("searchStaff");
	}




}
