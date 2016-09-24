package com.spoc.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.qcloud.video.api.VideoCloud;
import com.spoc.po.member_product;
import com.spoc.po.product;
import com.spoc.service.uploadproduct;

public class test extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public test()
	{
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		request.setCharacterEncoding("utf-8");//防止中文名乱码
		String basePath = this.getServletContext().getRealPath("/infor/video_img/");
//		File repository = new File(basePath); //缓存区目录
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//      diskFileItemFactory.setRepository(repository);
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        List<FileItem> fileItems = null;
        String pro_path="";
        String pro_name="";
        String name="";
        String time="";
        String description="";
        String student = "";
		String teacher ="";
		String flagvalue ="";
		int flag=0;
        String filePath="";
        String fileName="";
        try
        {
            fileItems = servletFileUpload.parseRequest(request);
       	 	int i=1;
            for(FileItem fileItem:fileItems)
            {
            	if(fileItem.isFormField())
            	{
            		String param = fileItem.getFieldName();
            		String paramvalue = fileItem.getString("utf-8");
            		if(param.equals("name"))
            		{
            			name=paramvalue;
            		}
            		else if(param.equals("time"))
            		{
            			time=paramvalue;
            		}
            		else if(param.equals("student"))
            		{
            			student=paramvalue;
            		}
            		else if(param.equals("teacher"))
            		{
            			teacher=paramvalue;
            		}
            		else if(param.equals("description"))
            		{
            			description=paramvalue;
            		}
            		else if(param.equals("inlineRadioOptions"))
            		{
            			flagvalue=paramvalue;
            			flag=Integer.parseInt(flagvalue);
            		}
            	}
            	 if(i==1)
            	 {
                     long size=0;
                     filePath = fileItem.getName();
                     if(filePath==null || filePath.trim().length()==0)
                     {
                         continue;
                     }
                     fileName=filePath.substring(filePath.lastIndexOf(File.separator)+1);
                     try 
                     {
                    	 fileItem.write(new File(basePath+File.separator+fileName));
                     } 
                     catch (Exception e) 
                     {
                         e.printStackTrace();
                     }
                     i++;
            	 }
            	 else
            	 {
            		 long size=0;
                     pro_path = fileItem.getName();
//                     System.out.println(filePath1);
                     if(pro_path==null || pro_path.trim().length()==0)
                     {
                         continue;
                     }
                     pro_name=pro_path.substring(pro_path.lastIndexOf(File.separator)+1);
                     break; 
            	 }
            }
            
            System.out.println(fileName+filePath);
            System.out.println(pro_name);
            System.out.println(pro_path);
            System.out.println(name+"  "+time+"  "+student+"  "+teacher+"  "+flag+"  "+description);
        }
        catch(FileUploadException e1)
        {
            e1.printStackTrace();
        }
		final int APP_ID = 10056183;
		final String SECRET_ID = "AKIDR0YEkDMTKtoC77T1tQ3YmmAzHHpHtW7i";
		final String SECRET_KEY = "w6IBn2LPxxMOAF133Wy3y5I1eGt5UYPi";
		VideoCloud video = new VideoCloud(APP_ID, SECRET_ID, SECRET_KEY);
		try
		{
			String result = "";
			String bucketName = "systemcover";
			long start = System.currentTimeMillis();
			result=video.uploadFile(bucketName, pro_name, pro_path);
			System.out.println("=======updateFile========\n"+result);
			JSONObject json1=new JSONObject(result);
			JSONObject json2=json1.getJSONObject("data");
			System.out.println("视频地址是"+json2.getString("access_url"));	
			pro_path=json2.getString("access_url");
			System.out.println(pro_path);
			long end = System.currentTimeMillis();			
            System.out.println("总用时：" + (end - start) + "毫秒");
			System.out.println("The End!");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		fileName = "../infor/video_img/" + fileName;
		System.out.println(name+time+description+pro_path+fileName+flag);
		product pr=new product(name,time,description,pro_path,fileName,flag);
		uploadproduct up=new uploadproduct();
		int pid=up.addproduct(pr);
		member_product mpr=new member_product(pid,student,teacher);
		up.addmember_product(mpr);
		response.sendRedirect("/SpocWeb/jsp/success.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException
	{
		// Put your code here
	}

}
