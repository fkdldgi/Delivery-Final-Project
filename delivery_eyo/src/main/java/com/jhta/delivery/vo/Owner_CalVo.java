package com.jhta.delivery.vo;

//  가게정산
public class Owner_CalVo {

	// 정산번호
	private int num;
	
	// total price
	private int total_price;
	
	// ex_time
	private String ex_time;
	
	// 배달완료 시간
	private String end_time;
	
	// 배달상태
	private String status;
	
	public Owner_CalVo() {}

	public Owner_CalVo(int num, int total_price, String ex_time, String end_time, String status) {
		super();
		this.num = num;
		this.total_price = total_price;
		this.ex_time = ex_time;
		this.end_time = end_time;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getEx_time() {
		return ex_time;
	}

	public void setEx_time(String ex_time) {
		this.ex_time = ex_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	
}
