<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户管理页面</title>
		<!--导入bootStrap的框架 -->
		<!-- 导入样式表-->
		<link href="css1/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<!--导入JS文件-->
		<script type="text/javascript" src="js1/jquery.min.js" ></script>
		<script type="text/javascript" src="js1/bootstrap.min.js" ></script>		
		
		<script language="JavaScript">
			$(function(){
				//点击删除按钮
				$("td button[class='btn btn-danger']").click(function(){
					var name = $(this).parents("tr").children().eq(1).html();
					if(confirm("是否要删除<"+name+">的信息")){
						$(this).parents("tr").remove();
					}
				});
				//点击编辑按钮
				$("td button[class='btn btn-success']").click(function(){
					var no = $(this).parents("tr").children().eq(0).html();
					var name = $(this).parents("tr").children().eq(1).html();
					var sex = $(this).parents("tr").children().eq(2).html();
					var img = $(this).parents("tr").find("img").attr("src");
					//把用户信息填入到表单中
					$("input[id='uno']").val(no);
					$("input[id='uname']").val(name);
					if(sex=='男'){
						$("input[id='usex1']").prop("checked","true");
					}else{
						//attr attribute    prop properties
						$("input[id='usex2']").prop("checked","true");
					}
					
					$("div[class='modal-body'] img").attr("src",img);
					
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
			<!--nva导航-->
			<div class="row" style="height: 70px;"></div>
			<div class="row">
				<!--菜单导航-->
				<div class="col-md-2">
			 	<iframe src="menu.jsp" frameborder="0" width="100%" height="650" scrolling="no"></iframe>
				</div>
				<!--用户管理的内容-->
				<div class="col-md-10 bg-info" style="height:600px; padding:40px;">
					<div class="row text-danger" style="height: 50px;"><h4>后台页面->详情管理</h4></div>
					<div class="row" style=" background-color: white;   width: 100%; height: 500px;">
						<div class="row" style="padding-left: 50px; height: 80px;padding-top: 20px;">
							<button class="btn btn-primary btn-lg"  data-toggle="modal" data-target="#addModal">增加详细</button>
						</div>
						<div class="row" style="padding-left: 50px;">
							<table class="table table-striped table-bordered table-hover text-center" style="width: 93%;">
								<tr style="font-weight: bold; background-color: #BCE8F1;">
								<td>Id</td>
								<td>订单号</td>
								<td>商品id</td>
								<td>总数量</td>
								<td>订单日期</td>
								
								

								<td>操作</td>
							</tr>
							<c:forEach items="${requestScope.detailsList}" var="details">
								<tr>
									<td>${details.od_id}</td>
									<td>${details.o_id }</td>
									<td>${details.g_id }</td>
									<td>${details.total }</td>
									<td>${details.o_date }</td>

									
									

									<td><button type="button" class="btn btn-danger delete">
											<a href="">删除</a>
										</button>
										<button type="button" class="btn btn-success delete">
											<a href="">修改</a>
										</button>
									</td>
									<!-- <td>
										<button class="btn btn-success" data-toggle="modal" data-target="#updateModal">编辑</button>
										<button class="btn btn-danger">删除</button>
									</td> -->
								</tr>
							</c:forEach>

				
							</table>
						</div>
						
						</div>
					</div>
					
					<div class="row text-center" style="padding-left: 50px;">
						<ul class="pagination">
							<li><a href="">&lt;&lt;</a></li>
							<c:forEach var="i" begin="1" end="${requestScope.pageCount }">
								<li
									<c:if test="${requestScope.onPage==i }"> class="active"</c:if>>
								<a href="details?method=pageDetails&npage=${i }">${i }<span class="sr-only">(current)</span></a>
								</li>
							</c:forEach>
							<li class="disabled"><a href="">&gt;&gt;</a></li>

						</ul>
					
				</div>
			</div>
		</div>
		

	
	
	
<!-- 模式窗口的位置写在网页的最下面-->
<!-- 模态框（Modal） -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
     <div class="modal-content">
        <div class="modal-header">            
			<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	修改会员信息
            </h4>
         </div>
         <div class="modal-body" style="height: 250px;">
			<div class="col-md-6" style="height: 230px;">
				<form action="index.html" method="post">
					<div class="form-group">
						<label for="uname">会员编号:</label>
						<input type="text" name="uname" id="uno"  placeholder="输入编号" />
					</div>
					<div class="form-group">
						<label for="upass">会员姓名:</label>
						<input type="text" name="upass" id="uname"  placeholder="姓名" /> 
					</div>
					<div class="form-group">
						<label for="upass">会员性别:</label>
						<input type="radio" name="usex" id="usex1" value="1" />男 
						<input type="radio" name="usex" id="usex2" value="0" />女
					</div>								
				</form>				
			</div>
 			<div class="col-md-6"  style="height: 230px;">
 				<img src="img/book1.jpg" height="150" width="150" />
 			</div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>		


	
<!-- 模式窗口的位置写在网页的最下面-->
<!-- 模态框（Modal）新增会员模态框 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
     <div class="modal-content">
        <div class="modal-header">            
			<button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               	新增会员信息
            </h4>
         </div>
         <div class="modal-body" style="height: 250px;">
			<div class="col-md-6" style="height: 230px;">
				<form action="index.html" method="post">
					<div class="form-group">
						<label for="uname">会员编号:</label>
						<input type="text" name="uname" id="uno"  placeholder="输入编号" />
					</div>
					<div class="form-group">
						<label for="upass">会员姓名:</label>
						<input type="text" name="upass" id="uname"  placeholder="姓名" /> 
					</div>
					<div class="form-group">
						<label for="upass">会员性别:</label>
						<input type="radio" name="usex" id="usex1" value="1" />男 
						<input type="radio" name="usex" id="usex2" value="0" />女
					</div>								
				</form>				
			</div>
 			<div class="col-md-6"  style="height: 230px;">
 				<img src="img/book1.jpg" height="150" width="150" />
 			</div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary">
               提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>		
	</body>
</html>
