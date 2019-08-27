<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理页面</title>
<meta name="referrer" content="no-referrer">
<!--导入bootStrap的框架 -->
<!-- 导入样式表-->
<link href="css1/bootstrap.min.css" type="text/css" rel="stylesheet" />
<!--导入JS文件-->
<script type="text/javascript" src="js1/jquery.min.js"></script>
<script type="text/javascript" src="js1/bootstrap.min.js"></script>

<script language="JavaScript">
			$(function(){
				//点击删除按钮
				$("td button[class='btn btn-danger delete']").click(function(){
					var id=$(this).parents("tr").children().eq(0).html();
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
	<%
	session.setAttribute("goodsType", request.getAttribute("list2"));
	%>
	<!--添加一个导航菜单-->
	<nav class="nav navbar-default navbar-inverse navbar-fixed-top"
		role="navigation">
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
				<iframe src="menu.jsp" frameborder="0" width="100%" height="650"
					scrolling="no"></iframe>
			</div>
			<!--用户管理的内容-->
			<div class="col-md-10 bg-info" style="height: 600px; padding: 40px;">
				<div class="row text-danger" style="height: 50px;">
					<h4>后台页面->商品管理</h4>
				</div>
				<div class="row"
					style="background-color: white; width: 100%; height: 500px;">
					<div class="row"
						style="padding-left: 50px; height: 80px; padding-top: 20px;">
						<button class="btn btn-primary btn-lg" data-toggle="modal"
							data-target="#addModal">增加商品</button>
					</div>
					<div class="row" style="padding-left: 50px;">
						<table
							class="table table-striped table-bordered table-hover text-center"
							style="width: 93%;">
							<tr style="font-weight: bold; background-color: #BCE8F1;">
								<td>id</td>
								<td>商品名</td>
								<td>商品数量</td>
								<td>商品价格</td>
								<td>商品图片</td>

								<td>商品类型</td>
								<td>商品描述</td>
								<td>商品状态</td>
								<td>商品上架日期</td>
								<td>操作</td>
							</tr>
							<c:forEach items="${requestScope.list}" var="goods">
								<tr>
									<td>${goods.goods_Id }</td>
									<td>${goods.goods_Name }</td>
									<td>${goods.goods_Num }</td>
									<td>${goods.goods_Price }</td>
									<td><img style="width: 120px; heigh: 120px"
										src="${goods.goods_Pic }"></td>

									<td>${goods.goods_Type }</td>
									<td>${goods.desc }</td>
									<td>${goods.statu }</td>
									<td>${goods.date }</td>
									<td>
									<button type="button" class="btn btn-danger delete">
											<a href="deletegoods?id=${goods.goods_Id }">删除</a>
										</button>
										<button type="button" class="btn btn-success delete">
											<a href="findgoodsbyid?method=findGoodsById&id=${goods.goods_Id }">修改</a>
										</button>
										
										<!-- <button class="btn btn-success" data-toggle="modal" data-target="#updateModal">编辑</button>
										<button class="btn btn-danger">删除</button> -->
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					
				</div>
				
				<div class="row text-center" style="padding-left: 50px;">
						<ul class="pagination">
							<li><a href="">&lt;&lt;</a></li>
							<c:forEach var="i" begin="1" end="${requestScope.pageCount }">
								<li
									<c:if test="${requestScope.onPage==i }"> class="active"</c:if>>
									<a href="allgoods?npage=${i }">${i }<span class="sr-only">(current)</span></a>
								</li>
							</c:forEach>
							<li class="disabled"><a href="">&gt;&gt;</a></li>

						</ul>
					</div>
				
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
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改商品信息</h4>
				</div>
				<div class="modal-body" style="height: 250px;">
					<div class="col-md-6" style="height: 230px;">
<form class="form-horizontal" action="updategoods" method="get">
	<input type="hidden" name="goods_Id" value="${requestScope.goods.goods_Id }">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">商品名</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="goods_Name" value="${requestScope.goods.goods_Name }">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品数量</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="goods_Num" value="${requestScope.goods.goods_Num }">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品价格</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="goods_Price" value="${requestScope.goods.goods_Price }">
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品图片</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="goods_Pic" value="${requestScope.goods.goods_Pic }">
    </div>
  </div>

    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品类型</label>
    <div class="col-sm-1">
      <%-- <input type="text" class="form-control" name="goods_Type" value="${requestScope.goods.goods_Type }">
     --%>
     			<select class="form-control" name="goods_Type">
					<c:forEach items="${sessionScope.goodsType }" var="g">
						<c:choose>
							<c:when test="">
								<option value="${g.type_Id }" selected="selected">${g.type_Name}</option>
							</c:when>
							<c:otherwise>
								<option value="${g.type_Id }">${g.type_Name}${g.type_Id }</option>
							</c:otherwise>
						</c:choose>
						
						
					</c:forEach>

				</select>
    
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品描述</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="desc" value="${requestScope.goods.desc }">
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品状态</label>
    <div class="col-sm-1">
      <input type="text" class="form-control" name="statu" value="${requestScope.goods.statu }">
    
    
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品上架日期</label>
    <div class="col-sm-1">
      <input type="date" class="form-control" name="date" value="${requestScope.goods.date }">
    </div>
  </div>

  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">添加</button>
    </div>
  </div>
</form>

					</div>
					<div class="col-md-6" style="height: 230px;">
						<img src="img/book1.jpg" height="150" width="150" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>



	<!-- 模式窗口的位置写在网页的最下面-->
	<!-- 模态框（Modal）新增会员模态框 -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增商品信息</h4>
				</div>

				<form class="form-horizontal" action="addgoods" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">商品名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goods_Name"
								placeholder="请输入商品名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">商品数量</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goods_Num"
								placeholder="请输入商品数量">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">商品价格</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goods_Price"
								placeholder="请输入商品价格">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">商品图片</label>
						<div class="col-sm-4">
							<input type="file" class="form-control" name="goods_Pic">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">商品类型</label>
						<div class="col-sm-3">
							<!--  <input type="text" class="form-control" name="goods_Type" placeholder="请输入商品类型"> -->
							<select class="form-control" name="goods_Type">
								<c:forEach items="${sessionScope.goodsType }" var="g">
									<option value="${g.type_Id }">${g.type_Name}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">商品描述</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="desc"
								placeholder="请输入商品描述">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">商品状态</label>
						<div class="col-sm-3">
							<!-- <input type="text" class="form-control" name="statu"
					placeholder="请输入商品状态"> -->
							<select name="statu" class="form-control">
								<option value="1">正常</option>
								<option value="0">未知</option>
							</select>
						</div>
					</div>
					<!--     <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">商品上架日期</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="date" placeholder="请输入商品上架日期">
    </div>
  </div> -->







					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>

						<button type="submit" class="btn btn-success">添加</button>

					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
