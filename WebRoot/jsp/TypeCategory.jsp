﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
						href="../main.htm" target=_top>退出系统</a>
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

										<td><a class=menuchild href="user.do?flag=1" target=main>老师管理</a></td>
									</tr>
									<tr height=20>
										<td width=30><img src="../image/menu_icon.gif"></td>
										<td><a class=menuchild href="user.do?flag=2"
											target="main">学生管理</a></td>
									</tr>
									<tr height=4>
										<td colspan=2></td>
									</tr>
								</table>


								<table class="admin_table">
									<tr height=22>
										<td style="padding-left: 30px" background=../image/menu_bt.jpg><a
											class=menuparent onclick=expand(2) href="javascript:void(0);">荣誉管理
										</a></td>
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
											class=menuparent href="../list2.html" target="main">作品管理</a></td>
									</tr>
									<tr height=4>
										<td></td>
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
							</td>
						</tr>
					</table>
				</div>
				<div class="col-md-10 col-xs-10">

					<div class=" row text-right" style="margin-top:10px;">
						<div class="col-md-12 col-xs-12">
							<form action="searchTypeCategory.do" method="post"
								class="form-inline">
								<div class="form-group">
									<label for="exampleInputName2">用户搜索</label> <input type="text"
										name="type" class="form-control" id="exampleInputName2"
										placeholder="类别描述">
								</div>
								<input type="submit" name="submit" value="搜索"
									class="btn btn-default" />
							</form>
						</div>
					</div>

					<div class="row admin_black admin_spacing">
						<div class="col-md-2 col-xs-5">类型分类信息</div>
						<div class="col-md-7 hidden-xs"></div>
						<div class="col-md-3 col-xs-7">
							<span> <a class="add" href="#"> <img
									src="../image/add.gif" width="10" height="10" /> 添加
							</a> &nbsp; <a href="javascript:deleteType()"> <img
									src="../image/del.gif" width="10" height="10" /> 删除
							</a> &nbsp;&nbsp;

							</span>

						</div>
					</div>
					<div id="tableBox">
						<div class="admin_roll">
							<form action="deleteTypeCategory.do" method="post" name="myform"
								onSubmit="return check1()" id="myform">
								<table class="table" id="tabBox">
									<tr>
										<td></td>
										<td>类别编号</td>
										<td>类别描述</td>
										<td>所属服务类别</td>
										<td colspan="2">基本操作</td>
									</tr>
									<c:forEach items='${typecategorys}' var="typecategory">
										<tr>
											<td><label><input type="checkbox" name="typeCh"
													value="${typecategory.tcid}" id="type" class="ck" /></label></td>

											<td>${typecategory.tcid}</td>
											<td>${typecategory.description}</td>
											<c:forEach items='${servicetypes}' var="servicetype">
												<c:if test="${typecategory.stid==servicetype.stid}">
													<td>${servicetype.type}</td>
												</c:if>
											</c:forEach>
											<td colspan="2"><a class="edit" id=${typecategory.tcid }
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
							<h4 class="modal-title" id="myModalLabel">添加类别种类</h4>
						</div>
						<form action="addTypeCategory.do" method="post" name="myForm2"
							onSubmit="return check()" id="myForm2">
							<div class="container table-responsive">
								<table>
									<tr style="padding-top:20px;">
										<td style="width:80px;text-align:center;line-height:100px;">
											<label for="exampleInputName2">类别描述</label>
										</td>
										<td style="text-align:left;"><input type="text"
											name="description" class="form-control empty"
											id="typeDescription"></td>
										<td style="width:120px;text-align:center;margin-left:150px;">
											<label for="exampleInputName2">所属服务类别</label>
										</td>
										<td style="text-align:left;"><select name="type"
											id="serviceType" style="width:195px;">
												<option value="-1">请选择</option>
												<c:forEach items='${servicetypes}' var="servicetype">
													<option value="${servicetype.stid }">${servicetype.type }</option>
												</c:forEach>
										</select></td>
									</tr>
								</table>
							</div>
						</form>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="add()">添加</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onclick="fun(this)">Close</button>
						</div>
					</div>



					<!--add-section-end  -->

					<!--edit-section-start  -->

					<c:forEach items='${typecategorys}' var="typecategory">
						<div class="modal-content text-center admin_hide"
							id="${typecategory.tcid}ta">
							<div class="modal-header">
								<a class="close" data-dismiss="modal" href="TypeCategory.do"
									id="${typecategory.tcid}t"">
									<span aria-hidden="true">&times;</span>
								</a>
								<h4 class="modal-title" id="myModalLabel">编辑类别信息</h4>
							</div>
							<form action="updateTypeCategory.do" method="post"
								onSubmit="return check2(this)" enctype="multipart/form-data"
								name="myForm2" id="myForm${typecategory.tcid}">
								<div class="container table-responsive">
									<table>
										<tr style="padding-top:20px;">
											<td style="width:80px;text-align:center;line-height:100px;">
												<label for="exampleInputName2">类别描述</label>
											</td>
											<td style="text-align:left;"><input type="text"
												value="${typecategory.description}" name="description"
												class="form-control" id="myForm${typecategory.tcid}typeDescription2"></td>
											<td style="width:120px;text-align:center;margin-left:150px;">
												<label for="exampleInputName2">所属服务类别</label>
											</td>
											<td style="text-align:left;"><select name="type"
												id="myForm${typecategory.tcid}serviceType2" style="width:195px;">
													<option value=-1>请选择</option>
													<c:forEach items='${servicetypes}' var="servicetype">
														<option value="${servicetype.stid }"
															${servicetype.stid==typecategory.stid?"selected":"" }>${servicetype.type }</option>
													</c:forEach>
											</select></td>
											<td style="width:120px;text-align:center;margin-left:150px;">
												<input type="text" name="tcid" value="${typecategory.tcid}"
												hidden="hidden" />
											</td>
										</tr>
									</table>
								</div>
							</form>
							<div class="modal-footer">

								<button type="button" class="btn btn-primary update"
									id="${typecategory.tcid}" data-dismiss="modal">确定</button>
							</div>
						</div>
				</div>
				</c:forEach>
				<!--edit-section-end -->
				<script type="text/javascript">
					function deleteType() {

						$('#myform').submit();

					}
					$(".edit").bind("click", function() {
						var id = this.id + "ta";
						document.getElementById(id).style.display = "block";
					})

					$(".add")
							.bind(
									"click",
									function() {
										document.getElementById("addMember").style.display = "block";
									})

					function fun(obj) {
						var div = document.getElementById("addMember");
						div.style.display = "none";
						$("#addMember .empty").val("");
						$("#addMember select").val("-1");
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
					function check() {

						var typeDescription = document
								.getElementById("typeDescription").value;
						var serviceType = document
								.getElementById("serviceType").value;
						if (typeDescription == "") {
							alert("请填写类别描述！");
							return false;
						}
						if (serviceType == -1) {
							alert("请选择服务类别！");
							return false;
						}

						return true;
					}
					function check1() {						

						var checkboxs = document.getElementsByName("typeCh");
						var m = 0;
						for (var i = 0; i < checkboxs.length; i++) {
							if (checkboxs[i].checked == false) {
								m = m + 1;
							}
						}
						if (m == i) {
							alert("请选择您要删除的选项！！！");
							return false;
						}
						return true;
					}
					function check2(obj) {
                        
						var typeDescription = document
								.getElementById(obj.id+"typeDescription2").value;
						var serviceType = document
								.getElementById(obj.id+"serviceType2").value;
						if (typeDescription == "") {
							alert("请填写类别描述！");
							return false;
						}
						if (serviceType == -1) {
							alert("请选择服务类别！");
							return false;
						}

						return true;
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
						var tableBox = document
								.getElementById(id || "tableBox"), table = tableBox
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
