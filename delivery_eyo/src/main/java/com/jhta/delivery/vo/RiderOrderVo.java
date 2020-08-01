package com.jhta.delivery.vo;

// ���̴� ������ ���Ѱ�
public class RiderOrderVo {
	
	// �ֹ��ð�
	private String start_time;
	
	// ��޿����ð�
	private String ex_time;
	
	// ��޵����ð�
	private String end_time;
	
	// ��� ����
	private String status;
	
	// ���̴� ��û����
	private String requests;
	
	// �� �ݾ�
	private int total_price;
	
	// ���Ը�
	private String shop_name;
	
	// ������ȭ��ȣ
	private String shop_phone;
	
	// �ǹ�������ȣ
	private String shop_building_number;
	
	// ���ּ�
	private String shop_address_detail;
	
	// �޴»���̸�
	private String member_name;
	
	// �޴»�� ��ȭ��ȣ
	private String member_phone;
	
	// �����(member �ּ�)
	private String member_building_number;
	
	// ����� ���ּ�
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