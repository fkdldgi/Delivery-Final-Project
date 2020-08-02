package com.jhta.delivery.vo;

import java.sql.Date;

public class CouponVo {
	  // ������ȣ 
    private int num;

    // ������ 
    private String name;

    // ���α��� WON,PERCENT
    private String discountType;

    // ���ΰ� 
    private String discountPrice;

    // ����� 
    private Date regdate;

    // ������ 
    private Date startdate;

    // ������ 
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

