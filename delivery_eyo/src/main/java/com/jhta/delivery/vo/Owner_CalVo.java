package com.jhta.delivery.vo;

//  ��������
public class Owner_CalVo {

	// �⵵
	private int year;
	
	// ��
	private int month;
	
	// �� ����
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
