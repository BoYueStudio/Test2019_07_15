package com.bean;

public class User {

	private Integer admin_Id;
	private String login_Name;
	private String pet_Name;
	private String pass;
	private Integer role;
	private Integer statu;
	private String reg_Date;
	
	
	
	public User() {
		super();
	}
	public User(Integer admin_Id, String login_Name, String pet_Name, String pass, Integer role, Integer statu,
			String reg_Date) {
		super();
		this.admin_Id = admin_Id;
		this.login_Name = login_Name;
		this.pet_Name = pet_Name;
		this.pass = pass;
		this.role = role;
		this.statu = statu;
		this.reg_Date = reg_Date;
	}
	public Integer getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(Integer admin_Id) {
		this.admin_Id = admin_Id;
	}
	public String getLogin_Name() {
		return login_Name;
	}
	public void setLogin_Name(String login_Name) {
		this.login_Name = login_Name;
	}
	public String getPet_Name() {
		return pet_Name;
	}
	public void setPet_Name(String pet_Name) {
		this.pet_Name = pet_Name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getStatu() {
		return statu;
	}
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	public String getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(String reg_Date) {
		this.reg_Date = reg_Date;
	}
	
	

}
