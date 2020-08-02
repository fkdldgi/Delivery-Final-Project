package com.jhta.delivery.vo;

import java.util.Date;

public class RiderVo {

	// ���̴� ��ȣ
	private int num;
	
	// ���̴� ���̵�
	private String id;
	
	// ���̴� ��й�ȣ
	private String pwd;
	
	// ���̴� �̸�
	private String name;
	
	// ���̴� ��ȭ��ȣ
	private String phone;
	
	// ���̴� �̸���
	private String email;
	
	// ���̴� ����
	private int status;
	
	@Override
	public String toString() {
		return "RiderVo [num=" + num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", status=" + status + ", regdate=" + regdate + "]";
	}

	// ���̴� ������
	private Date regdate;
	
	public RiderVo() {}

	public RiderVo(int num, String id, String pwd, String name, String phone, String email, int status, Date regdate) {
		this.num = num;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}