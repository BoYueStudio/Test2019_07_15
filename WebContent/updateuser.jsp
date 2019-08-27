<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户密码</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<link rel="styleSheet" type="text/css" href="css/login.css">

</head>
<body>


<div class="logindiv">

<c:choose>
	<c:when test="${empty sessionScope.nowuser}">
	<h1>你未登陆，请<a href="login.jsp" target="_parent">登陆</a></h1>
	</c:when>
	<c:otherwise>
	<div class="container">

<form class="form-horizontal" action="updateuser" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账 号：</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" readonly="true" name="uname" value="${sessionScope.nowuser.login_Name }">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">旧密码：</label>
    <div class="col-sm-2">
      <input type="password" class="form-control" name="oldpwd" placeholder="请输入旧密码">
    </div>
  </div>
 
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">新密码：</label>
    <div class="col-sm-2">
      <input type="password" class="form-control" name="newpwd" placeholder="请输入新密码">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">修改</button>
    </div>
  </div>

</form>
</div>
	
	</c:otherwise>
</c:choose>

</div>

</body>
</html>