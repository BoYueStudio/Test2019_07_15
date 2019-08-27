<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有商品</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<table class="table table-striped">
		<tr>
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
			<td><img style="width:120px;heigh:120px" src="${goods.goods_Pic }"></td>
			
			<td>${goods.goods_Type }</td>
			<td>${goods.desc }</td>
			<td>${goods.statu }</td>
			<td>${goods.date }</td>
			<td><button type="button" class="btn btn-danger delete">
					<a href="deletegoods?id=${goods.goods_Id }">删除</a>
				</button>
				<button type="button" class="btn btn-danger delete">
					<a href="findgoodsbyid?id=${goods.goods_Id }">修改</a>
				</button>
			</td>
		</tr>
		</c:forEach>
				
		<tr>
			<td><button type="button" class="btn btn-success">
					<a href="addgoods.jsp">新增</a>
				</button></td>
		<tr>
	</table>
	<%
	session.setAttribute("goodsType", request.getAttribute("list2"));
	%>

</body>
</html>