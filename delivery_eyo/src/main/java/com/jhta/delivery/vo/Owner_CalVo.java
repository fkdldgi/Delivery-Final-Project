package com.jhta.delivery.vo;

//  가게정산
public class Owner_CalVo {

	// 년도
	private int year;
	
	// 월
	private int month;
	
	// 총 가격
	private int total_money;
	
	public Owner_CalVo() {}

	public Owner_CalVo(int year, int month, int total_money) {
		this.year = year;
		this.month = month;
		this.total_money = total_money;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getTotal_money() {
		return total_money;
	}

	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}
	
	
}
