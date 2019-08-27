package com.bean;

public class Goods {
private Integer	goods_Id;
private String goods_Name;
private Double goods_Price;
private Integer	goods_Num;
private String 	goods_Pic	;
private Integer	goods_Type	;
private String desc	;
private Integer statu	;
private String 	date	;





public Goods() {
	super();
}
public Goods(Integer goods_Id, String goods_Name, Double goods_Price, Integer goods_Num, String goods_Pic,
		Integer goods_Type, String desc, Integer statu, String date) {
	super();
	this.goods_Id = goods_Id;
	this.goods_Name = goods_Name;
	this.goods_Price = goods_Price;
	this.goods_Num = goods_Num;
	this.goods_Pic = goods_Pic;
	this.goods_Type = goods_Type;
	this.desc = desc;
	this.statu = statu;
	this.date = date;
}
public Integer getGoods_Id() {
	return goods_Id;
}
public void setGoods_Id(Integer goods_Id) {
	this.goods_Id = goods_Id;
}
public String getGoods_Name() {
	return goods_Name;
}
public void setGoods_Name(String goods_Name) {
	this.goods_Name = goods_Name;
}
public Double getGoods_Price() {
	return goods_Price;
}
public void setGoods_Price(Double goods_Price) {
	this.goods_Price = goods_Price;
}
public Integer getGoods_Num() {
	return goods_Num;
}
public void setGoods_Num(Integer goods_Num) {
	this.goods_Num = goods_Num;
}
public String getGoods_Pic() {
	return goods_Pic;
}
public void setGoods_Pic(String goods_Pic) {
	this.goods_Pic = goods_Pic;
}
public Integer getGoods_Type() {
	return goods_Type;
}
public void setGoods_Type(Integer goods_Type) {
	this.goods_Type = goods_Type;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public Integer getStatu() {
	return statu;
}
public void setStatu(Integer statu) {
	this.statu = statu;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}



}
