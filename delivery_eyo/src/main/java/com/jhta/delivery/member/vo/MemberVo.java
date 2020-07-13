package com.jhta.delivery.member.vo;

import java.util.Date;

public class MemberVo {
 
    private int num; 
    private String id;
    private String pwd;
    private String name;
    private String email;
    private String tel;
    // 상태 탈퇴(0),휴면(1),정상(2)
    private int status;
    private String img;
    // 건물관리번호 
    private String building_nanagement_number;
    private String address_detail;
    private Date regdate;
    // 등급 일반(0),VIP(1),관리자(99)
    private int grade;
    private String gender;
    private String birth;
	public MemberVo(int num, String id, String pwd, String name, String email, String tel, int status, String img,
			String building_nanagement_number, String address_detail, Date regdate, int grade, String gender,
			String birth) {
		super();
		this.num = num;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.status = status;
		this.img = img;
		this.building_nanagement_number = building_nanagement_number;
		this.address_detail = address_detail;
		this.regdate = regdate;
		this.grade = grade;
		this.gender = gender;
		this.birth = birth;
	}
	public MemberVo() {
		super();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBuilding_nanagement_number() {
		return building_nanagement_number;
	}
	public void setBuilding_nanagement_number(String building_nanagement_number) {
		this.building_nanagement_number = building_nanagement_number;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
    
    
}