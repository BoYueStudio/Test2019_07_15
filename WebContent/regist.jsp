<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>

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
<div class="container">


<form class="form-horizontal" action="regist" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账 号：</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="uname" placeholder="请输入账号">
    </div>
    </div>
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">昵称：</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="upet" placeholder="请输入昵称">
    </div>
    
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密  码：</label>
    <div class="col-sm-2">
      <input type="password" class="form-control" name="upwd" placeholder="请输入密码">
    </div>
  </div>
  <div class="form-group">
  
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">注册</button>
    </div>
  </div>

</form>
</div>

</div>
</body>
</html>