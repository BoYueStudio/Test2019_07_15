<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
<link href="css/base.css" rel="stylesheet" type="text/css">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/jquery-2.1.1.min.js"></script>
<style>
.tab {
	overflow: hidden;
	margin-top: -58px; margin-bottom:-1px;
}
.tab li {
	display: block;
	float: left;
	width: 120px;padding:1px 20px; cursor:pointer; border:1px solid #ccc; 
}
.tab li.on {
	background: #90B831; color:#FFF;padding:10px 20px;
}
.conlist {padding:30px; border:1px solid #ccc; width:300px;}
.conbox {
	display: none;
}
</style>
<script>


$(function(){
	$(".tab li").each(function(i){
		$(this).click(function(){
		$(this).addClass("on").siblings().removeClass("on");
		$(".conlist .conbox").eq(i).show().siblings().hide();
		})
	})
})

function reimg(){
  document.getElementById("img1").src="${pageContext.request.contextPath}/servletimg?id="+Math.random();
  }
</script>
</head>

<body>
<%
if(session.getAttribute("user")==null){
	Cookie[] cookie=request.getCookies();
	String uname="";
	String upwd="";

	if(cookie!=null){
		for(Cookie c:cookie){
			if("uname".equals(c.getName())){
			
				uname=c.getValue();
				request.setAttribute("uname1",uname);
			}
			if("upwd".equals(c.getName())){
				upwd=c.getValue();
				request.setAttribute("upwd1",upwd);
			}
		}
	}
}
%>


<div class="login-top">
    <div class="wrapper">
        <div class="fl font30">LOGO</div>
        <div class="fr">您好，欢迎为生活充电在线！</div>
    </div>
</div>
<div class="l_main">
    <div class="l_bttitle2"> 
        <!-- <h2>登录</h2>-->
        <h2><a href="${pageContext.request.contextPath}/frontallgoods">< 返回首页</a></h2>
    </div>
    <div class="loginbox fl">
        <div class="tab">
            <ul>
                <li class="on">博悦电脑商城</li>
            </ul>
        </div>
        <div class="conlist">
        <form action="${pageContext.request.contextPath}/login?method=frontlogin" method="post">
            <div class="conbox" style="display:block;">
                <p>
                    <input type="text" name="uname" value="${uname1}" class="loginusername" placeholder="请输入账号">
                </p>
                <p>
                    <input type="password" name="upwd" value="${upwd1}"  class="loginuserpassword" placeholder="请输入密码">
               
               
                </p>
                <p>
                    验证码：<img id="img1" alt="loading" onclick="reimg()" style="cursor: pointer;" src="${pageContext.request.contextPath}/servletimg">
                   
                    
                    <input type="text" name="yan" value="" class="loginusername" placeholder="请输入验证码">
               
               
                </p> 
               
               
                <label> <input class="fl" type="checkbox" checked="checked" value="yes" name="member"> <p class="fl ">	记住密码</p></label>
                
                 
     			 <button type="submit" class="loginbtn btn-success">登陆</button>
     			 <p>
                <span class="fl margin-t10"><a href="regist.jsp" style="color:javascript:;ff6000">立即注册</a></span><span class="fr fntz12 margin-t10"></span></p>
                <p>
                </p>
                
            </div>
          </form>
            <div class="conbox">
            	<p>
                    <input type="text" class="loginusername">
                </p>
                <p>
                    <input type="password" class="loginuserpassword">
                </p>
                <p><span class="fl fntz14 margin-t10"><a href="javascript:;" style="color:javascript:;ff6000">立即注册</a></span><span class="fr fntz12 margin-t10"><a href="javascript:;">忘记密码？</a></span></p>
                <p>
                    <input type="button" class="loginbtn" value="登  录">
                </p>
            </div>
        </div>
    </div>
    
    <div class="fr margin-r100 margin-t45"><img src="images/login-pic.jpg" width="507" height="325"></div>
</div>
</body>
</html>
