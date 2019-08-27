<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<!--导入bootStrap的框架 -->
		<!-- 导入样式表-->
		<link href="css1/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<!--导入JS文件-->
		<script type="text/javascript" src="js1/jquery.min.js" ></script>
		<script type="text/javascript" src="js1/bootstrap.min.js" ></script>	
		<script type="text/javascript" src="echarts/echarts-all.js"></script>
		<style type="text/css">
			tr{ height: 50px; }
		</style>
		<script type="text/javascript">
		
		$(function(){
			$.post("<%=request.getContextPath()%>/order",{"method":"saleMonth"},
					function(obj){
		
			var res=eval("("+obj+")");
			var myeachart=echarts.init(document.getElementById('sale'));
			
			var option = {
				    xAxis: {
				        type: 'category',
				        data:res.titleList
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [{
				        data: res.valueList,
				        type: 'bar'
				    }]
				};

			
			myeachart.setOption(option);
				
			});
		});
		</script>
	</head>
	<body>
		<!--添加一个导航菜单-->
		<nav class="nav navbar-default navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="">博悦商城的后台管理系统</a></li> 
			</ul>
			<div class="navbar-right">
				<ul class="nav navbar-nav"> 
					
					<c:if test="${not empty rootuser}">
					<li>	<a href="javascript:;" class="green">您好，${rootuser.pet_Name}</a></li>
						<li><a
							href="login?method=outbacklogin"
							class="green">注销</a></li>
					</c:if>	
				</ul>	
					
							
			</div>
		</nav>
		
		<div class="container">
			<div class="row" style="height: 70px;"> </div>
			<div class="row">
				<!--左侧导航-->
				<div class="col-md-2" >
			 		<iframe src="menu.jsp" frameborder="0" width="100%" height="650" scrolling="no"></iframe>
				</div>
				<!--导航结束-->
				<!--右侧内容-->
				<div class="col-md-10">
					<div  class="row">
						<!--第一个格子柱状图-->
						<div class="col-md-12">
							<!--使用面板实现统计图效果-->
							<div class="panel panel-danger">
								<div class=" panel-heading">
									<h2 class="panel-title">2019博悦商城月销售额</h2>
								</div>
								<div id="sale" class="panel-body" style="height:530px">
								 
								</div>
							</div>							
						</div>
						<!--第一个格子结束-->
						
					</div>
					
				</div>
				<!--内容结束-->
			</div>
		</div>
	</body>
</html>
