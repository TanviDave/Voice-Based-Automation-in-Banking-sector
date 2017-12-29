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

import com.dao.CityDao;
import com.dao.StateDao;
import com.vo.AreaVo;
import com.vo.CityVo;

@Controller
public class CityController {
	@Autowired StateDao sd;
	@Autowired CityDao cd;
	
	@RequestMapping(value="/manageCity",method=RequestMethod.GET)
	public ModelAndView insertCity(HttpServletRequest request)
	{
		
		HttpSession ss=request.getSession();
		List l=this.sd.select();
		ss.setAttribute("stateList", l);
		
	
		return new ModelAndView("addCity","cvo",new CityVo());
		
		
	}

@RequestMapping(value="/saveCity",method=RequestMethod.POST)
public ModelAndView saveCity(@ModelAttribute("cvo") CityVo cv)
{
	System.out.println("imnnnnn");
	this.cd.save(cv);
	System.out.println("done2");
	
	CityVo cnew=new CityVo();
	return new ModelAndView("addCity","","");
	
	
}
@RequestMapping("/searchCity")
public ModelAndView searchCity(HttpServletRequest request,HttpServletResponse response)
{
	
	List ls=this.cd.select();
	HttpSession ses=request.getSession();
	ses.setAttribute("cityList1", ls);
	//ses.setAttribute("set", true);
	/*try{
	response.sendRedirect("searchLoan.jsp");
	}catch(Exception e){System.out.print("error");}*/
	return new ModelAndView("searchCity");
	
}
@RequestMapping("/deleteCity")
public ModelAndView deleteCity(HttpServletRequest request)
{
	String s1=request.getParameter("cityId");
	int i=Integer.parseInt(s1);
	CityVo cv=new CityVo();
	cv.setCityId(i);
	this.cd.delete(cv);
	System.out.println("hio");
	List ls=this.cd.select();
	HttpSession ses=request.getSession();
	ses.setAttribute("cityList1", ls);
	return new ModelAndView("searchCity");
}
@RequestMapping("/editCity")
public ModelAndView editCity(HttpServletRequest request)
{
	HttpSession ses=request.getSession();
	int cityId=(Integer.parseInt(request.getParameter("cityId")));
	CityVo cv=this.cd.selectById(cityId);
	ses.setAttribute("editCityList", cv);
	List ls=this.cd.select();
	System.out.print("done");
	
	ses.setAttribute("cityList1", ls);
	CityVo cnew=new CityVo();
	return new ModelAndView("searchCity","cvo",cnew);
	
}

@RequestMapping("/updateCity")
public ModelAndView updateCity(HttpServletRequest request,@ModelAttribute("cvo") CityVo cv)
{
	HttpSession ses=request.getSession();
	
	this.cd.update(cv);
	ses.removeAttribute("editCityList");
	List ls=this.cd.select();
	System.out.print("done");
	
	ses.setAttribute("cityList1", ls);
	return new ModelAndView("searchCity");
}





}
