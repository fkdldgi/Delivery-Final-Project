package com.jhta.delivery.vo;

import java.util.Date;

public class QnaVo {

  
    // 글번호 
    private int num;

    // 이름 
    private String name;

    // 이메일 
    private String email;

    // 상담분류 
    private String category;

    // 제목 
    private String title;

    // 내용 
    private String content;

    // 작성일 
    private Date regdate;

    // 관리자번호 
    private int adminNum;

    // 고객번호 
    private int memberNum;

    // 문의답변 
    private String comments;
    

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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getAdminNum() {
		return adminNum;
	}


	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}


	public int getMemberNum() {
		return memberNum;
	}


	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}
	public QnaVo() {
		
	}

	public QnaVo(int num, String name, String email, String category, String title, String content, Date regdate,
			int adminNum, int memberNum, String comments) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		this.category = category;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.adminNum = adminNum;
		this.memberNum = memberNum;
		this.comments = comments;
	}
    
    
}
