package com.jhta.delivery.vo;

public class Owner_Review_ImgVo {
	// 리뷰이미지 번호
	private int review_imgNum;
	
	// img 경로
	private String review_imgPath;
	
	// img 명
	private String review_orign_FileName;
	
	// img 저장명
	private String review_save_FileName;
	
	public Owner_Review_ImgVo() {}
	
	public Owner_Review_ImgVo(int review_imgNum, String review_imgPath, String review_orign_FileName,
			String review_save_FileName) {
		this.review_imgNum = review_imgNum;
		this.review_imgPath = review_imgPath;
		this.review_orign_FileName = review_orign_FileName;
		this.review_save_FileName = review_save_FileName;
	}

	public int getReview_imgNum() {
		return review_imgNum;
	}

	public void setReview_imgNum(int review_imgNum) {
		this.review_imgNum = review_imgNum;
	}

	public String getReview_imgPath() {
		return review_imgPath;
	}

	public void setReview_imgPath(String review_imgPath) {
		this.review_imgPath = review_imgPath;
	}

	public String getReview_orign_FileName() {
		return review_orign_FileName;
	}

	public void setReview_orign_FileName(String review_orign_FileName) {
		this.review_orign_FileName = review_orign_FileName;
	}

	public String getReview_save_FileName() {
		return review_save_FileName;
	}

	public void setReview_save_FileName(String review_save_FileName) {
		this.review_save_FileName = review_save_FileName;
	}
	
	
}
