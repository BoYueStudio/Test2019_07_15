package com.bean;

public class CarGoods {
	private Goods goods;
	private Integer num;

	public CarGoods() {
		super();
	}

	public CarGoods(Goods goods, Integer num) {
		super();
		this.goods = goods;
		this.num = num;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
