package com.jhta.delivery.vo;

import java.sql.Date;

public class Coupon_publishVo {
	// 발행쿠폰번호 
    private int num;

    // 고객번호 
    private int memberNum;

    // 쿠폰번호 
    private int couponNum;

    // 발행일 
    private Date regdate;

    // 상태 만료(0),사용(1),사용가능(2)
    private int status;

    // 거래번호 
    private int order_num;

	public Coupon_publishVo(int num, int memberNum, int couponNum, Date regdate, int status, int order_num) {
		super();
		this.num = num;
		this.memberNum = memberNum;
		this.couponNum = couponNum;
		this.regdate = regdate;
		this.status = status;
		this.order_num = order_num;
	}

	public Coupon_publishVo() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public int getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(int couponNum) {
		this.couponNum = couponNum;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
    
    
    
}
