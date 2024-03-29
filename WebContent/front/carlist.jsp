<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/user_style.css" rel="stylesheet" type="text/css" />
<link href="skins/all.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/footer.js" type="text/javascript"></script>
<script src="js/iCheck.js" type="text/javascript"></script>
<script src="js/custom.js" type="text/javascript"></script>
<title>我的收藏</title>
<script type="text/javascript">

$(function(){
	//点击删除按钮
	$("td button[class='btn btn-primary jiesuan']").click(function(){
		var name = $(this).parents("tr").children().eq(1).html();
		if(confirm("购买成功，请返回！")){
			$(this).parents("tr").remove();
		}
	});

</script>

</head>

</head>
<!--/************************************************************
 *																*
 * 						      代码库							*
 *                        www.dmaku.com							*
 *       		  努力创建完善、持续更新插件以及模板			*
 * 																*
**************************************************************-->
<body>
 <div id="header_top">
  <div id="top">
    <div class="Inside_pages">
      <div class="Collection">
      					<c:if test="${empty sessionScope.user}">
						<a href="${pageContext.request.contextPath}/front/login.jsp"
							class="green">请登录</a>
						<a href="${pageContext.request.contextPath}/front/regist.jsp"
							class="green">免费注册</a>
					</c:if>
					<c:if test="${not empty sessionScope.user}">
						<a href="javascript:;" class="green">您好，${sessionScope.user.pet_Name}</a>
						<a
							href="${pageContext.request.contextPath}/login?method=outfrontlogin"
							class="green">注销</a>
					</c:if>
      
      </div>
	<div class="hd_top_manu clearfix">
	  <ul class="clearfix">
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="${pageContext.request.contextPath}/frontallgoods">首页</a></li> 
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"> <a href="javascript:;">我的小充</a> </li>
	   <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="javascript:;">消息中心</a></li>
       <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a href="javascript:;">商品分类</a></li>
        <li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
							href="${pageContext.request.contextPath}/front/carlist.jsp">我的购物车<b>${goodsCarMap.size()}</b></a></li>	
	  </ul>
	</div>
    </div>
  </div>
  <div id="header"  class="header page_style">
  <div class="logo"><a href="index.html"><img src="images/logo.png" /></a></div>
  <!--结束图层-->
  <div class="Search">
        <div class="search_list">
            <ul>
                <li class="current"><a href="javascript:;">产品</a></li>
                <li><a href="javascript:;">信息</a></li>
            </ul>
        </div>
        <div class="clear search_cur">
           <input name="searchName" id="searchName" class="search_box" onkeydown="keyDownSearch()" type="text">
           <input name="" type="submit" value="搜 索"  class="Search_btn"/>
        </div>
        <div class="clear hotword">热门搜索词：香醋&nbsp;&nbsp;&nbsp;茶叶&nbsp;&nbsp;&nbsp;草莓&nbsp;&nbsp;&nbsp;葡萄&nbsp;&nbsp;&nbsp;菜油</div>
</div>
 <!--购物车样式-->
 <div class="hd_Shopping_list" id="Shopping_list">
   
   <div class="dorpdown-layer">
    <div class="spacer"></div>
	 <!--<div class="prompt"></div><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div>-->
		 
   </div>
 </div>
</div>
<!--菜单栏-->
	<div class="Navigation" id="Navigation">
		 <ul class="Navigation_name">
			<li><a href="Home.html">首页</a></li>
			<li><a href="javascript:;">你身边的超市</a></li>
			<li><a href="javascript:;">预售专区</a><em class="hot_icon"></em></li>
			<li><a href="products_list.html">商城</a></li>
			<li><a href="javascript:;">半小时生活圈</a></li>
			<li><a href="javascript:;">好评商户</a></li>
			<li><a href="javascript:;">热销活动</a></li>
			<li><a href="Brands.html">联系我们</a></li>
		 </ul>			 
		</div>
	<script>$("#Navigation").slide({titCell:".Navigation_name li",trigger:"click"});</script>
    </div>
</head>
<!--用户中心收藏样式-->
<div class="user_style clearfix">
 <div class="user_center clearfix">
     <div class="left_style">
     <div class="menu_style">
     <div class="user_title">用户中心</div>
     <div class="user_Head">
     <div class="user_portrait">
      <a href="javascript:;" title="修改头像" class="btn_link"></a> <img src="images/people.png">
      <div class="background_img"></div>
      </div>
      <div class="user_name">
       <p><span class="name">${user.pet_Name}</span><a href="javascript:;">[修改密码]</a></p>
       <p>访问时间：2019-7-21 10:23</p>
       </div>           
     </div>
     <div class="sideMen">
     <!--菜单列表图层-->
     <dl class="accountSideOption1">
      <dt class="transaction_manage"><em class="icon_1"></em>订单管理</dt>
      <dd>
        <ul>
          <li> <a href="${pageContext.request.contextPath}/front/order.jsp">我的订单</a></li>
          <li> <a href="${pageContext.request.contextPath}/front/address.jsp">收货地址</a></li>
          <li> <a href="javascript:;">缺货登记</a></li>
        </ul>
      </dd>
    </dl>
     <dl class="accountSideOption1">
      <dt class="transaction_manage"><em class="icon_2"></em>会员管理</dt>
        <dd>
      <ul>
        <li> <a href="javascript:;"> 用户信息</a></li>
        <li> <a href="用户中心-我的收藏.html"> 我的收藏</a></li>
        <li> <a href="javascript:;"> 我的留言</a></li>
        <li> <a href="javascript:;">我的标签</a></li>
        <li> <a href="javascript:;"> 我的推荐</a></li>
        <li><a href="javascript:;"> 我的评论</a></li>
      </ul>
    </dd>
    </dl>
     <dl class="accountSideOption1">
      <dt class="transaction_manage"><em class="icon_3"></em>账户管理</dt>
      <dd>
       <ul>
        <li><a href="用户中心-账户管理.html">账户余额</a></li>
        <li><a href="用户中心-消费记录.html">消费记录</a></li>   
       <li><a href="javascript:;">跟踪包裹</a></li>
       <li><a href="javascript:;">资金管理</a></li>
      </ul>
     </dd>
    </dl>
     <dl class="accountSideOption1">
      <dt class="transaction_manage"><em class="icon_4"></em>分销管理</dt>
      <dd>
        <ul>
          <li> <a href="javascript:;">店铺管理</a></li>
          <li> <a href="javascript:;">我的盟友</a></li>
          <li> <a href="javascript:;">我的佣金</a></li>
          <li> <a href="javascript:;">申请提现</a></li>
        </ul>
      </dd>
    </dl>
    </div>
      <script>jQuery(".sideMen").slide({titCell:"dt", targetCell:"dd",trigger:"click",defaultIndex:0,effect:"slideDown",delayTime:300,returnDefault:true});</script>
   </div>
 </div>
 <!--收藏样式-->
  <div class="right_style">
  <div class="title_style"><em></em>我的收藏</div> 
  <div class="Favorites_slideTxtBox">
     <div class="hd"><ul><li>收藏的商品</li><li>收藏的店铺</li></ul></div>
     <div class="bd">
        <ul class="commodity_list clearfix">
         <div class="Number_Favorites">购物车商品共：${goodsCarMap.size()}条</div>
         <div class="clearfix">
         
<div class="row" style="padding-left: 50px;">
<form action="${pageContext.request.contextPath}/cargoods?method=settlement" method="post">
						<table
							class="table table-striped table-bordered table-hover text-center"
							style="width: 93%;">
							<tr style="font-weight: bold; background-color: #BCE8F1;">
								<td>全选</td>
								<td>商品名</td>
								<td>商品图片</td>
								<td>商品价格</td>
								<td>商品数量</td>
								
								<td>小计</td>
							</tr>
							<c:forEach items="${sessionScope.goodsCarMap.values()}" var="car">
								<tr>
									<td><input type="checkbox" checked="checked" name="checkid" value=" ${car.goods.goods_Id }" /></td>
									<td>${car.goods.goods_Name }</td>
									<td><img style="width: 120px; heigh: 120px"
										src="${car.goods.goods_Pic }"></td>
									<td>${car.goods.goods_Price }</td>
									<td>${car.num}</td>
									<td>${car.num*car.goods.goods_Price }</td>
						
								</tr>
							</c:forEach>
						</table>
						<button type="button" class="btn btn-primary"><a href="${pageContext.request.contextPath}/frontallgoods">继续购物 </a></button>
						<button type="submit" class="btn btn-primary jiesuan">结算</button>
					</form>
					
					</div>
       
 
     
     
     
     
       
       
       </div>
       <div class="Paging">
    <div class="Pagination">
    <a href="javascript:;">首页</a>
     <a href="javascript:;" class="pn-prev disabled">&lt;上一页</a>
	 <a href="javascript:;" class="on">1</a>
	 <a href="javascript:;">2</a>
	 <a href="javascript:;">3</a>
	 <a href="javascript:;">4</a>
	 <a href="javascript:;">下一页&gt;</a>
	 <a href="javascript:;">尾页</a>	
     </div>
    </div>
        </ul>
        <ul class="Shops_list">
        <div class="Number_Favorites">共收藏：23家店铺</div>
        <li class="">
          <div class="shop_logo">
          
          </div>
          <div class="shop_content">
          
          </div>
        </li>
        </ul>
     </div>
   </div>
   <script>jQuery(".Favorites_slideTxtBox").slide({trigger:"click"});</script>
  </div>
 </div>
</div>
<!--网站地图-->
<div class="fri-link-bg clearfix">
    <div class="fri-link">
        <div class="logo left margin-r20"><img src="images/fo-logo.jpg" width="152" height="81" /></div>
        <div class="left"><img src="images/qd.jpg" width="90"  height="90" />
            <p>扫描下载APP</p>
        </div>
       <div class="">
    <dl>
	 <dt>新手上路</dt>
	 <dd><a href="javascript:;">售后流程</a></dd>
     <dd><a href="javascript:;">购物流程</a></dd>
     <dd><a href="javascript:;">订购方式</a> </dd>
     <dd><a href="javascript:;">隐私声明 </a></dd>
     <dd><a href="javascript:;">推荐分享说明 </a></dd>
	</dl>
	<dl>
	 <dt>配送与支付</dt>
	 <dd><a href="javascript:;">保险需求测试</a></dd>
     <dd><a href="javascript:;">专题及活动</a></dd>
     <dd><a href="javascript:;">挑选保险产品</a> </dd>
     <dd><a href="javascript:;">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>售后保障</dt>
	 <dd><a href="javascript:;">保险需求测试</a></dd>
     <dd><a href="javascript:;">专题及活动</a></dd>
     <dd><a href="javascript:;">挑选保险产品</a> </dd>
     <dd><a href="javascript:;">常见问题 </a></dd>
	</dl>
	<dl>
	 <dt>支付方式</dt>
	 <dd><a href="javascript:;">保险需求测试</a></dd>
     <dd><a href="javascript:;">专题及活动</a></dd>
     <dd><a href="javascript:;">挑选保险产品</a> </dd>
     <dd><a href="javascript:;">常见问题 </a></dd>
	</dl>	
    <dl>
	 <dt>帮助中心</dt>
	 <dd><a href="javascript:;">保险需求测试</a></dd>
     <dd><a href="javascript:;">专题及活动</a></dd>
     <dd><a href="javascript:;">挑选保险产品</a> </dd>
     <dd><a href="javascript:;">常见问题 </a></dd>
	</dl>
     <dl>
	 <dt>帮助中心</dt>
	 <dd><a href="javascript:;">保险需求测试</a></dd>
     <dd><a href="javascript:;">专题及活动</a></dd>
     <dd><a href="javascript:;">挑选保险产品</a> </dd>
     <dd><a href="javascript:;">常见问题 </a></dd>
	</dl>
	   
   </div>
    </div>
</div>
<!--网站地图END-->
<!--网站页脚-->

</body>
</html>
