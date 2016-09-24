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
    
    	<div class="row bg">
        	<div class="col-md-2 col-xs-3 text-while">思博课网站管理</div>
            <div class="col-md-7 col-xs-6 text-while">
            	<a style="color: #fff" href="" target=main></a>
             &nbsp;&nbsp; 
             <a style="color: #fff" onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="exit.do" target=_top>退出系统</a> 
            </div>
            <div class="col-md-3 col-xs-3 bg2"></div>
        </div>
        
        <div class="row">
				<div class="col-md-2 col-xs-2">
					<table class=" table admin_table_1">
						<tr>
							<td valign=top align=middle>
								<table cellspacing=0 cellpadding=0 width="100%" border=0>
									<tr>
										<td height=10></td>
									</tr>
								</table>

								<table class="admin_table">

									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(1) href="javascript:void(0);">成员管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
									</tr>
								</table>

								<table id=child1 style="display: none"
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>

										<td><a class=menuchild href="user.do?flag=1">老师管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="user.do?flag=2">学生管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>


								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(2) href="javascript:void(0);">荣誉管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
									</tr>
								</table>
                             <table id=child2 style="display: none"
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="honors.do">荣誉信息管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>
								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(3) href="javascript:void(0);">作品管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
									</tr>
								</table>
                             <table id=child3
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="products.do">作品信息管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>								

								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(4) href="javascript:void(0);">业务管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
									</tr>
								</table>
								<table id=child4 style="display: none"
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="applyAffair.do?flag=0">业务申请管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="applyAffair.do?flag=1">业务处理管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="dealAT.do">业务类型管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>
								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(5) href="javascript:void(0);">报名管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
									</tr>
								</table>
								<table id=child5 style="display: none"
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="applys.do">报名申请管理</a></td>
									</tr>
								
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>
								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent class=menuparent onclick=expand(6)
											href="javascript:void(0);">收费管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
									</tr>
								</table>
								<table id=child6 style="display: none"
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="service.do">服务类别管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="TypeCategory.do">类别分类管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="chargeStandard.do">收费标准管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>
								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(7) href="javascript:void(0);">组别管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
									</tr>
								</table>
								<table id=child7 style="display: none"
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="group.do">组别信息管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

            </div>
            <div class="col-md-10 col-xs-10">
                        <div class="row admin_black admin_spacing">
                            <div class="col-md-3 col-xs-5">作品管理信息表</div>
                            <div class="col-md-6 hidden-xs"></div>
                            <div class="col-md-3 col-xs-7">
                                <span>
                                    <a href="#"  data-toggle="modal" data-target="#myModal2">
                                    <img src="../image/add.gif" width="10" height="10" /> 添加</a>   &nbsp;
                                    <!-- <a  data-toggle="modal" data-target=".bs-example-modal-lg" href="#"> -->
                                    <a href="javascript:deleteMember()">
                                    <img src="../image/del.gif" width="10" height="10" /> 删除</a>    &nbsp;&nbsp;
                                </span>
                            </div>
                        </div>                        
                   		<!-- 添加作品 -->     
                        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" id="addproduct">
                          <div class="modal-dialog" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="fun(this)"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">添加作品</h4>
                              </div>
                            <form action="/SpocWeb/servlet/test" method="post" enctype="multipart/form-data"  onSubmit="return checkA()" name="myForm2" id="myForm2">
                              <div class="modal-body">
                                <table class="table">
                                	<tr>
                                    	<td><label for="x">作品名称</label></td>
                                        <td><input type="text" class="form-control empty" onBlur="checkname(this)" id="name" name="name"></td>
                                        <td><label for="xx">完成时间</label></td>
                                        <td><input type="text" class="form-control empty" onBlur="checktime(this)" id="time" name="time" placeholder="请以××××-××-××格式填写"></td>
                                    </tr>
                                    <tr>
                                    	<td><label for="x">参与学生</label></td>
                                        <td><input type="text" class="form-control empty" onBlur="checkstudent(this)" id="student" name="student"></td>
                                        <td><label for="xx">指导老师</label></td>
                                        <td><input type="text" class="form-control empty" onBlur="checkteacher(this)" id="teacher" name="teacher"></td>
                                    </tr>
                                    <tr>
                                    	<td><label for="x">是否显示在前台</label></td>					                         
					                    <td>
				                         	<label class="radio-inline">
				                               <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1"> 是
				                             </label>
				                             <label class="radio-inline">
				                               <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="0" checked="checked"> 否
				                             </label>
					                    </td>
                                    </tr>
                                    <tr>
                                    	<td><label for="x">作品描述</label></td>
                                        <td colspan="3"><textarea type="text" class="form-control " onBlur="checkdescription(this)" id="description" name="description"></textarea></td>
                                    </tr>
                                    <tr>
									<td><label for="x">上传预览图</label></td>
									<td colspan="3"><img id="imgPre" src="" width="100px" height="120px" style="display: block;" /> <input type="file" name="img_path"
										id="img_path" onchange="preImg(this.id,'imgPre');" class="empty"/>
                                    </td>
									</tr>
									<tr>
									<td><label for="x">上传视频</label></td>
									<td>(仅限使用IE浏览器，且视频大小在15M以内)</td>
									<td colspan="3"><img id="proPre" src="" width="100px" height="120px" style="display: block;" /> <input type="file" name="pro_path" class="empty"
										id="pro_path" onchange="preImg(this.id,'imgPre');" />
                                    </td>
									</tr>
                                </table>
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="fun(this)">关闭</button>
                                <button type="button" class="btn btn-primary" onclick="add()">添加</button>
                              </div>
                           </form>
                            </div>
                          </div>
                        </div>	            
                                            
                        <div id="tableBox">
                            <div class="admin_roll">
                            	<form action="deleteproducts.do" method="post" name="myform" id="myform" onSubmit="return check()">	
                                <table class="table" id="tabBox">
                                    <tr>
                                        <td></td>
                                        <td>作品名称</td>                                      
                                        <td>参与学生</td>
                                        <td>指导老师</td>
                                        <td>基本操作</td>
                                    </tr>
                                    <c:forEach items='${products1}' var="product"> 
                                    	<tr>                                  	                                    	                                    	
		                                    	<td><label><input type="checkbox" name="products" id="products" value="${product.pid}" class="ck"/></label></td>
		                                        <td>${product.name}</td>		                                        
		                                        <td>${product.student}</td>
		                                        <td>${product.teacher}</td>
		                                       <td>
		                                            <a href="productsdetail.do?id=${product.pid}">查看详情</a> 	                                       		
											   </td>
											   <td>
											   		<a class="edit" id=${product.pid } style="margin-left:20px;" data-toggle="modal" data-target=".bs-example-modal-lg" href="#">
												    <img src="../image/edit.gif" width="10" height="10" /> 编辑</a>
											   </td>		                                       	                                                                      
                                    </tr>
                                    </c:forEach>
                                    </table>
                            	</form>
                            <div class="text-right" style="margin-right:60px;">
                                <label><input type="checkbox" name="0" class="ck-all"/>全选</label>
                                <label><input type="checkbox" name="0" class="ck-re"/>反选</label>
                            </div>
                        </div>	
					<!--edit-section-start  -->
					<c:forEach items='${products1}' var="product">
					<div class="modal-content text-center admin_hide"
							id="${product.pid}ta">
							<div class="modal-header">
								<a class="close" data-dismiss="modal" href="products.do"
									id="${product.pid}t"">
									<span aria-hidden="true">&times;</span>
								</a>
								<h4 class="modal-title" id="myModalLabel">编辑作品信息</h4>
							</div>
							<form action="updateproduct.do" method="post"
								enctype="multipart/form-data" name="myForm2" 
								id="myForm${product.pid}">
								<div class="container table-responsive">
									<table style="width:500px;height: 300px">
                                	<tr>
                                    	<td><label for="xx">作品名称</label></td>
                                        <td style="text-align:left;"><input type="text" onChange="checkname(this)"
												name="name" class="form-control"
												value="${product.name}" id="myForm${product.pid}name2">
										</td>
                                        <td><label for="xx">完成时间</label></td>
                                        <td style="text-align:left;"><input type="text" onChange="checktime(this)"
												name="time" class="form-control" 
												value="${product.time}" id="myForm${product.pid}time2"/>
										</td>
                                    </tr>
                                    <tr>
                                    	<td><label for="x">参与学生</label></td>
                                    	<td colspan="3" style="text-align:left;"><input type="text" onChange="checkstudent(this)"
												name="student" class="form-control" 
												value="${product.student}" id="myForm${product.pid}student2"/>
										</td>
                                    </tr>
                                    <tr>
                                        <td><label for="xx">指导老师</label></td>
                                        <td style="text-align:left;"><input type="text" onChange="checkteacher(this)"
												name="teacher" class="form-control" 
												value="${product.teacher}" id="myForm${product.pid}teacher2"/>
										</td>
                                        <td>
                                        <label for="x">是否显示在前台</label>
                                        </td>
                                    	<td style="text-align:left;"><input name="flag" value="1"
												${product.flag=="1"?"checked" : ""} type="radio"> <label
												for="q2_1">是</label> <input name="flag" value="0"
												${product.flag=="0"?"checked" : ""} type="radio"> <label
												for="q2_2">否</label>
										</td>
                                    </tr>
                                    <tr>
                                    	<td><label for="x">作品描述</label></td>
                                        <td colspan="3" style="text-align:left;"><input type="text" onChange="checkdescription(this)"
												name="description" class="form-control"
												value="${product.description}" id="myForm${product.pid}description2">
										</td>
                                    </tr>
                                    <tr>
										 	<td style="width:120px;text-align:center;margin-left:150px;">
												<input type="text" name="pid" value="${product.pid}"
												hidden="hidden" />
											</td>
											<td style="width:120px;text-align:center;margin-left:150px;">
												<input type="text" name="pro_path" value="${product.pro_path}"
												hidden="hidden" />
											</td>
											<td style="width:120px;text-align:center;margin-left:150px;">
												<input type="text" name="img_path" value="${product.img_path}"
												hidden="hidden" />
											</td>
											<td style="width:120px;text-align:center;margin-left:150px;">
												<input type="text" name="lpid" value="${product.lpid}"
												hidden="hidden" />
											</td>
										 </tr>
                                </table>
								</div>
							</form>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary update"
									id="${product.pid}" data-dismiss="modal">确定</button>
							</div>
						</div>	
						</c:forEach>
						
				
					<!--edit-section-end -->
                        <script type="text/javascript">
						function deleteMember() {

							$('#myform').submit();
						}
						$(".edit")
								.bind(
										"click",
										function() {
											var id = this.id + "ta";
											document.getElementById(id).style.display = "block";
										})
						function fun(obj) {
							var div = document.getElementById("myModal2");
							div.style.display = "none";
							$("#myModal2 .empty").val("");
							document.getElementById("imgPre").src="";
							$("#myModal2 textarea").val("");			
							document.getElementById("inlineRadio2").checked="checked"; 							
						}
						function add() {
							$('#myForm2').submit();

						}
						$(".close").bind("click", function() {
							var id = this.id + "a";
							document.getElementById(id).style.display = "none";
						})

						$(".update").bind("click", function() {
							var id = "#myForm" + this.id;
							$(id).submit();
						})
						function check()
						{
						 var checkboxs=document.getElementsByName("products");
						 var m=0;
						  for(var i=0;i<checkboxs.length;i++)
							{
								if(checkboxs[i].checked==false)
								{
									m=m+1;
								}
							}
							if(m==i)
							{
								alert("请选择您要删除的选项！！！");
								return false;
								}
						}
						function checktime(obj) 
						{
							var birth_date = document.getElementById(obj.id).value;
							var dateFormat = /^\d{4}\-\d{2}\-\d{2}$/;
							if (birth_date == "") {
								alert("完成时间不能为空！");
								return false;
							} else {
								if (!dateFormat.exec(birth_date)) {
									alert("完成时间的格式必须是xxxx-xx-xx,且均为数字!");
									return false;
								}
							}
						}
						function checkname(obj) 
						{
							var name = document.getElementById(obj.id).value;
							if (name == "") {
								alert("作品名称不能为空！");
								return false;
							}
						}
						function checkdescription(obj) 
						{
							var description = document.getElementById(obj.id).value;
							if (description == "") {
								alert("作品描述不能为空！");
								return false;
							}
						}
						function checkstudent(obj) 
						{
							var student = document.getElementById(obj.id).value;
							if (student == "") {
								alert("参与学生不能为空！");
								return false;
							}
						}
						function checkteacher(obj) 
						{
							var teacher = document.getElementById(obj.id).value;
							if (teacher == "") {
								alert("参与老师不能为空！");
								return false;
							}
						}
						function checkA() {
							var name = document.getElementById("name").value;//通过id获取相应input输入框的值
							var time = document.getElementById("time").value;
							var student = document.getElementById("student").value;								
							var teacher = document.getElementById("teacher").value;
							var description = document.getElementById("description").value;							
							var dateFormat = /^\d{4}\-\d{2}\-\d{2}$/;
							var img_path = document.getElementById("img_path").value;
                            var returnValue=true;
							if (name == "") 
							{
								alert("作品名称不能为空！");
								return false;
							}
							if (time == "") {
								alert("完成时间不能为空！");
								return false;
							}else {
								if (!dateFormat.exec(time)) {
									alert("完成时间的格式必须是xxxx-xx-xx,且均为数字!");
									return false;
								}
							}
							if (description == "") {
								alert("作品描述不能为空！");
								return false;
							}
							if (img_path == "") {
								alert("请选择作品预览图！");
								return false;
							}
							return returnValue;
							} 
						</script>
                        <script>
                            var tabBox = document.getElementById("tabBox"),
                                //tab = tabBox.getElementsByClassName("tab"),
                                tab = [0,1,2,3],
                                tabShow = tabBox.getElementsByClassName("tab-show");
                        
                            function Index1(val){
                                for(var i =0; i<tab.length;i++){
                                    if(tab[i] == val){
                                        return i
                                    }
                                }
                            }
                        
                        
                            allCkBox(); //js全选反选调用
                            allCkBox("tableBox2"); //可以重复使用哦，传个外层 id 进去就可以了
                        
                            function allCkBox(id){
                                //声明各种变量
                                var tableBox = document.getElementById(id||"tableBox"),
                                    table = tableBox.getElementsByTagName("table")[0],
                                    ck = tableBox.getElementsByClassName("ck"),
                                    tableFoot = tableBox.getElementsByClassName("table-foot")[0],
                                    ckAll = tableBox.getElementsByClassName("ck-all")[0],
                                    ckRe = tableBox.getElementsByClassName("ck-re")[0];
                        
                                //js全选
                                ckAll.onchange = function(){
                                    allCk(this.checked);
                                };
                        
                                //js反选
                                ckRe.onchange = function(){
                                    reCk();
                                };
                        
                                //全选函数
                                function allCk(bool){
                                    for(var i =0; i<ck.length;i++){
                                        ck[i].checked = bool;
                                    }
                                }
                        
                                //反选函数 by:<a href="http://www.51xuediannao.com/">懒人建站</a>
                                function reCk(){
                                    for(var i =0; i<ck.length;i++){
                                        ck[i].checked ? ck[i].checked = false : ck[i].checked = true;
                                    }
                                }
                            }
                        </script>
            </div>
        </div>
    </div>
</div>
</body>
</html>
