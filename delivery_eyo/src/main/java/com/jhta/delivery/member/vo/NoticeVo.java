package com.jhta.delivery.member.vo;

import java.util.Date;

public class NoticeVo {
    // 글번호 
    private int num;

    // 제목 
    private String title;

    // 내용 
    private String content;

    // 작성일 
    private Date regdate;

    // 관리자번호 
    private int adminNum;
    
    public NoticeVo() {
    	
    }
    
	public NoticeVo(int num, String title, String content, Date regdate, int adminNum) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.adminNum = adminNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
    
}
