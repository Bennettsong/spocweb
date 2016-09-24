<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>管理员作品管理界面</title>
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
</head>
<body>
<div class="container-fluid">
    <div class="container">    
        <!--modle3-->

             <div class="modal-content" style="height:600px;">
               <div class="modal-header">
                 <h4 class="modal-title" id="myModalLabel">作品详情</h4>
               </div>
               <div class="modal-body">
                 <table class="table">
                 	<tr>
                     	<td><label for="x">作品名称</label></td>
                         <td><input type="text" class="form-control" value="${pr.name}"></td>
                         <td><label for="xx">完成时间</label></td>
                         <td><input type="text" class="form-control" value="${pr.time}"></td>
                     </tr>
                     <tr>
                     	<td><label for="x">参与学生</label></td>
                         <td colspan="3"><input type="text" class="form-control" value="${mpr.student}"></td>
                     </tr>
                     <tr>
                         <td><label for="xx">指导老师</label></td>
                         <td><input type="text" class="form-control" value="${mpr.teacher}"></td>
                         <td>
                         <label for="x">是否显示</label>
                         </td>
                     	<td>
                         	<label class="radio-inline">
                               <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" ${pr.flag=="1"?"checked" : ""}> 是
                             </label>
                             <label class="radio-inline">
                               <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" ${pr.flag=="0"?"checked" : ""}> 否
                             </label>
                         </td>
                     </tr>
                     <tr>
                     	<td><label for="x">作品描述</label></td>
                         <td colspan="3"><input type="text" class="form-control" value="${pr.description}"></td>
                     </tr>
                    
                 </table>
               </div>
               <div class="modal-footer">
                 <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" data="${pr.pro_path}" tle="${pr.name}">作品播放</button>
                 <a type="button" class="btn btn-primary" href="products.do">点击返回</a>
               </div>
             </div>
     
        <!--modle3-->  
             <div id="tableBox">
                 <div class="admin_roll">
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                               <div class="modal-dialog" role="document" style="width:450px;">
                                 <div class="modal-content">
                                   <div class="modal-header">
                                     <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                     <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                   </div>
                                   <div class="modal-body">
                                     <video id="example_video_3" class="video-js vjs-default-skin vjs-big-play-centered" controls ="none" width="400" height="210"
                                   poster="http://video-js.zencoder.com/oceans-clip.png"
                                   data-setup="{}">
                                    <source id="1" src="" type='video/mp4' />
                                   </div>
                                   <div class="modal-footer">
                                     <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                   </div>
                                 </div>
                               </div>
                             </div> 
                             <script>
									$(document).ready(function () {
									                              	
										
											var myPlayer = videojs("example_video_3");
											$('#myModal').on('show.bs.modal', function (e) {
												var str=(e.relatedTarget).getAttribute("data");
												var title=(e.relatedTarget).getAttribute("tle");
												$('#myModal h4').html(title);
												myPlayer.ready(function(){
													this.on("ended", function(){
														 //this.dispose(); 
														 this.pause();
													});
													this.src({type: "video/mp4", src: str});
													this.play();
												});
												myPlayer.preload();
											})
											
											$('#myModal').on('hidden.bs.modal', function (e) {
													myPlayer.pause();
											});
											
											});
                              </script>

                             </script>
                      <!-- Modal -->                             
                        </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
