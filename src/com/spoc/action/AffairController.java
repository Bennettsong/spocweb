package com.spoc.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spoc.po.Affair;
import com.spoc.po.Affair_category;
import com.spoc.po.Apply;
import com.spoc.po.Member;
import com.spoc.service.AffairService;
import com.spoc.service.Affair_categoryService;
import com.spoc.service.ApplyService;
import com.spoc.service.MemberService;
import com.spoc.service.UserService;

@Controller("affairController")
@RequestMapping("/jsp")
public class AffairController {

	@Autowired
	private Affair_categoryService affair_categoryService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private AffairService affairService;
	@Autowired
	private UserService userService;
	@Autowired
	private MemberService memberService;
	
	private ServletContext servletContext;
	@RequestMapping("/lianxi.do")
	public String userAffair(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		
		String name=request.getParameter("name");
		if(name==null)
		{
			return "affair";
		}
		String phone=request.getParameter("phone");
		String content=request.getParameter("content");
		HttpSession session = request.getSession();
		String doc=(String) session.getAttribute("flag");
		String type[]=request.getParameterValues("inlineCheckbox");
		String str="";
		if(type!=null)
		{
			for(int i=0;i<type.length;i++)
			{
				str+=type[i]+" ";	
			}
		}
		Affair affair=new Affair(name,phone,content,str,doc);
		affairService.add(affair);
		 request.getSession().invalidate();
		return "redirect:../affair.do";
	}
	@RequestMapping("/lianxijsp.do")
	public String getInfo(ModelMap map) 
	{
		List<Affair_category> Charge=affair_categoryService.getAffairCa();
		
		map.addAttribute("Charge", Charge);
		return "affair";
	}
	public void setServletContext(ServletContext context) {
		this.servletContext  = context;
	}
	
	@RequestMapping(value="/upload.do")
	public String handleUploadData(HttpServletRequest request, ModelMap map) throws IOException
	{
		// 上传文件（图片），将文件存入服务器指定路径下，并获得文件的相对路径

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 得到上传的文件
		MultipartFile mFile = multipartRequest.getFile("imgOne");
		if (!mFile.isEmpty()) {
			// 得到上传服务器的路径
			String path = request.getSession().getServletContext()
					.getRealPath("/infor/test/");
			   System.out.println(path);
			   String fileName = mFile.getOriginalFilename();
			   String fileType = fileName.substring(fileName.lastIndexOf("."));
			   String filename = new Date().getTime() + fileType;
			   InputStream inputStream = mFile.getInputStream();
				byte[] b = new byte[1048576];
				int length = inputStream.read(b);
			   path += "\\" + filename;
			   FileOutputStream outputStream = new FileOutputStream(path);
				outputStream.write(b, 0, length);
				inputStream.close();
				outputStream.close();
				filename = "../infor/test/" + filename;
			   HttpSession session = request.getSession();
			   session.setAttribute("flag", filename);
			    return "redirect:lianxijsp.do";
			}
		   else
			{
				 return "redirect:lianxijsp.do";
			}
	}
	
	@RequestMapping("/dealAT.do") 
	public String dealAffairType(HttpServletRequest request, ModelMap map)
	{
		map.addAttribute("affairtypes", affair_categoryService.getAffairCa());
		return "dealAffairType";
	}
	@RequestMapping("/searchType.do")
	public String searchType(HttpServletRequest request, ModelMap map)
	{
		String affairtype=request.getParameter("affairtype");
		List<Affair_category> list=new ArrayList<Affair_category>();
		Affair_category ac=affair_categoryService.getAffairType(affairtype);
		list.add(ac);
		map.addAttribute("affairtypes",list );
		return "dealAffairType";
	}
	
	@RequestMapping("/addType.do")
	public String addType(HttpServletRequest request, ModelMap map)
	{
		String name=request.getParameter("name");
		if(name==null)
		{
			return "forward:dealAT.do";
		}
		int flag=Integer.valueOf(request.getParameter("flag"));
		String str=request.getParameter("rank");
		int rank=100;
		if(str!=null&&!str.equals(""))
		{
			rank=Integer.valueOf(str);	
		}	
		affair_categoryService.doAffairType(name, flag,rank);
		return "forward:dealAT.do";
	}
	
