package com.spoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spoc.po.Charge_Standard;
import com.spoc.po.Group_manage;
import com.spoc.service.Group_manageService;

@Controller("groupManageController")
@RequestMapping("/jsp")
public class GroupManageController {

	@Autowired
	private Group_manageService group_manageService;
	
	@RequestMapping("/group.do")  //转向groupManage.jsp页面
	public String groupManage(HttpServletRequest request, ModelMap map)
	{
		map.addAttribute("groups", group_manageService.getGroup());
		return "groupManage";
	}
	
	@RequestMapping("/addGroup.do")  //转向groupManage.jsp页面
	public String addGroup(HttpServletRequest request, ModelMap map)
	{
		String name=request.getParameter("name");
		if(name==null)
		{
			return "redirect:group.do";
		}
		String description=request.getParameter("description");
		Group_manage gm=new Group_manage(name,description);
		group_manageService.addGroup(gm);
		return "redirect:group.do";
	}
	
	@RequestMapping("/deleteGroup.do")  //转向groupManage.jsp页面
	public String deleteGroup(HttpServletRequest request, ModelMap map)
	{
		String[] check = request.getParameterValues("type");
		if(check==null)
		{
			return "redirect:group.do";
		}
		group_manageService.deleteGroups(check);
		return "redirect:group.do";
	}
	
	@RequestMapping("/updateGroup.do")  //转向groupManage.jsp页面
	public String updateGroup(HttpServletRequest request, ModelMap map)
	{
		if(request.getParameter("gid")==null)
		{
			return "redirect:group.do";
		}
		int gid=Integer.valueOf(request.getParameter("gid"));
		System.out.println("gid:"+gid);
		String name=request.getParameter("name");
		System.out.println("name:"+name);
		String description=request.getParameter("description");
		System.out.println("description:"+description);
		Group_manage gm=new Group_manage(gid,name,description);
		group_manageService.updateGroup(gm);
		return "redirect:group.do";
	}
}
