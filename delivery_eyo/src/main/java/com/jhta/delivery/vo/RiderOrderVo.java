package com.jhta.delivery.vo;

// 라이더 오더에 대한거
public class RiderOrderVo {
	
	// 주문시간
	private String start_time;
	
	// 배달예정시간
	private String ex_time;
	
	// 배달도착시간
	private String end_time;
	
	// 배달 상태
	private String status;
	
	// 라이더 요청사항
	private String requests;
	
	// 총 금액
	private int total_price;
	
	// 가게명
	private String shop_name;
	
	// 가게전화번호
	private String shop_phone;
	
	// 건물관리번호
	private String shop_building_number;
	
	// 상세주소
	private String shop_address_detail;
	
	// 받는사람이름
	private String member_name;
	
	// 받는사람 전화번호
	private String member_phone;
	
	// 배달지(member 주소)
	private String member_building_number;
	
	// 배달지 상세주소
	private String member_address_detail;
	
	public RiderOrderVo() {}

	public RiderOrderVo(String start_time, String ex_time, String end_time, String status, String requests,
			int total_price, String shop_name, String shop_phone, String shop_building_number,
			String shop_address_detail, String member_name, String member_phone, String member_building_number,
			String member_address_detail) {
		super();
		this.start_time = start_time;
		this.ex_time = ex_time;
		this.end_time = end_time;
		this.status = status;
		this.requests = requests;
		this.total_price = total_price;
		this.shop_name = shop_name;
		this.shop_phone = shop_phone;
		this.shop_building_number = shop_building_number;
		this.shop_address_detail = shop_address_detail;
		this.member_name = member_name;
		this.member_phone = member_phone;
		this.member_building_number = member_building_number;
		this.member_address_detail = member_address_detail;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getShop_phone() {
		return shop_phone;
	}

	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}

	public String getShop_building_number() {
		return shop_building_number;
	}

	public void setShop_building_number(String shop_building_number) {
		this.shop_building_number = shop_building_number;
	}

	public String getShop_address_detail() {
		return shop_address_detail;
	}

	public void setShop_address_detail(String shop_address_detail) {
		this.shop_address_detail = shop_address_detail;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_building_number() {
		return member_building_number;
	}

	public void setMember_building_number(String member_building_number) {
		this.member_building_number = member_building_number;
	}

	public String getMember_address_detail() {
		return member_address_detail;
	}

	public void setMember_address_detail(String member_address_detail) {
		this.member_address_detail = member_address_detail;
	}
	
	
}