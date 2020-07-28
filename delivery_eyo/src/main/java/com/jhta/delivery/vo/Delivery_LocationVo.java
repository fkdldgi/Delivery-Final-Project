package com.jhta.delivery.vo;

public class Delivery_LocationVo {
	private int num;
	private int shop_num;
	private String sido;
	private String sigungu;
	private String hname;
	public Delivery_LocationVo() {}
	public Delivery_LocationVo(int num, int shop_num, String sido, String sigungu, String hname) {
		super();
		this.num = num;
		this.shop_num = shop_num;
		this.sido = sido;
		this.sigungu = sigungu;
		this.hname = hname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getShop_num() {
		return shop_num;
	}
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	
	
}
