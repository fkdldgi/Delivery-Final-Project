package com.jhta.delivery.vo;

import java.util.Date;

// �ֹ�
public class Order_MainVo {

	// �ֹ���ȣ
	private int num;

	// �ֹ��ð�
	private Date start_time;

	// ���������ð�
	private Date end_ex_time;

	// �����ð�
	private Date end_time;

	// ����ȣ
	private int member_num;

	// ���ּҹ�ȣ
	private String addr_num;

	// ���ּ�
	private String addr_detail;

	// �������ȣ
	private int delivery_tip_num;

	// �ֹ����� ������,��,�ֹ���û,����,�����,�����
	private String status;

	// ���̴���ȣ
	private int rider_num;

	// ��û����(����)
	private String owner_requests;

	// ��û����(���̴�)
	private String rider_requests;

	// �Ѱ����ݾ�
	private int total_price;

	// ���Ұ����ο�
	private int dutchpay_people;

	//���� ������
	private int review_status;
	
	//���� ��ȣ
	private int shop_num;
	
	public Order_MainVo() {}

	public Order_MainVo(int num, Date start_time, Date end_ex_time, Date end_time, int member_num, String addr_num,
			String addr_detail, int delivery_tip_num, String status, int rider_num, String owner_requests,
			String rider_requests, int total_price, int dutchpay_people, int review_status, int shop_num) {
		super();
		this.num = num;
		this.start_time = start_time;
		this.end_ex_time = end_ex_time;
		this.end_time = end_time;
		this.member_num = member_num;
		this.addr_num = addr_num;
		this.addr_detail = addr_detail;
		this.delivery_tip_num = delivery_tip_num;
		this.status = status;
		this.rider_num = rider_num;
		this.owner_requests = owner_requests;
		this.rider_requests = rider_requests;
		this.total_price = total_price;
		this.dutchpay_people = dutchpay_people;
		this.review_status = review_status;
		this.shop_num = shop_num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_ex_time() {
		return end_ex_time;
	}

	public void setEnd_ex_time(Date end_ex_time) {
		this.end_ex_time = end_ex_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public String getAddr_num() {
		return addr_num;
	}

	public void setAddr_num(String addr_num) {
		this.addr_num = addr_num;
	}

	public String getAddr_detail() {
		return addr_detail;
	}

	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}

	public int getDelivery_tip_num() {
		return delivery_tip_num;
	}

	public void setDelivery_tip_num(int delivery_tip_num) {
		this.delivery_tip_num = delivery_tip_num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRider_num() {
		return rider_num;
	}

	public void setRider_num(int rider_num) {
		this.rider_num = rider_num;
	}

	public String getOwner_requests() {
		return owner_requests;
	}

	public void setOwner_requests(String owner_requests) {
		this.owner_requests = owner_requests;
	}

	public String getRider_requests() {
		return rider_requests;
	}

	public void setRider_requests(String rider_requests) {
		this.rider_requests = rider_requests;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getDutchpay_people() {
		return dutchpay_people;
	}

	public void setDutchpay_people(int dutchpay_people) {
		this.dutchpay_people = dutchpay_people;
	}

	public int getReview_status() {
		return review_status;
	}

	public void setReview_status(int review_status) {
		this.review_status = review_status;
	}

	public int getShop_num() {
		return shop_num;
	}

	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}

}
