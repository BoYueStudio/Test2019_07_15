package com.bean;

public class Address {

private Integer	address_Id	;
private Integer	admins_Id	;
private String	address	;
private String dress_Name	;
private String 	address_Phone	;



public Address() {
	super();
}
public Address(Integer address_Id, Integer admins_Id, String address, String dress_Name, String address_Phone) {
	super();
	this.address_Id = address_Id;
	this.admins_Id = admins_Id;
	this.address = address;
	this.dress_Name = dress_Name;
	this.address_Phone = address_Phone;
}
public Integer getAddress_Id() {
	return address_Id;
}
public void setAddress_Id(Integer address_Id) {
	this.address_Id = address_Id;
}
public Integer getAdmins_Id() {
	return admins_Id;
}
public void setAdmins_Id(Integer admins_Id) {
	this.admins_Id = admins_Id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDress_Name() {
	return dress_Name;
}
public void setDress_Name(String dress_Name) {
	this.dress_Name = dress_Name;
}
public String getAddress_Phone() {
	return address_Phone;
}
public void setAddress_Phone(String address_Phone) {
	this.address_Phone = address_Phone;
}



}
