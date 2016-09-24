<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>管理员界面</title>
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="../css/admin1.css" type="text/css" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
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
               <script>
                 /* $(function(){
                		 
                	 $.ajax({

							type : 'POST',							
							dataType : 'json',
							url : 'admin.do',
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
                		 })*/
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

							//反选函数 by:<a href="http://www.51xuediannao.com/">懒人建站</a>
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
