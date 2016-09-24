package com.spoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spoc.po.Charge_Standard;
import com.spoc.po.Type_category;
import com.spoc.service.Affair_categoryService;
import com.spoc.service.ChargeStandardService;
import com.spoc.service.TypeCategoryService;

@Controller("chargeStandardController")
@RequestMapping("/jsp")
public class ChargeStandardController {

	@Autowired
	private ChargeStandardService chargeStandardService;
	@Autowired
	private Affair_categoryService affair_categoryService;
	@Autowired
	private TypeCategoryService typeCategoryService;
	
	@RequestMapping("/chargeStandard.do")  //转向chargeStandard.jsp的准备工作
	public String chargeStandard(HttpServletRequest request, ModelMap map)
	{
		List<Charge_Standard> list=chargeStandardService.getTypes();
		map.addAttribute("chargeStandards", list);
		map.addAttribute("typeCategorys", typeCategoryService.getTypes());
		map.addAttribute("affairCategorys", affair_categoryService.getAffairCa());
		return "chargeStandard";
	}
	
	@RequestMapping("/addChargeStandard.do") //增加一条收费标准
	public String addChargeStandard(HttpServletRequest request, ModelMap map)
	{
		if(request.getParameter("affair")==null)
		{
			return "forward:chargeStandard.do";
		}
		int acid=Integer.valueOf(request.getParameter("affair"));
		int tcid=Integer.valueOf(request.getParameter("type"));
		String basic=request.getParameter("basic");
		String advance=request.getParameter("advance");
		String careless=request.getParameter("careless");
		Charge_Standard cs=new Charge_Standard(basic,advance,careless,acid,tcid);
		chargeStandardService.addChargeStandard(cs);
		return "forward:chargeStandard.do";
	}
	
	@RequestMapping("/deleteChargeStandard.do") //删除管理员所选择的相应的收费记录
	public String deleteChargeStandard(HttpServletRequest request)
	{
		String[] check=request.getParameterValues("typeCh");
		if(check==null)
		{
			return "forward:chargeStandard.do";
		}
		chargeStandardService.deleteChargeStandard(check);
		return "forward:chargeStandard.do";
	}
	
	@RequestMapping("/updateChargeStandard.do")
	public String updateChargeStandard(HttpServletRequest request)
	{
		if(request.getParameter("csid")==null)
		{
			return "forward:chargeStandard.do";
		}
		int csid=Integer.valueOf(request.getParameter("csid"));
		int acid=Integer.valueOf(request.getParameter("affair"));
		int tcid=Integer.valueOf(request.getParameter("type"));
		String basic=request.getParameter("basic");
		String advance=request.getParameter("advance");
		String careless=request.getParameter("careless");
		Charge_Standard cs=new Charge_Standard(csid,basic,advance,careless,acid,tcid);
		chargeStandardService.update(cs);
		return "forward:chargeStandard.do";
	}
}
