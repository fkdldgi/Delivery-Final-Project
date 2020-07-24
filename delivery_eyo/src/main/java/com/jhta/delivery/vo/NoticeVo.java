package com.jhta.delivery.vo;

import java.util.Date;

public class NoticeVo {
    // �۹�ȣ 
    private int num;

    // ���� 
    private String title;

    // ���� 
    private String content;

    // �ۼ��� 
    private Date regdate;

    // �����ڹ�ȣ 
    private int adminNum;
   //���� �Ϲ�0, ����1
    private int division;
    
    public NoticeVo() {
    	
    }
    

	public NoticeVo(int num, String title, String content, Date regdate, int adminNum, int division) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.adminNum = adminNum;
		this.division = division;
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

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}
    
	
}
