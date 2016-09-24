<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>加入我们</title>
	<!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/list_style.css" rel="stylesheet">
    <script src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>

<body>
<div class="container-fluid bg" style="backgroud-color:#a4bccd;">
<div class="container bg1">
	<center>
            <div class="bg2">
              <form action="apply.do" method="post"  onSubmit="return check()">
            	<div class="text-center"><img src="../image/1_02.gif"></div>
            	<div class="list_top">姓名</div>
                <div>
                	<textarea name="name" id="name" class="underline textarea_style"></textarea>
                </div>
                <div class="list_top">性别</div>
                <div class="list_top1">
                	<input name="sex" value="男" type="radio" checked="checked">
                    <label for="q2_1">男</label>
                    <input name="sex" id="q2_2" value="女" type="radio">
                    <label for="q2_2">女</label>
                </div>
                <div  class="list_top">学院班级</div>
                <div class="list_top1">
                	<select  name="college" id="college" size="1">
                	  <option value="-1">请选择</option>	
			             <c:forEach items='${colleges }' var="college">
			               <option value="${college.name}"> ${college.name} </option>	
			             </c:forEach>                	
                	</select>  
                    <select name="grade" id="grade">
                      <option  value="-1">请选择 </option>
                      <option value="大一">大一</option>
                      <option value="大二"> 大二 </option>
                      <option value="大三"> 大三 </option>
                      <option value="大四"> 大四 </option>
                     </select>  
                    <script class="resources library" src="up_file/area.js" type="text/javascript"></script>
                    <script type="text/javascript">_init_area();</script>
                </div>
                <div class="list_top1">
                	<input type="text" name="major" class="form-control textarea_style" id="inputEmail3" placeholder="班级">
                </div>
                <div class="list_top">手机号</div>
                <div>
                	<textarea name="phone" id="phone" class="underline textarea_style"></textarea>
                </div>
                 <div class="list_top">申报组别</div>
                <div class="list_top1">
                	<ul class="list-unstyled" id="spoc_gruop"><!--我将ul去掉了-->
                	   <c:forEach items='${groups}' var="group">
			              <li>
                        	<input value="${group.name}" name="group" id="group" type="radio">
                            <label>${group.name} </label>
                        </li>
			             </c:forEach>          	                       
                    </ul>
                </div>
                <div class="list_top2 text-center">
                	<input type="submit" name="submit"  class="btn btn-danger" style="width:100px;">
                </div>
                </form>
            </div>
      </center>
</div>
</div>
  <script type="text/javascript">
      function check()
      {
         var name=document.getElementById("name").value;
         var college=document.getElementById("college").value;
         var grade=document.getElementById("grade").value;
         var inputEmail3=document.getElementById("inputEmail3").value;
         var phone=document.getElementById("phone").value;
        
		 /*学姐，这个是我新加的内容*/
		 var radios=document.getElementsByName("group");
		 var m=0;
		 /*学姐，这个是我新加的内容*/
         
	     if(name=="")
	       {
		     alert("请填写您的姓名！");
		     return false;
		   }
		    if(college==-1)
	       {
		     alert("请选择您所在的学院！");
		     return false;
		   }
		    if(grade==-1)
	       {
		     alert("请选择您的年级！");
		     return false;
		   }
		      if(inputEmail3=="")
	       {
		     alert("请填写您的班级！");
		     return false;
		   }
		    if(phone=="")
	       {
		     alert("请填写您的电话号码！");		     
		     return false;
		   }
		   
		   /*学姐，这个是我新加的内容*/
		   for(var i=0;i<radios.length;i++)
			{
				if(radios[i].checked==false)
				{
					m=m+1;
				}
			}
			if(m==i)
			{
				alert("请选组别！！！");
				return false;
				}
		  /*学姐，这个是我新加的内容*/
		  
		     return true;
      }
  </script>
</body>
</html>
