<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理</title>
</head>
<%session.setAttribute("nowuser", request.getAttribute("user")); %>
<frameset rows="15%,80%" border="1px">

<frame src="top.jsp">

<frameset cols="13%,75%">
<frame src="left.jsp">
<frame src="allgoods" name="rightiframe">
</frameset>


</frameset>
</html>