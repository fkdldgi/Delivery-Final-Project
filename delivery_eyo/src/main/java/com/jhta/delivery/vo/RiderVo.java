package com.jhta.delivery.vo;

import java.util.Date;

public class RiderVo {

	// 라이더 번호
	private int num;
	
	// 라이더 아이디
	private String id;
	
	// 라이더 비밀번호
	private String pwd;
	
	// 라이더 이름
	private String name;
	
	// 라이더 전화번호
	private String phone;
	
	// 라이더 이메일
	private String email;
	
	// 라이더 상태
	private int status;
	
	@Override
	public String toString() {
		return "RiderVo [num=" + num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", status=" + status + ", regdate=" + regdate + "]";
	}

	// 라이더 가입일
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