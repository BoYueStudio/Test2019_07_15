<%@page import="com.bean.Goods"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>findgoodsbyid</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

</head>
<body>




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



</body>
</html>