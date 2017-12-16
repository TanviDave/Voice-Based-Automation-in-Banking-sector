package com.controller;

import java.util.List;







import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;













import com.dao.AreaDao;
import com.dao.BranchDao;
import com.dao.CityDao;
import com.dao.LoanDao;
import com.dao.StateDao;
import com.vo.AreaVo;
import com.vo.BranchVo;
import com.vo.CityVo;
import com.vo.LoanVo;
import com.vo.StateVo;




@Controller
public class VbabsController {
	@Autowired LoanDao ld1;
	@Autowired StateDao sd;
	@Autowired CityDao cd;
	@Autowired AreaDao areaDao;
	@Autowired BranchDao branchDao;
	
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
	/*@RequestMapping(value="save1.htm",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,@ModelAttribute("rvo") reg_vo r)
	{
		System.out.println("done");
		this.s.save1(r);
		System.out.println("done1");
		return new ModelAndView("reg2","message","Data Entered Successfully");
		
		
	}
	*/
@RequestMapping(value="/manageArea",method=RequestMethod.GET)
public ModelAndView insertArea(HttpServletRequest request)
{
	
	HttpSession ss=request.getSession();
	List l=this.sd.select();
	ss.setAttribute("stateList", l);
	

	return new ModelAndView("addArea","areaVo",new AreaVo());
	
	
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
@RequestMapping("/saveArea")
public ModelAndView saveArea(HttpServletRequest request,@ModelAttribute("areaVo") AreaVo areaVo)
{
	
	this.areaDao.save(areaVo);
	System.out.println("done1");
	AreaVo anew=new AreaVo();
	return new ModelAndView("addArea","areaVo",anew);
	
	
}
@RequestMapping(value="/manageBranch",method=RequestMethod.GET)
public ModelAndView insertBranch(HttpServletRequest request)
{
	
	HttpSession ss=request.getSession();
	List l=this.sd.select();
	ss.setAttribute("stateList", l);
	

	return new ModelAndView("addBranch","branchVo",new BranchVo());
	
	
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
}
