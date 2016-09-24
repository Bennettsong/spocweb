package com.spoc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spoc.po.Affair_category;
import com.spoc.po.Service_type;
import com.spoc.service.Service_TypeService;

@Controller("serviceTypeController")
@RequestMapping("/jsp")
public class ServiceTypeController {

	@Autowired
	private Service_TypeService service_TypeService;
	
	@RequestMapping("/service.do")
	public String getType(HttpServletRequest request, ModelMap map)
	{
		List<Service_type> list=service_TypeService.getServiceTypes();
		map.addAttribute("serviceTypes", list);
		return "serviceType";


	}
	
	@RequestMapping("/searchServiceType.do")
	public String searchServiceType(HttpServletRequest request, ModelMap map)
	{
		String type=request.getParameter("servicetype");
		List<Service_type> list=service_TypeService.searchType(type);
		map.addAttribute("serviceTypes", list);
		return "serviceType";

	}
	
	@RequestMapping("/addServiceType.do")
	public String addServiceType(HttpServletRequest request, ModelMap map)
	{
		String type=request.getParameter("type");
		if(type==null)
		{
			return "forward:service.do";
		}
		service_TypeService.addServicetype(type);
		return "forward:service.do";
	}
	
	@RequestMapping("/deleteServiceType.do")
	public String deleteServiceType(HttpServletRequest request, ModelMap map)
	{
	String[] check = request.getParameterValues("type");
	if(check==null)
	{
		return "forward:service.do";
	}
	service_TypeService.deleteType(check);
	return "forward:service.do";
	}
}
