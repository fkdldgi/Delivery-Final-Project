package com.jhta.delivery.vo;

//  가게정산
public class Owner_CalVo {

	// 년도
	private String year;
	
	// 총 가격
	private int real_amount;
	
	// 총 수수료
	private int commission;
	
	public Owner_CalVo() {}

	public Owner_CalVo(String year, int real_amount, int commission) {
		super();
		this.year = year;
		this.real_amount = real_amount;
		this.commission = commission;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
