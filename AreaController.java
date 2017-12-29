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
import com.dao.CityDao;
import com.dao.StateDao;
import com.vo.AreaVo;
import com.vo.BranchVo;

@Controller
public class AreaController {
	@Autowired StateDao sd;
	@Autowired CityDao cd;
	@Autowired AreaDao areaDao;
	@RequestMapping(value="/manageArea",method=RequestMethod.GET)
	public ModelAndView insertArea(HttpServletRequest request)
	{
		
		HttpSession ss=request.getSession();
		List l=this.sd.select();
		ss.setAttribute("stateList", l);
		

		return new ModelAndView("addArea","areaVo",new AreaVo());
		
		
	}
	@RequestMapping("/saveArea")
	public ModelAndView saveArea(HttpServletRequest request,@ModelAttribute("areaVo") AreaVo areaVo)
	{
		
		this.areaDao.save(areaVo);
		System.out.println("done1");
		AreaVo anew=new AreaVo();
		return new ModelAndView("addArea","areaVo",anew);
		
		
	}
	@RequestMapping("/manageStateToCity")
	public ModelAndView manageStateToCity(HttpServletRequest request)
	{
		
		int stateId=Integer.parseInt(request.getParameter("stateId"));
		
		List l=this.cd.search(stateId);
		HttpSession s=request.getSession();
		s.setAttribute("citylist", l);
		return new ModelAndView("cityJson","","");
		
	}
	@RequestMapping("/searchArea")
	public ModelAndView searchArea(HttpServletRequest request,HttpServletResponse response)
	{
		
		List ls=this.areaDao.select();
		HttpSession ses=request.getSession();
		ses.setAttribute("areaList1", ls);
		//ses.setAttribute("set", true);
		/*try{
		response.sendRedirect("searchLoan.jsp");
		}catch(Exception e){System.out.print("error");}*/
		return new ModelAndView("searchArea");
		
	}
	@RequestMapping("/deleteArea")
	public ModelAndView deleteArea(HttpServletRequest request)
	{
		String s1=request.getParameter("areaId");
		int i=Integer.parseInt(s1);
		AreaVo av=new AreaVo();
		av.setAreaId(i);
		this.areaDao.delete(av);
		System.out.println("hio");
		List ls=this.areaDao.select();
		HttpSession ses=request.getSession();
		ses.setAttribute("areaList1", ls);
		return new ModelAndView("searchArea");
	}
	@RequestMapping("/editArea")
	public ModelAndView editArea(HttpServletRequest request)
	{
		HttpSession ses=request.getSession();
		int areaId=(Integer.parseInt(request.getParameter("areaId")));
		AreaVo av=this.areaDao.selectById(areaId);
		ses.setAttribute("editAreaList", av);
		List ls=this.areaDao.select();
		System.out.print("done");
		
		ses.setAttribute("areaList1", ls);
		AreaVo anew=new AreaVo();
		return new ModelAndView("searchArea","avo",anew);
		
	}
	
	@RequestMapping("/updateArea")
	public ModelAndView updateArea(HttpServletRequest request,@ModelAttribute("avo") AreaVo av)
	{
		HttpSession ses=request.getSession();
		
		this.areaDao.update(av);
		ses.removeAttribute("editAreaList");
		List ls=this.areaDao.select();
		System.out.print("done");
		
		ses.setAttribute("areaList1", ls);
		return new ModelAndView("searchArea");
	}
	
	

}
