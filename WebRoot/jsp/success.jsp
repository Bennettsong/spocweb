<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>上传成功界面</title>
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="../video/video-js.min.css" rel="stylesheet">
<link href="../css/admin1.css" type="text/css" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../video/video.min.js"></script>
<script src="../js/run_main.js"></script>
<script>
$('#myModal').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
</script>
  
  <body>
 <div class="container-fluid">
    <div class="container">    
           <div class="modal-content" style="height:600px;">
               <div class="modal-header">
                 <h4 class="modal-title" id="myModalLabel">上传成功</h4>
               </div>               
               <div class="modal-footer">
                 <a type="button" class="btn btn-primary" href="products.do">点击返回</a>
               </div>
             </div>
  </body>
</html>