	@RequestMapping("/deleteType.do") 
	public String deleteType(HttpServletRequest request, ModelMap map)
	{
		String[] check = request.getParameterValues("type");
		if(check==null)
		{
			return "forward:dealAT.do";
		}
		affair_categoryService.deleteType(check);
		return "forward:dealAT.do";
	}
	
	@RequestMapping("/checkAff_ca.do") 
	@ResponseBody
	public String checkAff_ca(HttpServletRequest request, ModelMap map)
	{
		int acid = Integer.valueOf(request.getParameter("acid"));	
		System.out.println(acid);
		boolean flag=affair_categoryService.checkAff_ca(acid);
		String str="[{\"flag\":"+flag+"}]";
		JSONArray json = JSONArray.fromObject(str);	
		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping("/updateType.do") 
	public String updateType(HttpServletRequest request, ModelMap map)
	{
		if(request.getParameter("acid")==null)
		{
			return "forward:dealAT.do";
		}
		int acid=Integer.valueOf(request.getParameter("acid"));		
		String name=request.getParameter("typeName");
		int flag=Integer.valueOf(request.getParameter("flag"));
		String str=request.getParameter("rank");
		int rank=100;
		if(str!=null&&!str.equals(""))
		{
			rank=Integer.valueOf(str);	
		}	
		
		Affair_category ac=new Affair_category(acid,name,flag,rank);
		affair_categoryService.updateType(ac);
		return "forward:dealAT.do";
	}
	
	@RequestMapping("/applyAffair.do")
	public String applyAffair(HttpServletRequest request, ModelMap map)
	{
		/*
		 * applyAffair.jsp页面的查看详情，审阅完成的权限值分别为9,10
		 *
		 * */
		List<Affair> list=affairService.getAffairs();
		if(request.getParameter("flag")==null)
		{
			return "admin";
		}
		int flag=Integer.valueOf(request.getParameter("flag"));
		
		map.addAttribute("affairs", list);
		int userValue=(Integer) request.getSession().getAttribute("userAuthority");
		boolean sysbomlC;
		boolean sysbomlR;
		
		if(flag==0)
		{
			sysbomlC=userService.checkAuthority(userValue, 9);
			sysbomlR=userService.checkAuthority(userValue, 10);
			 map.addAttribute("sysbomlR", sysbomlR);
			 map.addAttribute("sysbomlC", sysbomlC);
		return "applyAffair";
		}else
		{
			return "affairHistory";
		}
		
	}
	
	@RequestMapping("/read.do")
	public String read(HttpServletRequest request, ModelMap map)
	{
		HttpSession session=request.getSession();
		//session.setAttribute("user", "ffff");//�������û���¼�������ڴ�session����
		if(request.getParameter("aff_id")==null)
		{
			return "forward:applyAffair.do?flag=0";
		}
		int aff_id=Integer.valueOf(request.getParameter("aff_id"));
		String loginid=(String) session.getAttribute("user");
		String dealname=memberService.getUniqueMember(loginid).getName();
		affairService.updateAffair(aff_id, dealname);
		return "forward:applyAffair.do?flag=0";
	}
	
	
	@RequestMapping("/deleteAffair.do")
	public String deleteAffair(HttpServletRequest request, ModelMap map)
	{
		String[] check = request.getParameterValues("affair");
		if(check==null)
		{
			return "forward:applyAffair.do?flag=1";
		}
		affairService.deleteAffair(check);
		return "forward:applyAffair.do?flag=1";
	}
	@RequestMapping("/applys.do")
	public String apply(HttpServletRequest request, ModelMap map)
	{
		List<Apply> list=applyService.getApply();
		//int flag=Integer.valueOf(request.getParameter("flag"));
		map.addAttribute("apply", list);
		return "houapply0";
	}
	@RequestMapping("/duqu.do")
	public String duqu(HttpServletRequest request, ModelMap map)
	{
		HttpSession session=request.getSession();
		if(request.getParameter("apply_id")==null)
		{
			return "forward:applys.do";
		}
		int apply_id=Integer.valueOf(request.getParameter("apply_id"));
                String[] check=request.getParameterValues("deleteapply");
		applyService.deleteAffair(check);
		//String loginid=(String) session.getAttribute("user");
		applyService.updateApply(apply_id);
		return "forward:applys.do";
	}
}
