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

import com.dao.PostDao;
import com.vo.CityVo;
import com.vo.PostVo;

@Controller
public class PostController {
	@Autowired PostDao pd;
	@RequestMapping("/managePostType") 
	public ModelAndView insert()
	{
		PostVo p=new PostVo();
		return new ModelAndView("addPost","pvo",p);
	}
	@RequestMapping("/savePost")
	public ModelAndView savePost(HttpServletRequest request,@ModelAttribute("pvo") PostVo p)
	{
		System.out.println("done");
		this.pd.save(p);
		System.out.println("done1");
		PostVo pnew=new PostVo();
		return new ModelAndView("addPost","pvo",pnew);
	 }
	@RequestMapping("/searchpost")
	public ModelAndView searchPost(HttpServletRequest request,HttpServletResponse response)
	{
		
		List ls=this.pd.display();
		HttpSession ses=request.getSession();
		ses.setAttribute("postList1", ls);
		//ses.setAttribute("set", true);
		/*try{
		response.sendRedirect("searchLoan.jsp");
		}catch(Exception e){System.out.print("error");}*/
		return new ModelAndView("searchPost");
		
	}
	@RequestMapping("/deletePost")
	public ModelAndView deletePost(HttpServletRequest request)
	{
		String s1=request.getParameter("id");
		int i=Integer.parseInt(s1);
		PostVo p=new PostVo();
		p.setPostId(i);
		this.pd.delete(p);
		System.out.println("hio");
		List ls=this.pd.display();
		HttpSession ses=request.getSession();
		ses.setAttribute("postList1", ls);
		return new ModelAndView("searchPost");
	}
	@RequestMapping("/editPost")
	public ModelAndView editPost(HttpServletRequest request)
	{
		HttpSession ses=request.getSession();
		int postId=(Integer.parseInt(request.getParameter("id")));
		PostVo pv=this.pd.selectById(postId);
		ses.setAttribute("editPostList", pv);
		List ls=this.pd.select();
		System.out.print("done");
		
		ses.setAttribute("postList1", ls);
		PostVo pnew=new PostVo();
		return new ModelAndView("searchPost","pvo",pnew);
		
	}

	@RequestMapping("/updatePost")
	public ModelAndView updatePost(HttpServletRequest request,@ModelAttribute("pvo") PostVo pv)
	{
		HttpSession ses=request.getSession();
		
		this.pd.update(pv);
		ses.removeAttribute("editPostList");
		List ls=this.pd.select();
		System.out.print("done");
		ses.setAttribute("postList1", ls);
		return new ModelAndView("searchPost");
	}


}
