package com.bean;

public class OrderDetails {

	private Integer od_id;
	private String o_id;
	private Integer g_id;
	private Integer total;
	private String o_date;
	
	
	
	
	public OrderDetails() {
		super();
	}
	public OrderDetails(Integer od_id, String o_id, Integer g_id, Integer total, String o_date) {
		super();
		this.od_id = od_id;
		this.o_id = o_id;
		this.g_id = g_id;
		this.total = total;
		this.o_date = o_date;
	}
	public Integer getOd_id() {
		return od_id;
	}
	public void setOd_id(Integer od_id) {
		this.od_id = od_id;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
	
	
	
	
}
