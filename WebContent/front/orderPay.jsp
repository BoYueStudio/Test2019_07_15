<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单支付</title>
<style type="text/css">
#payForm{
border: 1px solid red;
width:360px;
margin: 200px auto;
padding-left: 40px;
}
input{
border:0px;
width:240px;
}

</style>
</head>
<body>
    <form id="payForm" action="${pageContext.request.contextPath}/alipay?method=goAlipay" method="post">
        <table>
        	<tr>
        		<td>
        			订单编号:
        			<input   id="WIDout_trade_no" name="WIDout_trade_no" value="${orderInfo.o_id }" />		 
        		</td>
        	</tr>
        	<tr>
        		 <td>
        			产品名称: 
        			<input id="WIDsubject" name="WIDsubject"  value="${orderInfo.u_id }"/>
        		</td>
        	<tr>
        	<tr>
        		<td>
        			订单价格:
        			<input id="WIDtotal_amount" name="WIDtotal_amount" value=" ${orderInfo.total }" />    			
        		</td>
        	</tr>
        	<tr>
        		<td>
        			商品描述：
        			<input id="WIDbody" name="WIDbody" value="1" />	
        		</td>
        	</tr>
        	<tr>
        		<td>
        			<input type="submit" value="前往支付宝进行支付">
        		</td>
        	</tr>
        </table>
    </form>
    
</body>
</html>