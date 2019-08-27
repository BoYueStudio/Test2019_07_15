<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<!-- 导入样式表-->
		<link href="css1/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<!--导入JS文件-->
		<script type="text/javascript" src="js1/jquery.min.js" ></script>
		<script type="text/javascript" src="js1/bootstrap.min.js" ></script>		
	</head>
	<body>
		<div class="col-md-2" >
					<!--登录者头像-->
					<div class="text-center">
						<img src="https://img1.2345.com/duoteimg/qqTxImg/2013/04/22/13667099639.jpg" class="img-circle" width="100" height="100" />
						
						<p color="red">${rootuser.pet_Name}</p>
					</div>
					
					<!--导航菜单-->
					<div class="panel-group" id="accordion">
						<!--首页菜单面板-->
						<div class="panel panel-default">
							<!--面板头-->
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseFirst">
										后台首页
									</a>
								</h4>
							</div>	
							<!--面板的内容-->
							<div id="collapseFirst" class="panel-collapse collapse in">
								    <div class="panel-body">
									<ul>
										<li><a href="admin_main.jsp" target="_parent">首页</a></li> 
										</ul>
								    </div>
							</div>								
							
						</div>						
						<!--员工管理菜单面板-->
						<div class="panel panel-default">
							<!--面板头-->
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
										用户管理
									</a>
								</h4>
							</div>
							<!--面板的内容-->
							<div id="collapseOne" class="panel-collapse collapse in">
								    <div class="panel-body">
									<ul>
										<li><a href="pageuser"  target="_parent">查询用户</a></li> 
										</ul>
								    </div>
							</div>		
						</div>
						<!--商品管理菜单面板-->
						<div class="panel panel-default">
							<!--面板头-->
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
											商品管理
									</a>
								</h4>
							</div>
							<!--面板的内容-->
							<div id="collapseTwo" class="panel-collapse collapse in">
								    <div class="panel-body">
									<ul>
										<li><a href="allgoods"  target="_parent">查询商品</a></li> 
										</ul>
								    </div>
							</div>		
						</div>
						
												<!--dindan管理菜单面板-->
						<div class="panel panel-default">
							<!--面板头-->
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
											订单管理
									</a>
								</h4>
							</div>
							<!--面板的内容-->
							<div id="collapseTwo" class="panel-collapse collapse in">
								    <div class="panel-body">
									<ul>
										<li><a href="order?method=pageOrder"  target="_parent">查询订单</a></li> 
										<li><a href="details?method=pageDetails"  target="_parent">订单详细</a></li> 
										
										</ul>
								    </div>
							</div>		
						</div>
						
					</div>		
		</div>
	</body>
</html>
