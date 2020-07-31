package com.jhta.delivery.vo;

import java.sql.Date;

public class CouponVo {
	  // 쿠폰번호 
    private int num;

    // 쿠폰명 
    private String name;

    // 할인구분 WON,PERCENT
    private String discountType;

    // 할인값 
    private String discountPrice;

    // 등록일 
    private Date regdate;

    // 시작일 
    private Date startdate;

    // 만료일 
    private Date enddate;
    

	public CouponVo() {
	}

	public CouponVo(int num, String name, String discountType, String discountPrice, Date regdate, Date startdate,
			Date enddate) {
		super();
		this.num = num;
		this.name = name;
		this.discountType = discountType;
		this.discountPrice = discountPrice;
		this.regdate = regdate;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
    
}

