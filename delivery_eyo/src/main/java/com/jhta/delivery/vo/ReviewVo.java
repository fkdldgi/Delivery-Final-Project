package com.jhta.delivery.vo;

// 리뷰
public class ReviewVo {

	// 리뷰번호
	private int num;

	// 내용
	private String content;

	// 그룹번호
	private Integer ref;

	// 레벨
	private Integer lev;

	// 출력순서
	private Integer step;

	// 평점
	private String grade;

	// 작성일
	private String regdate;

	// 이미지번호
	private int review_img_num;

	// 가게번호
	private int shop_num;

	// 회원번호
	private int member_num;

	// 사장번호
	private int owner_num;

	public ReviewVo() {}

	public ReviewVo(int num, String content, Integer ref, Integer lev, Integer step, String grade, String regdate,
				int review_img_num, int shop_num, int member_num, int owner_num) {
			super();
			this.num = num;
			this.content = content;
			this.ref = ref;
			this.lev = lev;
			this.step = step;
			this.grade = grade;
			this.regdate = regdate;
			this.review_img_num = review_img_num;
			this.shop_num = shop_num;
			this.member_num = member_num;
			this.owner_num = owner_num;
		}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getRef() {
		return ref;
	}

	public void setRef(Integer ref) {
		this.ref = ref;
	}

	public Integer getLev() {
		return lev;
	}

	public void setLev(Integer lev) {
		this.lev = lev;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getReview_img_num() {
		return review_img_num;
	}

	public void setReview_img_num(int review_img_num) {
		this.review_img_num = review_img_num;
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
