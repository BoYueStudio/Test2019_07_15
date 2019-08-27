package com.bean;

public class GoodsType {
	private Integer type_Id;
	private String type_Name;
	private Integer type_Pid;
	private String type_Path;
	private Integer type_Lv;
	private Integer statu;

	public GoodsType() {
		super();
	}

	public GoodsType(Integer type_Id, String type_Name, Integer type_Pid, String type_Path, Integer type_Lv,
			Integer statu) {
		super();
		this.type_Id = type_Id;
		this.type_Name = type_Name;
		this.type_Pid = type_Pid;
		this.type_Path = type_Path;
		this.type_Lv = type_Lv;
		this.statu = statu;
	}

	public Integer getType_Id() {
		return type_Id;
	}

	public void setType_Id(Integer type_Id) {
		this.type_Id = type_Id;
	}

	public String getType_Name() {
		return type_Name;
	}

	public void setType_Name(String type_Name) {
		this.type_Name = type_Name;
	}

	public Integer getType_Pid() {
		return type_Pid;
	}

	public void setType_Pid(Integer type_Pid) {
		this.type_Pid = type_Pid;
	}

	public String getType_Path() {
		return type_Path;
	}

	public void setType_Path(String type_Path) {
		this.type_Path = type_Path;
	}

	public Integer getType_Lv() {
		return type_Lv;
	}

	public void setType_Lv(Integer type_Lv) {
		this.type_Lv = type_Lv;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

}
