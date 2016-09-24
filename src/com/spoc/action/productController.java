package com.spoc.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

//import com.qcloud.video.api.VideoCloud;
import com.spoc.po.member_product;
import com.spoc.po.product;
import com.spoc.service.productservice;

@Controller("productController")
@RequestMapping("/jsp")
public class productController
{
	@Autowired
	private productservice proservice;
	@Autowired
	private productservice prosservice;	
	@RequestMapping("/products.do")
	public String getproducts(HttpServletRequest request,ModelMap map)
	{
		List<product> products=proservice.getProducts();
		map.addAttribute("products1", products);
		return "product";
	}
	@RequestMapping("/deleteproducts.do")
	public String deleteproducts(HttpServletRequest request,ModelMap map)
	{
		String[] str=request.getParameterValues("products");
		if(str==null)
		{
			return "forward:products.do";
		}
		int [] pro = new int[str.length];
		for(int i=0;i<str.length;i++)
		{
			pro[i]=Integer.valueOf(str[i]).intValue();
		}
		prosservice.deleteproducts(pro);
		return "forward:products.do";
	}
	@RequestMapping(value="/updateproduct.do")
	public String updateproducts(HttpServletRequest request,ModelMap map)throws Exception
	{		
		String pidvalue=request.getParameter("pid");
		if(pidvalue==null)
		{
			return "forward:products.do";
		}
		int pid=Integer.parseInt(pidvalue);
		String lpidvalue=request.getParameter("lpid");
		int lpid=Integer.parseInt(lpidvalue);
		String name = request.getParameter("name");
		String description= request.getParameter("description");
		String time = request.getParameter("time");
		String student = request.getParameter("student");
		String teacher = request.getParameter("teacher");
		String pro_path=request.getParameter("pro_path");
		String img_path=request.getParameter("img_path");
		String flagvalue = request.getParameter("flag");
		int flag=Integer.parseInt(flagvalue);
		product pr=new product(pid,name,time,description,pro_path,img_path,flag);
		member_product mpr=new member_product(lpid,pid,student,teacher);
		proservice.updateproducts(pr, mpr);
		return "forward:products.do";
	}
	@RequestMapping("/productsdetail.do")
	public String productdetail(HttpServletRequest request,ModelMap map)
	{
		String pidvalue=request.getParameter("id");
		if(pidvalue==null)
		{
			return "forward:products.do";
		}
		int pid=Integer.parseInt(pidvalue);
		product pr=proservice.getproduct(pid);
		member_product mpr=proservice.getproducts(pid);
		map.addAttribute("pr", pr);
		map.addAttribute("mpr", mpr);
		return "detailproduct";
	}
	@RequestMapping(value = "/addproduct.do")
	public String addproduct(HttpServletRequest request, ModelMap map) throws IOException
	{
		String name = request.getParameter("name");
		if(name==null)
		{
			return "forward:products.do";
		}
		// 上传文件（图片），将文件存入服务器指定路径下，并获得文件的相对路径
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 得到上传的文件
		MultipartFile mFile = multipartRequest.getFile("img_path");
		// 得到上传服务器的路径
		String path = request.getSession().getServletContext().getRealPath("/infor/video_img/");
		// 得到上传的文件的文件名
		String fileName = mFile.getOriginalFilename();
		System.out.println(fileName);
		/*String fileType = fileName.substring(fileName.lastIndexOf("."));
		String filename = new Date().getTime() + fileType;*/
		InputStream inputStream = mFile.getInputStream();
		byte[] b = new byte[1048576];
		int length = inputStream.read(b);
		path += "\\" + fileName;
		// 文件流写到服务器端
		FileOutputStream outputStream = new FileOutputStream(path);
		outputStream.write(b, 0, length);
		inputStream.close();
		outputStream.close();
		fileName = "../infor/video_img/" + fileName;
//		//上传视频，将视频存于腾讯云中，并获得文件的相对路径
//		final int APP_ID = 10056183;
//		final String SECRET_ID = "AKIDR0YEkDMTKtoC77T1tQ3YmmAzHHpHtW7i";
//		final String SECRET_KEY = "w6IBn2LPxxMOAF133Wy3y5I1eGt5UYPi";
//		VideoCloud video = new VideoCloud(APP_ID, SECRET_ID, SECRET_KEY);
//		try
//		{
//		String result = "";
//		String bucketName = "abcde";
//        String coverUrl = "http://ceshi-1000027.file.myqcloud.com/1.jpg";
//        long start = System.currentTimeMillis();
//        //上传视频
//        MultipartFile pFile = multipartRequest.getFile("pro_path");
//        String pro_path = pFile.getOriginalFilename();
//        System.out.println(pro_path);
//        String fileType1 = pro_path.substring(pro_path.lastIndexOf("."));
//		String filename1 = new Date().getTime() + fileType1;
//        
//        
//		//result = video.uploadFile(bucketName, "/sdk/test.mp4", pFile);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
		
		String description= request.getParameter("description");
		String time = request.getParameter("time");
		String student = request.getParameter("student");
		String teacher = request.getParameter("teacher");
		String flagvalue = request.getParameter("inlineRadioOptions");
		int flag=Integer.parseInt(flagvalue);
		product pr=new product(name,time,description,fileName,flag);
		int pid=proservice.addproduct(pr);
		member_product mpr=new member_product(pid,student,teacher);
		proservice.addmember_product(mpr);
		return "forward:products.do";
	}
}
