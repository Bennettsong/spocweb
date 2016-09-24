package com.spoc.action;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spoc.po.Member;
//import com.spoc.po.member;
import com.spoc.service.UserService;

@SuppressWarnings("unused")
@org.springframework.stereotype.Controller

@RequestMapping("/jsp")
public class UserController
{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/exit.do")
	public String exit(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:../affair.do";
	}
	
	@RequestMapping("/login.do")
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		if(request.getSession().getAttribute("user") != null)
		{
			return "admin";
		}
		    String loginid = request.getParameter("loginid");
		    System.out.println(loginid);
		    if(loginid==null)
		    {		    	
		    	return "redirect:../affair.do";
		    }
			String password = request.getParameter("password");
			System.out.println(loginid+" ha"+password);
			boolean flag1=userService.findAdmin(loginid, password);
			HttpSession session=request.getSession();
			Member member=new Member();
			if(flag1)
			{				
				session.setAttribute("user", loginid);
				session.setAttribute("userAuthority", userService.getAuthority(loginid));
				System.out.println("hello");
			    return "admin";
			}
			else
			{
				
				return "redirect:../affair.do";
			}
	}
	  
	
	private Member getMember(String loginid, String password)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public UserService getUserService()
	{
		return userService;
	}


	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}


}
