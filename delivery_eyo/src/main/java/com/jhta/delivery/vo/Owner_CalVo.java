package com.jhta.delivery.vo;

//  ��������
public class Owner_CalVo {

	// �⵵
	private int year;
	
	// ��
	private int month;
	
	// �� ����
	private int real_amount;
	
	// �� ������
	private int commission;
	
	public Owner_CalVo() {}

	public Owner_CalVo(int year, int month, int real_amount, int commission) {
		super();
		this.year = year;
		this.month = month;
		this.real_amount = real_amount;
		this.commission = commission;
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

	public int getReal_amount() {
		return real_amount;
	}

	public void setReal_amount(int real_amount) {
		this.real_amount = real_amount;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}
}
