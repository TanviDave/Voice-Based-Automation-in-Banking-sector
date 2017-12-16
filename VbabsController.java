package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.PostDao;
import com.vo.PostVo;



@Controller
public class VbabsController {
	
    @Autowired PostDao pd;
	
	@RequestMapping("/managePostType") 
	public ModelAndView insert()
	{
		PostVo p=new PostVo();
		return new ModelAndView("addPost","pvo",p);
	}
	@RequestMapping("/savePost")
	public ModelAndView save(HttpServletRequest request,@ModelAttribute("pvo") PostVo p)
	{
		System.out.println("done");
		this.pd.save(p);
		System.out.println("done1");
		PostVo pnew=new PostVo();
		return new ModelAndView("addPost","pvo",pnew);
     }
	
	@RequestMapping("/login1")
	public ModelAndView login()
	{
		return new ModelAndView("login","","");
	}
	@RequestMapping("/verify")
	public ModelAndView verify(HttpServletRequest request)
	{
	    String s1=request.getParameter("username");
	    String s2=request.getParameter("password");
		if(s1.equals("admin")&&s2.equals("admin"))
		{
			return new ModelAndView("welcome","Message","Verified Successfully");
		}
		else
		{
			return new ModelAndView("welcome","Message","UserName or Password is incorrect");
		}
		
	}
	
	
	

	
	


}
