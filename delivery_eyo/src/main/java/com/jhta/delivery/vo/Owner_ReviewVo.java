package com.jhta.delivery.vo;

import java.sql.Date;

public class Owner_ReviewVo {
	// 리뷰번호
	private int reviewNum;
	
	// 리뷰내용
	private String content;
	
	// 대댓글 확인
	private int ref;
	
	// 일반회원인지 사장인지 구별
	private int lev;
	
	// 평점
	private String grade;
	
	// 작성일
	private Date regdate;
	
	// 리뷰이미지 PK번호
	private int review_imgnum;
	
	// 가게번호
	private int shop_num;
	
	// 회원번호
	private int member_num;
	
	// 사장번호
	private int owner_num;

	public Owner_ReviewVo() {
	}

	public Owner_ReviewVo(int reviewNum, String content, int ref, int lev, String grade, Date regdate,
			int review_imgnum, int shop_num, int member_num, int owner_num) {
		this.reviewNum = reviewNum;
		this.content = content;
		this.ref = ref;
		this.lev = lev;
		this.grade = grade;
		this.regdate = regdate;
		this.review_imgnum = review_imgnum;
		this.shop_num = shop_num;
		this.member_num = member_num;
		this.owner_num = owner_num;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getReview_imgnum() {
		return review_imgnum;
	}

	public void setReview_imgnum(int review_imgnum) {
		this.review_imgnum = review_imgnum;
	}

	public int getShop_num() {
		return shop_num;
	}

	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public int getOwner_num() {
		return owner_num;
	}

	public void setOwner_num(int owner_num) {
		this.owner_num = owner_num;
	}
	
	
}
