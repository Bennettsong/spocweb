package com.spoc.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.expr.NewArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spoc.po.Affair_category;
import com.spoc.po.Apply;
import com.spoc.po.College;
import com.spoc.po.Group_manage;
import com.spoc.po.Honor;
import com.spoc.po.Member;
import com.spoc.po.Member_group;
import com.spoc.po.Member_group_view;
import com.spoc.po.Type_category;
import com.spoc.service.CollegeService;
import com.spoc.service.Group_manageService;
import com.spoc.service.HonorService;
import com.spoc.service.MemberService;
import com.spoc.service.Member_groupService;
import com.spoc.service.Member_group_viewService;

@Controller("honorController")
@RequestMapping("/jsp")
public class HonorController {

	@Autowired
	private HonorService honorService;

	@RequestMapping("/honors.do")
	public String apply(HttpServletRequest request, ModelMap map)
	{
		List<Honor> list=honorService.getHonor();
		map.addAttribute("honors", list);
		map.addAttribute("honortype",  honorService.getHonor());
		return "honor";
	}
	@RequestMapping("/honorS.do")
	public String honor(HttpServletRequest request, ModelMap map)
	{
		HttpSession session=request.getSession();
		if(request.getParameter("hid")==null)
		{
			return "forward:honors.do";
		}
		int hid=Integer.valueOf(request.getParameter("hid"));
		honorService.updateHonor(hid);
		return "forward:honors.do";
	}
	@RequestMapping(value = "/addhonor.do")
	public String addHonors(HttpServletRequest request, ModelMap map)
			throws Exception {
		String time = request.getParameter("time");
		if(time==null)
		{
			return "forward:honors.do";
		}
		// 上传文件（图片），将文件存入服务器指定路径下，并获得文件的相对路径

				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				// 得到上传的文件
				MultipartFile mFile = multipartRequest.getFile("imgOne");
				// 得到上传服务器的路径
				String path = request.getSession().getServletContext()
						.getRealPath("/infor/honor/");
				// 得到上传的文件的文件名
				String fileName = mFile.getOriginalFilename();
				System.out.println(fileName);
				String fileType = fileName.substring(fileName.lastIndexOf("."));
				String filename = new Date().getTime() + fileType;
				InputStream inputStream = mFile.getInputStream();
				byte[] b = new byte[1048576];
				int length = inputStream.read(b);
				path += "\\" + filename;
				// 文件流写到服务器端
				FileOutputStream outputStream = new FileOutputStream(path);
				outputStream.write(b, 0, length);
				inputStream.close();
				outputStream.close();
				filename = "../infor/honor/" + filename;
				
				// HttpSession session = request.getSession();
				//   session.setAttribute("aaa", filename);

				String hid =request.getParameter("hid");
				
				String description=request.getParameter("description");
				Honor honor=new Honor(hid,time,filename,description);
				honorService.addHonor(honor);
				return "forward:honors.do";
	}
	@RequestMapping("/updateHonor.do")
	public String updateHonor(HttpServletRequest request, ModelMap map)
	{
		String hid =request.getParameter("hid");
		if(hid==null)
		{
			return "forward:honors.do";
		}
		String time = request.getParameter("time");
		String description=request.getParameter("description");
		String img=request.getParameter("img");
		Honor Hn=new Honor(hid,time,img,description);
		honorService.update(Hn);
		return "forward:honors.do";
	}
        @RequestMapping("/deleteHonor.do") //删除管理员所选择的相应的记录
	public String deleteHonor(HttpServletRequest request)
	{
		String[] check=request.getParameterValues("deletehonor");
		if(check==null)
		{
			return "forward:honors.do";
		}
		honorService.deleteHonor(check);
		return "forward:honors.do";
	}
	
}
