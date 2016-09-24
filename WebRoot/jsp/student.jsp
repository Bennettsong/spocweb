<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>管理员界面</title>
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="../css/admin1.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/run_main.js"></script>
<SCRIPT language=javascript>
	function expand(el) {
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none') {
			childObj.style.display = 'block';
		} else {
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
</head>

<body>
	<div class="container-fluid">
		<div class="container">

			<div class="row bg">
				<div class="col-md-2 col-xs-3 text-while">思博课网站管理</div>
				<div class="col-md-7 col-xs-6 text-while">
					<!-- <a style="color: #fff" href="" target=main>修改口令</a>
             &nbsp;&nbsp;  -->
					<a style="color: #fff"
						onclick="if (confirm('确定要退出吗？')) return true; else return false;"
						href="exit.do" target=_top>退出系统</a>
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

								<table id=child1
									class="text-left admin_table">
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>

										<td><a class=menuchild href="user.do?flag=1">老师管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="user.do?flag=2"
											>学生管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>


								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(2) href="javascript:void(0);">荣誉管理                                                                                                                       </a></td>
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
                             <table id=child3 style="display: none"
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
										<td><a class=menuchild href="applyAffair.do?flag=0"
											target=main>业务申请管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="applyAffair.do?flag=1"
											target=main>业务处理管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="dealAT.do" target=main>业务类型管理</a></td>
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

					<div class=" row text-right" style="margin-top:10px;">
						<div class="col-md-12 col-xs-12">
							<form action="search.do" method="post" class="form-inline">
								<div class="form-group">
									<label for="exampleInputName2">用户搜索</label> <input type="text"
										name="membername" class="form-control" id="exampleInputName2"
										placeholder="姓名">
								</div>
								<input type="submit" name="submit" class="btn btn-default" />
							</form>
						</div>
					</div>

					<div class="row admin_black admin_spacing">
						<div class="col-md-2 col-xs-5">管理人员基本信息表</div>
						<div class="col-md-7 hidden-xs"></div>
						<div class="col-md-3 col-xs-7">
							<span> <a class="add" href="#"> <img
									src="../image/add.gif" width="10" height="10" /> 添加
							</a> &nbsp; <a href="javascript:deleteMember()"> <img
									src="../image/del.gif" width="10" height="10" /> 删除
							</a> &nbsp;&nbsp;

							</span>

						</div>
					</div>
					<div id="tableBox">
						<div class="admin_roll">
							<form action="deleteMember.do" method="post" name="myform"  onSubmit="return check()"
								id="myform">
								<table class="table" id="tabBox">
									<tr>
										<td></td>
										<td>姓名</td>
										<td>性别</td>
										<td>院系</td>
										<td>年级</td>
										<td colspan="2">基本操作</td>
									</tr>
									<c:forEach items='${students}' var="student">
										<tr>
											<td><label><input type="checkbox" name="student"
													value="${student.loginid}" id="student" class="ck" /></label></td>

											<td>${student.name}</td>
											<td>${student.sex}</td>
											<td>${student.college}</td>
											<td>${student.grade}</td>
											<td colspan="2"><a
												href="detail.do?id=${student.loginid}&flag=2">查看详情</a> <a
												class="edit" id=${student.loginid
												}
												style="margin-left:20px;" data-toggle="modal"
												data-target=".bs-example-modal-lg" href="#"> <img
												src="../image/edit.gif" width="10" height="10" /> 编辑
											</a></td>
										</tr>
									</c:forEach>
								</table>
							</form>
						</div>
						<div class="text-right" style="margin-right:60px;">
							<label><input type="checkbox" name="0" class="ck-all" />全选</label>
							<label><input type="checkbox" name="0" class="ck-re" />反选</label>
						</div>
					</div>

					<!--add-section-start  -->

					<div class="modal-content text-center admin_hide" id="addMember">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								onclick="fun(this)">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">添加成员</h4>
						</div>
						<form action="add.do" method="post" enctype="multipart/form-data"  onSubmit="return checkA()"
							name="myForm2" id="myForm2">
							<div class="container table-responsive">
								<table>
									<tr style="padding-top:20px;">
										<td style="width:80px;text-align:center;line-height:100px;"><label
											for="exampleInputName2">登录名<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text" onBlur="checkLoginid(this)"
											name="loginid" class="form-control empty" id="loginid"></td>
										<td style="width:80px;text-align:center;margin-left:30px;"><label
											for="exampleInputName2">密码<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text"
									 onBlur="checkPassword(this)"		name="pwd" class="form-control empty" id="password"></td>
										<td style="width:80px;text-align:center;margin-left:30px;"><label
											for="exampleInputName2">管理员</label></td>
										<td style="text-align:left;"><input name="admin"
											value="1" type="radio"> <label for="q2_1">是</label> <input
											id="admin" name="admin" value="2" type="radio"
											checked="checked"> <label for="q2_2">否</label></td>


									</tr>

									<tr style="margin-top:20px;">
										<td style="width:80px;text-align:center;line-height:40px;"><label
											for="exampleInputName2">姓名<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text"
										 onBlur="checkName(this)"	name="name" class="form-control empty" id="name"></td>
										<td style="width:80px;text-align:center;margin-left:30px;"><label
											for="exampleInputName2">性别</label></td>
										<td style="text-align:left;"><input name="sex" value="1"
											type="radio" checked="checked" id="sex"> <label
											for="q2_1">男</label> <input name="sex" value="2" type="radio">
											<label for="q2_2">女</label></td>
										<td style="width:80px;text-align:center;margin-left:30px;"><label
											for="exampleInputName2">出生日期<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text" placeholder="请以××××-××-××格式填写"
									 onBlur="checkBirthdate(this)"		name="birth_date" class="form-control empty" id="birth_date"></td>
									</tr>

									<tr>
										<td style="width:80px;text-align:center;line-height:40px;"><label
											for="exampleInputName2">学院<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><select name="college" id="college"
									 onBlur="checkCollege(this)"		style="width:195px;">
												<option value=-1>请选择</option>
												<c:forEach items='${colleges}' var="college">
													<option values="${college.name }">${college.name }</option>
												</c:forEach>
										</select></td>
										<td style="width:80px;text-align:center;margin-left:30px;"><label
											for="exampleInputName2">年级<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text"
									 onBlur="checkGrade(this)"		name="grade" class="form-control empty" id="grade"></td>
										<td style="width:80px;text-align:center;margin-left:30px;"><label
											for="exampleInputName2">专业<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text"
										 onBlur="checkMajor(this)"	name="major" class="form-control empty" id="major"></td>
									</tr>

									<tr>
										<td style="width:80px;text-align:center;line-height:40px;"><label
											for="exampleInputName2">QQ<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text" name="qq"
									 onBlur="checkQq(this)"		class="form-control empty" id="qq"></td>
										<td style="width:80px;text-align:center;margin-left:30px;"><label
											for="exampleInputName2">电话<span class="symbol">*</span></label></td>
										<td style="text-align:left;"><input type="text"
										 onBlur="checkPhone(this)"	name="phone" class="form-control empty" id="phone"></td>
										<td colspan="2"></td>
									</tr>

									<tr>
										<td style="width:80px;text-align:center;line-height:40px;"><label
											for="exampleInputName2">组别<span class="symbol">*</span></label></td>
										<td colspan="5"  align="left"><c:forEach items='${groups}' var="group">
												<label class="checkbox-inline"> <input
													value="${group.gid}" type="checkbox" name="groupOne"
													id="groupOne" value="option1" /> <label>${group.name}
												</label>
												</label>
											</c:forEach></td>
									</tr>

									<tr>
										<td style="width:80px;text-align:center;line-height:100px;"><label
											for="exampleInputName2">就业</label></td>
										<td colspan="5"><textarea type="text"
												class="form-control" name="job" id="exampleInputName2"
												style="width:650px;"></textarea></td>
									</tr>

									<tr>
										<td style="width:80px;text-align:center;line-height:100px;"><label
											for="exampleInputName2">地址<span class="symbol">*</span></label></td>
										<td colspan="5"><textarea type="text"
										 onBlur="checkAddress(this)"		class="form-control" name="address" id="address"
												style="width:650px;"></textarea></td>
									</tr>

									<tr>
										<td style="width:80px;text-align:center;line-height:100px;"><label
											for="exampleInputName2">介绍</label></td>
										<td colspan="5"><textarea type="text" rows="3"
												class="form-control" name="introduction"
												id="exampleInputName2" style="width:650px;"></textarea></td>
									</tr>
								</table>
							</div>

							<center>
								<table style="color:#000; margin-top:10px;">
									<tr>
										<td>照片<span class="symbol">*</span></td>
										<td><img id="imgPre" src="" width="100px" height="120px"
											style="display: block;" /> <input type="file" name="imgOne" class="empty"
											id="file" onchange="preImg(this.id,'imgPre');" /></td>
									</tr>

								</table>
							</center>
						</form>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="add()">添加</button>
						</div>
					</div>



					<!--add-section-end  -->

					<!--edit-section-start  -->

					<c:forEach items='${students}' var="student">
						<div class="modal-content text-center admin_hide"
							id="${student.loginid}ta">
							<div class="modal-header">
								<a type="button" class="close" data-dismiss="modal" href="user.do?flag=2"
									id="${student.loginid}t"">
									<span aria-hidden="true">&times;</span>
								</a>
								<h4 class="modal-title" id="myModalLabel">编辑成员信息</h4>
							</div>
							<form action="updateStu.do" method="post"  onSubmit="return checkU(this)"
								enctype="multipart/form-data" name="myForm2"
								id="myForm${student.loginid}">
								<div class="container table-responsive">
									<table>
										<tr style="padding-top:20px;">
											<td style="width:80px;text-align:center;line-height:100px;"><label
												for="exampleInputName2">登录名</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkLoginid2(this)"
												value="${student.loginid}" name="loginid"
												class="form-control" id="myForm${student.loginid}loginid2"></td>
											<td style="width:80px;text-align:center;margin-left:30px;"><label
												for="exampleInputName2">密码</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkPassword(this)"
												value="${student.password}" name="pwd" class="form-control"
												id="myForm${student.loginid}password2"></td>
											<td style="width:80px;text-align:center;margin-left:30px;"><label
												for="exampleInputName2">管理员</label></td>
											<td style="text-align:left;"><input name="admin"
												value="1" type="radio" ${student.adminid==1?"checked" : ""} />
												<label for="q2_1">是</label> <input name="admin" value="2"
												type="radio" ${student.adminid==2?"checked" : ""} /> <label
												for="q2_2">否</label></td>
										</tr>

										<tr style="margin-top:20px;">
											<td style="width:80px;text-align:center;line-height:40px;"><label
												for="exampleInputName2">姓名</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkName(this)"
												value="${student.name}" name="name" class="form-control"
												id="myForm${student.loginid}name2"></td>
											<td style="width:80px;text-align:center;margin-left:30px;"><label
												for="exampleInputName2">性别</label></td>
											<td style="text-align:left;"><input name="sex" value="1"
												${student.sex=="男"?"checked" : ""} type="radio"> <label
												for="q2_1">男</label> <input name="sex" value="2"
												${student.sex=="女"?"checked" : ""} type="radio"> <label
												for="q2_2">女</label></td>
											<td style="width:80px;text-align:center;margin-left:30px;"><label
												for="exampleInputName2">出生日期</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkBirthdate(this)"
												value="${student.date}" name="birth_date"
												class="form-control" id="myForm${student.loginid}birth_date2"></td>

										</tr>

										<tr>
											<td style="width:80px;text-align:center;line-height:40px;"><label
												for="exampleInputName2">学院</label></td>
											<td style="text-align:left;"><select name="college" id="myForm${student.loginid}college2" onChange="checkCollege(this)"
												style="width:195px;">
													<option>请选择</option>
													<c:forEach items='${colleges}' var="college">
														<option values="${college.name }"
															${student.college==college.name?"selected":""}>${college.name }</option>
													</c:forEach>
											</select></td>
											<td style="width:80px;text-align:center;margin-left:30px;"><label
												for="exampleInputName2">年级</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkGrade(this)"
												value="${student.grade }" name="grade" class="form-control"
												id="myForm${student.loginid}grade2"></td>
											<td style="width:80px;text-align:center;margin-left:30px;"><label
												for="exampleInputName2">专业</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkMajor(this)"
												value="${student.major}" name="major" class="form-control"
												id="myForm${student.loginid}major2"></td>
										</tr>

										<tr>
											<td style="width:80px;text-align:center;line-height:40px;"><label
												for="exampleInputName2">QQ</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkQq(this)"
												name="qq" value="${student.qq }" class="form-control"
												id="myForm${student.loginid}qq2"></td>
											<td style="width:80px;text-align:center;margin-left:30px;"><label
												for="exampleInputName2">电话</label></td>
											<td style="text-align:left;"><input type="text" onChange="checkPhone(this)"
												value="${student.phone }" name="phone" class="form-control"
												id="myForm${student.loginid}phone2"></td>
											<td colspan="2"></td>
										</tr>

										<tr>
											<td style="width:80px;text-align:center;line-height:40px;"><label
												for="exampleInputName2">组别</label></td>
											<td colspan="5" align="left">
											 <c:forEach items='${groups}'	var="group">
											   <label class="checkbox-inline"> 
											     <input	value="${group.gid}" type="checkbox" name="myForm${student.loginid}groupOne2" 
											        <c:forEach items='${membergroups}'	var="mg">
													  <c:if test="${mg.loginid==student.loginid&&group.gid==mg.gid}">
													    checked
													  </c:if>
													  </c:forEach>
															id="myForm${student.loginid}groupOne2" value="option1" />
													 <label>${group.name}	</label>
											  </label>
											 </c:forEach>										
											
											</td>
										</tr>

										<tr>
											<td style="width:80px;text-align:center;line-height:100px;"><label
												for="exampleInputName2">就业</label></td>
											<td colspan="5"><textarea type="text"
													class="form-control" name="job" id="exampleInputName2"
													style="width:650px;"> ${student.job }</textarea></td>
										</tr>

										<tr>
											<td style="width:80px;text-align:center;line-height:100px;"><label
												for="exampleInputName2">地址</label></td>
											<td colspan="5"><textarea type="text"
													class="form-control" name="address" id="myForm${student.loginid}address2" onChange="checkAddress(this)"
													style="width:650px;"> ${student.address }</textarea></td>
										</tr>

										<tr>
											<td style="width:80px;text-align:center;line-height:100px;"><label
												for="exampleInputName2">介绍</label></td>
											<td colspan="5"><textarea type="text" rows="3"
													class="form-control" name="introduction"
													id="exampleInputName2" style="width:650px;">${student.introduction }</textarea></td>
										</tr>
									</table>
								</div>

								<center>
									<table style="color:#000; margin-top:10px;">
										<tr>
											<td>照片</td>
											<td><img src="${student.img}" id="${student.loginid}file2imgPre2" width="100px"
												height="120px" style="display: block;" /> <input
												type="file" name="imgOne" id="${student.loginid}file2"
												onchange="preImg(this.id,this.id+'imgPre2');" /></td>
												<td><input type="text" name="hide" id="myForm${student.loginid}loginid2hide" value="${student.loginid}" hidden="hidden"></td>
										</tr>

									</table>
								</center>
							</form>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary update"
									id="${student.loginid}" data-dismiss="modal">确定</button>
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

						$(".add")
								.bind(
										"click",
										function() {
											document
													.getElementById("addMember").style.display = "block";
										})

						function fun(obj) {
							var div = document.getElementById("addMember");
							div.style.display = "none";
							$("#addMember .empty").val("");
							$("#addMember select").val("-1");
							$("#addMember textarea").val("");	
							document.getElementById("imgPre").src="";
							document.getElementById("admin").checked="checked";
							document.getElementById("sex").checked="checked";
							var allObj = document.getElementsByName("groupOne");//通过NAME得到CHECKBOX集合  
						    for(var i=0; i<allObj.length; i++){  
						        if(allObj[i].checked){  
						            allObj[i].checked = false;  
						        }  
						    }  
							
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
						function checkName(obj) {
						var name = document.getElementById(obj.id).value;
						if (name == "") {
							alert("姓名不能为空！");
							return false;
						}
					}
					function checkCollege(obj) {
						var college = document.getElementById(obj.id).value;
						if (college == -1) {
							alert("请选择学院！");
							return false;
						}
					}
					function checkLoginid(obj) {

						var loginid = document.getElementById(obj.id).value;
						
						if (loginid == "") {
							alert("登录名不能为空！");
							return false;
						}
						$.ajax({

							type : 'POST',
							data : {
								"loginid" : loginid
							},
							dataType : 'json',
							url : 'checkLoginid.do',
							async : false,
							cache : false,
							error : function(request) {
								alert("error");
							},
							success : function(data) {
								if (data[0].flag) {									
									alert("该登录名已存在！");
								}

							}
						});
					}
					function checkLoginid2(obj) {

						var loginid = document.getElementById(obj.id).value;
						var hide = document.getElementById(obj.id+"hide").value;						
						var dateFormatL = /^[0-9]{12}$/;
						if (loginid == "") {
							alert("登录名不能为空！");
							return false;
						} 
						$.ajax({

							type : 'POST',
							data : {
								"loginid" : loginid
							},
							dataType : 'json',
							url : 'checkLoginid.do',
							async : false,
							cache : false,
							error : function(request) {
								alert("error");
							},
							success : function(data) {
								if (data[0].flag) {
									if(loginid!=hide)
										{
									alert("该登录名已存在！");
										}
								}

							}
						});
					}

					function checkPassword(obj) {
						var password = document.getElementById(obj.id).value;
						var dateFormatP = /^[a-zA-Z]{1}[a-zA-Z0-9_]{5,19}$/;
						if (password == "") {
							alert("密码不能为空！");
							return false;
						} else {
							if (!dateFormatP.exec(password)) {
								alert("密码可由字母、数字、下划线组成，以字母开头，位数不少于6位不多于20位!");
								return false;
							}
						}
					}

					function checkBirthdate(obj) {
						var birth_date = document.getElementById(obj.id).value;
						var dateFormat = /^\d{4}\-\d{2}\-\d{2}$/;
						if (birth_date == "") {
							alert("出生日期不能为空！");
							return false;
						} else {
							if (!dateFormat.exec(birth_date)) {
								alert("出生日期的格式必须是xxxx-xx-xx,且均为数字!");
								return false;
							}
						}
					}

					function checkQq(obj) {
						var qq = document.getElementById(obj.id).value;
						var dateFormatQ = /^[1-9]{1}[0-9]{4,10}$/;
						if (qq == "") {
							alert("qq号码不能为空！");
							return false;
						} else {
							if (!dateFormatQ.exec(qq)) {
								alert("qq号码格式错误!");
								return false;
							}
						}
					}

					function checkPhone(obj) {
						var phone = document.getElementById(obj.id).value;
						var dateFormatPh = /^1[0-9]{10}$/;
						if (phone == "") {
							alert("电话号码不能为空！");
							return false;
						} else {
							if (!dateFormatPh.exec(phone)) {
								alert("手机号码为以1开头的11位数字组成!");
								return false;
							}
						}
					}

					function checkAddress(obj) {
						var address = document.getElementById(obj.id).value;
						if (address == "") {
							alert("地址不能为空！");
							return false;
						}
					}
                    function checkGrade(obj)
                    {
                    	var grade = document.getElementById(obj.id).value;
                    	if (grade == "") {
							alert("年级不能为空！");
							return false;
						}
                    }
                    
                    function checkMajor(obj)
                    {
                    	var major = document.getElementById(obj.id).value;
                    	if (major == "") {
							alert("专业不能为空！");
							return false;
						}
                    }                    
                    
                    
					function checkFile(obj) {
						var file = document.getElementById(obj.id).value;
						if (file == "") {
							alert("请选择您的照片！");
							return false;
						}
					}	
						function check()
					{
						 var checkboxs=document.getElementsByName("student");
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
						
						function checkA() {

							var name = document.getElementById("name").value;//通过id获取相应input输入框的值
							var college = document.getElementById("college").value;
							var loginid = document.getElementById("loginid").value;
								
							var password = document.getElementById("password").value;
							var birth_date = document.getElementById("birth_date").value;
							var grade = document.getElementById("grade").value;
							var major = document.getElementById("major").value;
							var dateFormat = /^\d{4}\-\d{2}\-\d{2}$/;
							var dateFormatL = /^[0-9]{12}$/;
							var dateFormatP = /^[a-zA-Z]{1}[a-zA-Z0-9_]{5,19}$/;
							var dateFormatQ = /^[1-9]{1}[0-9]{4,10}$/;
							var dateFormatPh=/^1[0-9]{10}$/;
							var qq = document.getElementById("qq").value;
							var phone = document.getElementById("phone").value;
							var address = document.getElementById("address").value;
							 var checkboxs=document.getElementsByName("groupOne");
							 var m=0;
							var file = document.getElementById("file").value;
                            var returnValue=true;
							if (loginid == "") {
								alert("登录名不能为空！");
								return false;
							} 
							$.ajax({

								type : 'POST',
								data : {
									"loginid" : loginid
								},
								dataType : 'json',
								url : 'checkLoginid.do',
								async : false,
								cache : false,
								error : function(request) {
									alert("error");
								},
								success : function(data) {
									if (data[0].flag) {
										
										alert("该登录名已存在！");
										returnValue=false;	
									}

								}
							});
							if (password == "") {
								alert("密码不能为空！");
								return false;
							} else {
								if (!dateFormatP.exec(password)) {
									alert("密码可由字母、数字、下划线组成，以字母开头，位数不少于6位不多于20位!");
									return false;
								}
							}
							if (name == "") {
								alert("姓名不能为空！");								
								return false;
							}
							if (birth_date == "") {
								alert("出生日期不能为空！");
								return false;
							} else {
								if (!dateFormat.exec(birth_date)) {
									alert("出生日期的格式必须是xxxx-xx-xx,且均为数字!");
									return false;
								}
							}
							if (college == -1) {
								alert("请选择学院！");
								return false;
							}
							if (grade == "") {
								alert("年级不能为空！");
								return false;
							}
							if (major == "") {
								alert("专业不能为空！");
								return false;
							}
							if (qq == "") {
								alert("qq号码不能为空！");
								return false;
							} else {
								if (!dateFormatQ.exec(qq)) {
									alert("qq号码格式错误!");
									return false;
								}
							}
							if (phone == "") {
								alert("电话号码不能为空！");
								return false;
							}else {
								if (!dateFormatPh.exec(phone)) {
									alert("手机号码为以1开头的11位数字组成!");
									return false;
								}
							}
							for(var i=0;i<checkboxs.length;i++)
							{
								if(checkboxs[i].checked==false)
								{
									m=m+1;
								}
							}
							if(m==i)
							{
								alert("请选择组别！！！");
								return false;
								}
							if (address == "") {
								alert("地址不能为空！");
								return false;
							}
							if (file == "") {
								alert("请选择您的照片！");
								return false;
							}

							return returnValue;
						}
						function checkU(obj) {

							var name = document.getElementById(obj.id+"name2").value;//通过id获取相应input输入框的值
							var college = document.getElementById(obj.id+"college2").value;
							var loginid = document.getElementById(obj.id+"loginid2").value;
							var hide = document.getElementById(obj.id+"loginid2hide").value;	
							var password = document.getElementById(obj.id+"password2").value;
							var birth_date = document.getElementById(obj.id+"birth_date2").value;
							var grade = document.getElementById(obj.id+"grade2").value;
							var major = document.getElementById(obj.id+"major2").value;
							var dateFormat = /^\d{4}\-\d{2}\-\d{2}$/;
							var dateFormatL = /^[0-9]{12}$/;
							var dateFormatP = /^[a-zA-Z]{1}[a-zA-Z0-9_]{5,19}$/;
							var dateFormatQ = /^[1-9]{1}[0-9]{4,10}$/;
							var dateFormatPh=/^1[0-9]{10}$/;
							var qq = document.getElementById(obj.id+"qq2").value;
							var phone = document.getElementById(obj.id+"phone2").value;
							var address = document.getElementById(obj.id+"address2").value;
							 var checkboxs=document.getElementsByName(obj.id+"groupOne2");
							 var m=0;
							var returnValue=true;

							if (loginid == "") {
								alert("登录名不能为空！");
								return false;
							} else {
								if (!dateFormatL.exec(loginid)) {
									alert("登录名应为12位的数字!");
									return false;
								}
							}
							$.ajax({

								type : 'POST',
								data : {
									"loginid" : loginid
								},
								dataType : 'json',
								url : 'checkLoginid.do',
								async : false,
								cache : false,
								error : function(request) {
									alert("error");
								},
								success : function(data) {
									if (data[0].flag) {
										if(loginid!=hide)
											{
										alert("该登录名已存在！");
										returnValue=false;
											}
									}

								}
							});
							if (password == "") {
								alert("密码不能为空！");
								return false;
							} else {
								if (!dateFormatP.exec(password)) {
									alert("密码可由字母、数字、下划线组成，以字母开头，位数不少于6位不多于20位!");
									return false;
								}
							}
							if (name == "") {
								alert("姓名不能为空！");								
								return false;
							}
							if (birth_date == "") {
								alert("出生日期不能为空！");
								return false;
							} else {
								if (!dateFormat.exec(birth_date)) {
									alert("出生日期的格式必须是xxxx-xx-xx,且均为数字!");
									return false;
								}
							}
							if (college == -1) {
								alert("请选择学院！");
								return false;
							}
							if (grade == "") {
								alert("年级不能为空！");
								return false;
							}
							if (major == "") {
								alert("专业不能为空！");
								return false;
							}
							if (qq == "") {
								alert("qq号码不能为空！");
								return false;
							} else {
								if (!dateFormatQ.exec(qq)) {
									alert("qq号码格式错误!");
									return false;
								}
							}
							if (phone == "") {
								alert("电话号码不能为空！");
								return false;
							}else {
								if (!dateFormatPh.exec(phone)) {
									alert("手机号码为以1开头的11位数字组成!");
									return false;
								}
							}
							for(var i=0;i<checkboxs.length;i++)
							{
								if(checkboxs[i].checked==false)
								{
									m=m+1;
								}
							}
							if(m==i)
							{
								alert("请选择组别！！！");
								return false;
								}
							if (address == "") {
								alert("地址不能为空！");
								return false;
							}
							

							return returnValue;
						}
					</script>
					<script>
						var tabBox = document.getElementById("tabBox"),
						//tab = tabBox.getElementsByClassName("tab"),
						tab = [ 0, 1, 2, 3 ], tabShow = tabBox
								.getElementsByClassName("tab-show");

						function Index1(val) {
							for (var i = 0; i < tab.length; i++) {
								if (tab[i] == val) {
									return i
								}
							}
						}

						allCkBox(); //js全选反选调用
						allCkBox("tableBox2"); //可以重复使用哦，传个外层 id 进去就可以了

						function allCkBox(id) {
							//声明各种变量
							var tableBox = document.getElementById(id
									|| "tableBox"), table = tableBox
									.getElementsByTagName("table")[0], ck = tableBox
									.getElementsByClassName("ck"), tableFoot = tableBox
									.getElementsByClassName("table-foot")[0], ckAll = tableBox
									.getElementsByClassName("ck-all")[0], ckRe = tableBox
									.getElementsByClassName("ck-re")[0];

							//js全选
							ckAll.onchange = function() {
								allCk(this.checked);
							};

							//js反选
							ckRe.onchange = function() {
								reCk();
							};

							//全选函数
							function allCk(bool) {
								for (var i = 0; i < ck.length; i++) {
									ck[i].checked = bool;
								}
							}

							//反选函数 by:<a href="http://www.51xued iannao.com/">懒人建站</a>
							function reCk() {
								for (var i = 0; i < ck.length; i++) {
									ck[i].checked ? ck[i].checked = false
											: ck[i].checked = true;
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
