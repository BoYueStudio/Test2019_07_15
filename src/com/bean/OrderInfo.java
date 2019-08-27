package com.bean;

public class OrderInfo {

	private String o_id;
	private Integer u_id;
	private Double total;
	private String address;
	private String phone;
	private String uname;
	private String beizhu;
	private String statu;
	private String o_date;
	
	
	
	public OrderInfo() {
		super();
	}
	public OrderInfo(String o_id, Integer u_id, Double total, String address, String phone, String uname, String beizhu,
			String statu, String o_date) {
		super();
		this.o_id = o_id;
		this.u_id = u_id;
		this.total = total;
		this.address = address;
		this.phone = phone;
		this.uname = uname;
		this.beizhu = beizhu;
		this.statu = statu;
		this.o_date = o_date;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
	
	
	
	
	

}
