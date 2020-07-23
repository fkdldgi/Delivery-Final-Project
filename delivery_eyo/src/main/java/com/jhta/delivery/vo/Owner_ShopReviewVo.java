package com.jhta.delivery.vo;
public class Owner_ShopReviewVo {
	// 가게에 리뷰를 단 회원아이디
	private String id;
	
	// 회원 이미지 img
	private String img;
	
	// 가게 리뷰 평점
	private String grade;
	
	// 가게 리뷰
	private String content;
	
	// 가게 리뷰 날짜
	private String regdate;
	
	// img save_filename
	private String save_filename;
	
	// img 경로
	private String img_path;

	public Owner_ShopReviewVo() {}

	public Owner_ShopReviewVo(String id, String img, String grade, String content, String regdate,
			String save_filename, String img_path) {
		this.id = id;
		this.img = img;
		this.grade = grade;
		this.content = content;
		this.regdate = regdate;
		this.save_filename = save_filename;
		this.img_path = img_path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getSave_filename() {
		return save_filename;
	}

	public void setSave_filename(String save_filename) {
		this.save_filename = save_filename;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	
	
}