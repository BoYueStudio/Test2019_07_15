package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.bean.OrderInfo;
import com.service.OrderInfoService;
import com.service.impl.OrderInfoServiceImpl;

@WebServlet(urlPatterns={"/alipay"})
public class AlipayController extends HttpServlet {

	public AlipayController(){
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		String method=req.getParameter("method");

		
		if("goAlipay".equals(method)){//ȥ֧��
			try {
				goAlipay(req,resp);
			} catch (AlipayApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if("alipayReturnNotice".equals(method)){//֧���ɹ�, ����ͬ��֪ͨ��
			alipayReturnNotice(req,resp);
			return;
		}
		

		if("alipayNotifyNotice".equals(method)){//֧���ɹ�, �����첽֪ͨ�ӿ�
			alipayNotifyNotice(req,resp);
			return;
		}
		
		
	}
	
	protected void goAlipay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AlipayApiException {
		OrderInfoService ifs=new OrderInfoServiceImpl();
		//OrderInfo order=ifs.getOrderInfoById(req.getParameter("WIDout_trade_no"));
		
		//�̻������ţ��̻���վ����ϵͳ��Ψһ�����ţ�����
		String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//���������
		String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8").trim();
		//�������ƣ�����
		String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
		//��Ʒ�������ɿ�
		String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
		


		//Product product = productService.getProductById(order.getProductId());

		//��ó�ʼ����AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		//�����������
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);


		// �ñʶ��������������ʱ�䣬���ڽ��رս��ס�ȡֵ��Χ��1m��15d��m-���ӣ�h-Сʱ��d-�죬1c-���죨1c-���������£����۽��׺�ʱ����������0��رգ��� �ò�����ֵ������С���㣬 �� 1.5h����ת��Ϊ 90m��
    	String timeout_express = "1c";

		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
				+ "\"total_amount\":\""+ total_amount +"\","
				+ "\"subject\":\""+ subject +"\","
				+ "\"body\":\""+ body +"\","
				+ "\"timeout_express\":\""+ timeout_express +"\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		//����
		String result = alipayClient.pageExecute(alipayRequest).getBody();

		
//		return result;
		response.getWriter().write(result);
		
	}
	
	protected void alipayReturnNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void alipayNotifyNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
