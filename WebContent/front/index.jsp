<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/common_js.js" type="text/javascript"></script>
<script src="js/footer.js" type="text/javascript"></script>

<title>网站首页</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->


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
						<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
							href="javascript:;">首页</a></li>
						<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
							href="javascript:;">我的小充</a></li>
						<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
							href="javascript:;">消息中心</a></li>
						<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
							href="javascript:;">商品分类</a></li>
						<li class="hd_menu_tit" data-addclass="hd_menu_hover"><a
							href="${pageContext.request.contextPath}/front/carlist.jsp">我的购物车<b>${goodsCarMap.size()}</b></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="header" class="header page_style">
			<div class="logo">
				<a href="index.html"><img width="193px" height="97px" src="https://i01piccdn.sogoucdn.com/1780aabbf2ab0f72" /></a>
			</div>
			<!--结束图层-->
			<div class="Search">
				<div class="search_list">
					<ul>
						<li class="current"><a href="javascript:;">产品</a></li>
						<li><a href="javascript:;">信息</a></li>
					</ul>
				</div>
				<div class="clear search_cur">
					<input name="searchName" id="searchName" class="search_box"
						onkeydown="keyDownSearch()" type="text"> <input name=""
						type="submit" value="搜 索" class="Search_btn" />
				</div>
				<div class="clear hotword">热门搜索词：联想&nbsp;&nbsp;&nbsp;苹果&nbsp;&nbsp;&nbsp;华硕&nbsp;&nbsp;&nbsp;小米&nbsp;&nbsp;&nbsp;同方</div>
			</div>
			<!--购物车样式-->
			<div class="hd_Shopping_list" id="Shopping_list">
				<div class="s_cart">
					<a
							href="${pageContext.request.contextPath}/front/carlist.jsp">我的购物车<b>${goodsCarMap.size()}</b></a> <i class="ci-right">&gt;</i><i
						class="ci-count" id="shopping-amount">0</i>
				</div>
				<div class="dorpdown-layer">
					<div class="spacer"></div>
					<!--<div class="prompt"></div><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div>-->
				
					
				</div>
			</div>
		</div>



		</head>
		<!--广告幻灯片样式-->
		<div id="slideBox" class="slideBox">
			<div class="hd">
				<ul class="smallUl"></ul>
			</div>
			<div class="bd">
				<ul>
					<li><a href="javascript:;" target="_blank"><div
								style="background: url(https://p3.lefile.cn/product/adminweb/2019/07/15/9a80d512-0af4-43c5-8b51-4195ac4a6dcf.jpg) no-repeat; background-position: center; width: 100%; height: 450px;"></div></a></li>
					<li><a href="javascript:;" target="_blank"><div
								style="background: url(https://p1.lefile.cn/product/adminweb/2019/07/15/e8818f4d-451f-4d2c-aa4b-daa039f7012d.jpg) no-repeat; background-position: center; width: 100%; height: 450px;"></div></a></li>
					<li><a href="javascript:;" target="_blank"><div
								style="background: url(https://p3.lefile.cn/product/adminweb/2019/07/09/b3159d25-e35e-4952-885c-1b07fdc81cb9.jpg) no-repeat rgb(226, 155, 197); background-position: center; width: 100%; height: 475px;"></div></a></li>
					<li><a href="javascript:;" target="_blank"><div
								style="background: url(https://p4.lefile.cn/product/adminweb/2019/07/15/b1f73db7-602f-4e80-b2e1-db0f362c69f2.jpg) no-repeat #f7ddea; background-position: center; width: 100%; height: 450px;"></div></a></li>
					<li><a href="javascript:;" target="_blank"><div
								style="background: url(https://p3.lefile.cn/product/adminweb/2019/07/15/03a2e147-b0b5-4720-b398-065acd7537c6.jpg) no-repeat #F60; background-position: center; width: 100%; height: 450px;"></div></a></li>
				</ul>
			</div>
			下面是前/后按钮 <a class="prev" href="javascript:void(0)"></a> <a
				class="next" href="javascript:void(0)"></a>

		</div>
		<script type="text/javascript">
			jQuery(".slideBox").slide({
				titCell : ".hd ul",
				mainCell : ".bd ul",
				autoPlay : true,
				autoPage : true
			});
		</script>


	</div>

	<!--内容样式-->
	<div id="mian">
		<div class="clearfix marginbottom">
			<!--产品分类样式-->
			<div class="Menu_style" id="allSortOuterbox">
				<div class="title_name">
					<em></em>所有商品分类
				</div>
				<div class="content hd_allsort_out_box_new">
					<ul class="Menu_list">
						<c:forEach items="${requestScope.list2 }" var="t" varStatus="s">
							<li class="name">
								<div class="Menu_name">
									<a href="product_list.html">${t.type_Name}类</a> <span>&lt;</span>
								</div>
								<div class="link_name">
									<p>
										<c:forEach items="${requestScope.list }" var="g">
											<c:if test="${t.type_Id == g.goods_Type}">
												<a href="findgoodsbyid?method=detailId&id=${g.goods_Id}">${g.goods_Name}</a> | 
          </c:if>
										</c:forEach>
									</p>
								</div>
								<div class="menv_Detail">
									<div class="cat_pannel clearfix">
										<div class="hd_sort_list">

											<c:forEach items="${requestScope.list }" var="g">
												<c:if test="${t.type_Id == g.goods_Type}">
													<dl class="clearfix" data-tpc="1">
														<dt>
															<a href="javascript:;">${t.type_Name}<i>></i></a>
														</dt>
														<dd>

															<a href="findgoodsbyid?method=detailId&id=${g.goods_Id}">${g.goods_Name}</a>
														</dd>
													</dl>
												</c:if>
											</c:forEach>
										</div>
										<div class="Brands"></div>
									</div>
									<!--品牌-->
								</div>


							</li>
						</c:forEach>


					</ul>
				</div>
			</div>
			<script>
				$("#allSortOuterbox").slide({
					titCell : ".Menu_list li",
					mainCell : ".menv_Detail",
				});
			</script>
			<!--产品栏切换-->
			<div class="product_list left">


				<div class="slideGroup">
					<div class="parHd">
						<ul>
							<c:forEach items="${requestScope.list2 }" var="t" varStatus="s">
								<li>${t.type_Name }</li>
							</c:forEach>
						</ul>
					</div>


					<div class="parBd">
						<div class="slideBoxs">
							<a class="sPrev" href="javascript:void(0)"></a>


							<ul>
								<c:forEach items="${requestScope.list }" var="g">
									<li>
										<div class="pic">
											<a href="javascript:;" target="_blank"><img
												src="${g.goods_Pic}" /></a>
										</div>
										<div class="title">
											<a href="javascript:;" target="_blank" class="name">${g.goods_Name}</a>
											<h3>
												<b>￥</b>${g.goods_Price}</h3>
										</div>
									</li>
								</c:forEach>
							</ul>
							<a class="sNext" href="javascript:void(0)"></a>
						</div>
						<!-- slideBox End -->



					</div>
					<!-- parBd End -->
				</div>


				<script type="text/javascript">
					/* 内层图片无缝滚动 */
					jQuery(".slideGroup .slideBoxs").slide({
						mainCell : "ul",
						vis : 4,
						prevCell : ".sPrev",
						nextCell : ".sNext",
						effect : "leftMarquee",
						interTime : 50,
						autoPlay : true,
						trigger : "click"
					});
					/* 外层tab切换 */
					jQuery(".slideGroup").slide({
						titCell : ".parHd li",
						mainCell : ".parBd"
					});
				</script>
				<!--广告样式-->
				<div class="Ads_style">
					 <a href="javascript:;"><img src="https://i02piccdn.sogoucdn.com/f5f3e161bbbbd589" width="318" /></a> 
					<a href="javascript:;"><img src="https://i02piccdn.sogoucdn.com/72401cd6951f1333" width="318" /></a><a
						href="javascript:;"><img src="https://i02piccdn.sogoucdn.com/c3e3ad902d3bc888" width="318" /></a>
				</div>
			</div>
		</div>
		<!--板块栏目样式-->
		<div class="clearfix Plate_style">

			<c:forEach items="${requestScope.list2 }" var="t" varStatus="s">
				<div class="Plate_column Plate_column_left">
					<!-- <c:choose>
						<c:when test="">
							class="Plate_column Plate_column_right"
						</c:when>
						<c:otherwise>
							class="Plate_column Plate_column_right"
						</c:otherwise>
					</c:choose> -->

					<div class="Plate_name">
						<h2>办公电脑</h2>
						<div class="Sort_link">

							<a href="javascript:;" class="name">${t.type_Name }</a>

						</div>
						<a href="javascript:;" class="Plate_link"> <img
							src="images/bk_img_14.png" /></a>
					</div>



					<div class="Plate_product">
						<ul id="lists">
							<c:forEach items="${requestScope.list }" var="g">
								<c:if test="${g.goods_Type == t.type_Id}">
									<li class="product_display"><a href=" ${pageContext.request.contextPath}/cargoods?method=addcar&id=${g.goods_Id}" class="Collect"><em></em>收藏</a>
										<a href="javascript:;" class="img_link"><img
											src="${g.goods_Pic }" width="140" height="140" /></a> <a
										href="javascript:;" class="name">${g.goods_Name }</a>
										<h3>
											<b>￥</b>${g.goods_Price }</h3>
										<div class="Detailed">
											<div class="content">
												<p class="center">
													<a href="findgoodsbyid?method=detailId&id=${g.goods_Id}"
														class="Buy_btn">立即购买</a>
												</p>
											</div>
										</div></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>












	</div>


	<!--网站地图-->
	<div class="fri-link-bg clearfix">
		<div class="fri-link">
			<div class="logo left margin-r20">
				<img src="images/fo-logo.jpg" width="152" height="81" />
			</div>
			<div class="left">
				<img src="images/qd.jpg" width="90" height="90" />
				<p>扫描下载APP</p>
			</div>
			<div class="">
				<dl>
					<dt>新手上路</dt>
					<dd>
						<a href="javascript:;">售后流程</a>
					</dd>
					<dd>
						<a href="javascript:;">购物流程</a>
					</dd>
					<dd>
						<a href="javascript:;">订购方式</a>
					</dd>
					<dd>
						<a href="javascript:;">隐私声明 </a>
					</dd>
					<dd>
						<a href="javascript:;">推荐分享说明 </a>
					</dd>
				</dl>
				<dl>
					<dt>配送与支付</dt>
					<dd>
						<a href="javascript:;">保险需求测试</a>
					</dd>
					<dd>
						<a href="javascript:;">专题及活动</a>
					</dd>
					<dd>
						<a href="javascript:;">挑选保险产品</a>
					</dd>
					<dd>
						<a href="javascript:;">常见问题 </a>
					</dd>
				</dl>
				<dl>
					<dt>售后保障</dt>
					<dd>
						<a href="javascript:;">保险需求测试</a>
					</dd>
					<dd>
						<a href="javascript:;">专题及活动</a>
					</dd>
					<dd>
						<a href="javascript:;">挑选保险产品</a>
					</dd>
					<dd>
						<a href="javascript:;">常见问题 </a>
					</dd>
				</dl>
				<dl>
					<dt>支付方式</dt>
					<dd>
						<a href="javascript:;">保险需求测试</a>
					</dd>
					<dd>
						<a href="javascript:;">专题及活动</a>
					</dd>
					<dd>
						<a href="javascript:;">挑选保险产品</a>
					</dd>
					<dd>
						<a href="javascript:;">常见问题 </a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="javascript:;">保险需求测试</a>
					</dd>
					<dd>
						<a href="javascript:;">专题及活动</a>
					</dd>
					<dd>
						<a href="javascript:;">挑选保险产品</a>
					</dd>
					<dd>
						<a href="javascript:;">常见问题 </a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="javascript:;">保险需求测试</a>
					</dd>
					<dd>
						<a href="javascript:;">专题及活动</a>
					</dd>
					<dd>
						<a href="javascript:;">挑选保险产品</a>
					</dd>
					<dd>
						<a href="javascript:;">常见问题 </a>
					</dd>
				</dl>
				<dl>
					<dt>帮助中心</dt>
					<dd>
						<a href="javascript:;">保险需求测试</a>
					</dd>
					<dd>
						<a href="javascript:;">专题及活动</a>
					</dd>
					<dd>
						<a href="javascript:;">挑选保险产品</a>
					</dd>
					<dd>
						<a href="javascript:;">常见问题 </a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<!--网站地图END-->
	<!--网站页脚-->

	<!--右侧菜单栏购物车样式-->
	<div class="fixedBox">
		<ul class="fixedBoxList">
			<li class="fixeBoxLi user"><a href="javascript:;"> <span
					class="fixeBoxSpan"></span> <strong>消息中心</strong></a></li>
			<li class="fixeBoxLi cart_bd" style="display: block;" id="cartboxs">
				<p class="good_cart">9</p> <span class="fixeBoxSpan"></span> <strong>购物车</strong>
				<div class="cartBox">
					<div class="bjfff"></div>
					<div class="message">购物车内暂无商品，赶紧选购吧</div>
				</div>
			</li>
			<li class="fixeBoxLi Service "><span class="fixeBoxSpan"></span>
				<strong>客服</strong>
				<div class="ServiceBox">
					<div class="bjfffs"></div>
					<dl onclick="javascript:;">
						<dt>
							<img src="images/Service1.png">
						</dt>
						<dd>
							<strong>QQ客服1</strong>
							<p class="p1">9:00-22:00</p>
							<p class="p2">
								<a href="javascript:;">点击交谈</a>
							</p>
						</dd>
					</dl>
					<dl onclick="javascript:;">
						<dt>
							<img src="images/Service1.png">
						</dt>
						<dd>
							<strong>QQ客服1</strong>
							<p class="p1">9:00-22:00</p>
							<p class="p2">
								<a href="javascript:;">点击交谈</a>
							</p>
						</dd>
					</dl>
				</div></li>
			<li class="fixeBoxLi code cart_bd " style="display: block;"
				id="cartboxs"><span class="fixeBoxSpan"></span> <strong>微信</strong>
				<div class="cartBox">
					<div class="bjfff"></div>
					<div class="QR_code">
						<p>
							<img src="images/erweim.jpg" width="180px" height="180px" />
						</p>
						<p>微信扫一扫，关注我们</p>
					</div>
				</div></li>

			<li class="fixeBoxLi Home"><a href="./"> <span
					class="fixeBoxSpan"></span> <strong>收藏夹</strong>
			</a></li>
			<li class="fixeBoxLi BackToTop"><span class="fixeBoxSpan"></span>
				<strong>返回顶部</strong></li>
		</ul>
	</div>

</body>
</html>
