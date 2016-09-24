package com.spoc.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spoc.dao.Group_manageDao;
import com.spoc.po.Apply;
import com.spoc.po.College;
import com.spoc.po.Group_manage;
import com.spoc.service.ApplyService;
import com.spoc.service.CollegeService;
import com.spoc.service.Group_manageService;

@Controller("userApplyController")
@RequestMapping("/jsp")
public class UserApplyController {
	
	@Autowired
 private CollegeService collegeService;
	@Autowired
 private Group_manageService group_manageService;
	@Autowired
 private ApplyService applyService;
	
  @RequestMapping("/apply.do")
  public String userApply(HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	 
	  String name=request.getParameter("name");
	  if(name==null)
	  {
		  return "forward:applyjsp.do";
	  }
	  String sex=request.getParameter("sex");
	  String college=request.getParameter("college");
	  String grade=request.getParameter("grade");
	  String major=request.getParameter("major");
	  String phone=request.getParameter("phone");
	  String group=request.getParameter("group");
	  
	  Apply apply=new Apply(name,sex,college,grade,major,phone,group);
	  applyService.userApply(apply);
	  
	  return "redirect:../affair.do";
  }
  
  @RequestMapping("/applyjsp.do")
  public ModelAndView getInfo(ModelMap map)
  {
	  List<College> colleges=collegeService.getCollege();
	  List<Group_manage> groups=group_manageService.getGroup(); 
	  map.addAttribute("colleges", colleges);
	  map.addAttribute("groups", groups);
	  
	  return new ModelAndView("apply");
  }
  
  @RequestMapping("/displayApply.do")
  public String displayApply(ModelMap map)
  {
	  map.addAttribute("applys", applyService.getApply());
	  return "displayApply";
  }
}
 