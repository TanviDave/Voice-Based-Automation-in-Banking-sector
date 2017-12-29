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

import com.dao.AreaDao;
import com.dao.BranchDao;
import com.dao.StateDao;
import com.vo.BranchVo;
import com.vo.LoanVo;

@Controller
public class BranchController {
	@Autowired AreaDao areaDao;
	@Autowired BranchDao branchDao;
	@Autowired StateDao sd;
	@RequestMapping(value="/manageBranch",method=RequestMethod.GET)
	public ModelAndView insertBranch(HttpServletRequest request,@ModelAttribute("branchVo") BranchVo branchVo)
	{
		
		HttpSession ss=request.getSession();
		List l=this.sd.select();
		ss.setAttribute("stateList", l);
		BranchVo bvo=new BranchVo();
		

		return new ModelAndView("addBranch","branchVo",bvo);
		
		
	}
	@RequestMapping("/manageCityToArea")
	public ModelAndView manageCityToArea(HttpServletRequest request)
	{
		
		int cityId=Integer.parseInt(request.getParameter("cityId"));
		
		List l=this.areaDao.search(cityId);
		HttpSession s=request.getSession();
		s.setAttribute("arealist", l);
		return new ModelAndView("areaJson","","");
		
	}
	@RequestMapping("/saveBranch")
	public ModelAndView saveBranch(HttpServletRequest request,@ModelAttribute("branchVo") BranchVo branchVo)
	{
		
		this.branchDao.save(branchVo);
		System.out.println("done1");
		BranchVo bnew=new BranchVo();
		return new ModelAndView("addBranch","branchVo",bnew);
		
		
	}
	@RequestMapping("/searchBranch")
	public ModelAndView searchBranch(HttpServletRequest request,HttpServletResponse response)
	{
		
		List ls=this.branchDao.select();
		HttpSession ses=request.getSession();
		ses.setAttribute("branchList1", ls);
		//ses.setAttribute("set", true);
		/*try{
		response.sendRedirect("searchLoan.jsp");
		}catch(Exception e){System.out.print("error");}*/
		return new ModelAndView("searchBranch");
		
	}
	@RequestMapping("/deleteBranch")
	public ModelAndView deleteBranch(HttpServletRequest request)
	{
		String s1=request.getParameter("branchId");
		int i=Integer.parseInt(s1);
		BranchVo bv=new BranchVo();
		bv.setBranchId(i);
		this.branchDao.delete(bv);
		System.out.println("hio");
		List ls=this.branchDao.select();
		HttpSession ses=request.getSession();
		ses.setAttribute("branchList1", ls);
		return new ModelAndView("searchBranch");
	}
	@RequestMapping("/editBranch")
	public ModelAndView editBranch(HttpServletRequest request)
	{
		HttpSession ses=request.getSession();
		int branchId=(Integer.parseInt(request.getParameter("branchId")));
		BranchVo bv=this.branchDao.selectById(branchId);
		ses.setAttribute("editBranchList", bv);
		List ls=this.branchDao.select();
		System.out.print("done");
		
		ses.setAttribute("branchList1", ls);
		BranchVo bnew=new BranchVo();
		return new ModelAndView("searchBranch","bvo",bnew);
		
	}
	
	@RequestMapping("/updateBranch")
	public ModelAndView updateBranch(HttpServletRequest request,@ModelAttribute("bvo") BranchVo bv)
	{
		HttpSession ses=request.getSession();
		
		this.branchDao.update(bv);
		ses.removeAttribute("editBranchList");
		List ls=this.branchDao.select();
		System.out.print("done");
		
		ses.setAttribute("branchList1", ls);
		return new ModelAndView("searchBranch");
	}
	
	


}
