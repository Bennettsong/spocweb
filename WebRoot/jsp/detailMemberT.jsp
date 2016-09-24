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
<title>信息展示</title>
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style type="text/css">
        #table tr td {
			border:solid 2px #fff;;
			
			}
			
    </style>
</head>

<body>
<div class="container table-responsive">
    <table class="table table-bordered" id="table" style="background-color: #e5f4f7;margin-top:120px;">
        <th colspan="7" style="text-align:center;font-size:3em;color:#00349a;background-color: #c4e1ef">     
                 个人信息
      </th>
        <tr>
            <td>登录名</td>
            <td>${member.loginid}</td>
            <td>密码</td>
            <td>${member.password}</td>
            <td>管理员</td>
            <td>${member.adminid==1?"是":"否"}</td>
            <td rowspan="3" width="140px">
            	<img src="${member.img}" width="120px" />
            </td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>${member.name}</td>
            <td>性别</td>
            <td>${member.sex}</td>
            <td>出生</td>
            <td>${member.date}</td>
        </tr>
        <tr>
            <td>学院</td>
            <td>${member.college}</td>
           <td>QQ</td>
            <td>${member.qq}</td>
            <td>电话</td>
            <td>${member.phone}</td>
        </tr>
       
        <tr>
            <td>地址</td>
            <td colspan="6">${member.address}</td>
        </tr>
    </table>
</div>
</body>
</html>

