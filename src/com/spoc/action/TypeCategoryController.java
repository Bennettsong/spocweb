package com.spoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spoc.po.Type_category;
import com.spoc.service.Service_TypeService;
import com.spoc.service.TypeCategoryService;

@Controller("typeCategoryController")
@RequestMapping("/jsp")
public class TypeCategoryController {

	@Autowired
	private TypeCategoryService typeCategoryService;
	@Autowired
	private Service_TypeService service_TypeService;
	
	@RequestMapping("/TypeCategory.do")
	public String typeCategory(HttpServletRequest request, ModelMap map)
	{
		List<Type_category> list=typeCategoryService.getTypes();
		map.addAttribute("typecategorys", list);
		map.addAttribute("servicetypes", service_TypeService.getServiceTypes());
		return "TypeCategory";
	}
	
	@RequestMapping("/searchTypeCategory.do")
	public String searchTypeCategory(HttpServletRequest request, ModelMap map)
	{
		String type=request.getParameter("type");
		List<Type_category> list=typeCategoryService.getType(type);
		map.addAttribute("typecategorys", list);
		map.addAttribute("servicetypes", service_TypeService.getServiceTypes());
		return "TypeCategory";
	}
		
	@RequestMapping("/addTypeCategory.do")
	public String addTypeCategory(HttpServletRequest request, ModelMap map)
	{
		String description=request.getParameter("description");
		if(description==null)
		{
			return "forward:TypeCategory.do";
		}
		//System.out.println(request.getParameter("type"));
		int stid=Integer.valueOf(request.getParameter("type"));
		Type_category tc=new Type_category();
		tc.setDescription(description);
		tc.setStid(stid);
		typeCategoryService.addTypeCategory(tc);
		return "forward:TypeCategory.do";
	}
	
	@RequestMapping("/deleteTypeCategory.do")
	public String deleteTypeCategory(HttpServletRequest request, ModelMap map)
	{
		String[] check = request.getParameterValues("typeCh");
		if(check==null)
		{
			return "forward:TypeCategory.do";
		}
		typeCategoryService.deleteTypeCategory(check);
		return "forward:TypeCategory.do";
	}
	
	@RequestMapping("/updateTypeCategory.do")
	public String updateTypeCategory(HttpServletRequest request, ModelMap map)
	{
		String description=request.getParameter("description");
		if(description==null)
		{
			return "forward:TypeCategory.do";
		}
		int stid=Integer.valueOf(request.getParameter("type"));
		int tcid=Integer.valueOf(request.getParameter("tcid"));
		Type_category tc=new Type_category(tcid,description,stid);
		typeCategoryService.update(tc);
		return "forward:TypeCategory.do";
	}
}
