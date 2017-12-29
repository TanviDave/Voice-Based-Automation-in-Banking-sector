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

import com.dao.StateDao;
import com.vo.CityVo;
import com.vo.StateVo;
@Controller

public class StateController {
	@Autowired StateDao sd;
	@RequestMapping("/manageState") 
	public ModelAndView insertState()
	{
		 StateVo s=new StateVo();
		return new ModelAndView("addState","svo",s);
	}
	@RequestMapping("/saveState")
	public ModelAndView saveState(HttpServletRequest request,@ModelAttribute("svo") StateVo s)
	{
		
		this.sd.save(s);
		System.out.println("done1");
		StateVo snew=new StateVo();
		return new ModelAndView("addState","svo",snew);
		
		
	}
	@RequestMapping("/searchState")
	public ModelAndView searchState(HttpServletRequest request,HttpServletResponse response)
	{
		
		List ls=this.sd.select();
		HttpSession ses=request.getSession();
		ses.setAttribute("stateList1", ls);
		//ses.setAttribute("set", true);
		/*try{
		response.sendRedirect("searchLoan.jsp");
		}catch(Exception e){System.out.print("error");}*/
		return new ModelAndView("searchState");
		
	}
	@RequestMapping("/deleteState")
	public ModelAndView deleteBranch(HttpServletRequest request)
	{
		String s1=request.getParameter("stateId");
		int i=Integer.parseInt(s1);
		StateVo sv=new StateVo();
		sv.setStateId(i);
		this.sd.delete(sv);
		System.out.println("hio");
		List ls=this.sd.select();
		HttpSession ses=request.getSession();
		ses.setAttribute("stateList1", ls);
		return new ModelAndView("searchState");
	}
	@RequestMapping("/editState")
	public ModelAndView editState(HttpServletRequest request)
	{
		HttpSession ses=request.getSession();
		int stateId=(Integer.parseInt(request.getParameter("stateId")));
		StateVo sv=this.sd.selectById(stateId);
		ses.setAttribute("editStateList", sv);
		List ls=this.sd.select();
		System.out.print("done");
		
		ses.setAttribute("stateList1", ls);
		StateVo snew=new StateVo();
		return new ModelAndView("searchState","svo",snew);
		
	}

	@RequestMapping("/updateState")
	public ModelAndView updateState(HttpServletRequest request,@ModelAttribute("svo") StateVo sv)
	{
		HttpSession ses=request.getSession();
		
		this.sd.update(sv);
		ses.removeAttribute("editStateList");
		List ls=this.sd.select();
		System.out.print("done");
		
		ses.setAttribute("stateList1", ls);
		return new ModelAndView("searchState");
	}




}
