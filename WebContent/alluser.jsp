<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

</head>
<body>
<table class="table table-striped">
		<tr>
			<td>admin_id</td>
			<td>login_Name</td>
			<td>pet_Name</td>
			<td>pass</td>
			<td>role</td>
			
			<td>statu</td>
			<td>reg_Date</td>

			<td>操作</td>
		</tr>
		
		<c:forEach items="${requestScope.list}" var="user">
		<tr>
			<td>${user.admin_Id }</td>
			<td>${user.login_Name }</td>
			<td>${user.pet_Name }</td>
			<td>${user.pass }</td>
			<td>${user.role }</td>
			
			<td>${user.statu }</td>
			<td>${user.reg_Date }</td>
		
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

	<nav aria-label="...">
	<ul class="pagination">
		<li class="disabled"><span> <span aria-hidden="true">&laquo;</span>
		</span></li>
		<c:forEach var="i" begin="1" end="${requestScope.pageCount }">
		<li  <c:if test="${requestScope.onPage==i }"> class="active"</c:if>>
		<a href="pageuser?npage=${i }">${i }<span class="sr-only">(current)</span></a>
		</li>
		</c:forEach>
		<li>共${requestScope.pageCount }页，当前${requestScope.onPage }页</li>
		
	</ul>
	</nav>

</body>
</html>