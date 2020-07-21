package com.jhta.delivery.vo;

import java.util.Date;

// 가게 
public class ShopVo {

	// 가게번호
	private int num;
	
	// 가게프로필사진
	private String profile_img;

	// 가게명
	private String name;

	// 가게소개
	private String introduce;
	
	// 전화번호
	private String tel;
	
	// 건물관리번호
	private String buildingCode;
	
	// 상세주소
	private String address_detail;
	
	// 가게카테고리
	private String shop_category;
	
	// 최소주문금액
	private int min_price;
	
	// 결제방법
	private String payment_option;	

	// 안내
	private String info;
	
	// 리뷰안내
	private String review_info;

	// 휴무일
	private String personal_day;
	
	// 오픈시간
	private String open_time;
	
	// 마감시간
	private String close_time;

	// 배달지역
	private String delivery_area;

	// 상호명
	private String mutual_name;

	// 사업자주소
	private String addr;

	// 사업자 등록번호
	private String reg_num;

	// 가게상태 0(close),1(open)
	private String status;

	// 울트라콜 OFF(0),ON(1)
	private int ultracall;

	// 광고클릭수 울트라콜ON일 시 클릭수가 오름
	private int addcount;

	// 사장번호
	private int owner_num;

	//가게등록일
	private Date regdate;
	
	public ShopVo() {}

	public ShopVo(int num, String profile_img, String name, String introduce, String tel, String buildingCode,
			String address_detail, String shop_category, int min_price, String payment_option, String info,
			String review_info, String personal_day, String open_time, String close_time, String delivery_area,
			String mutual_name, String addr, String reg_num, String status, int ultracall, int addcount, int owner_num,
			Date regdate) {
		super();
		this.num = num;
		this.profile_img = profile_img;
		this.name = name;
		this.introduce = introduce;
		this.tel = tel;
		this.buildingCode = buildingCode;
		this.address_detail = address_detail;
		this.shop_category = shop_category;
		this.min_price = min_price;
		this.payment_option = payment_option;
		this.info = info;
		this.review_info = review_info;
		this.personal_day = personal_day;
		this.open_time = open_time;
		this.close_time = close_time;
		this.delivery_area = delivery_area;
		this.mutual_name = mutual_name;
		this.addr = addr;
		this.reg_num = reg_num;
		this.status = status;
		this.ultracall = ultracall;
		this.addcount = addcount;
		this.owner_num = owner_num;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getShop_category() {
		return shop_category;
	}

	public void setShop_category(String shop_category) {
		this.shop_category = shop_category;
	}

	public int getMin_price() {
		return min_price;
	}

	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}

	public String getPayment_option() {
		return payment_option;
	}

	public void setPayment_option(String payment_option) {
		this.payment_option = payment_option;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getReview_info() {
		return review_info;
	}

	public void setReview_info(String review_info) {
		this.review_info = review_info;
	}

	public String getPersonal_day() {
		return personal_day;
	}

	public void setPersonal_day(String personal_day) {
		this.personal_day = personal_day;
	}

	public String getOpen_time() {
		return open_time;
	}

	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}

	public String getClose_time() {
		return close_time;
	}

	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}

	public String getDelivery_area() {
		return delivery_area;
	}

	public void setDelivery_area(String delivery_area) {
		this.delivery_area = delivery_area;
	}

	public String getMutual_name() {
		return mutual_name;
	}

	public void setMutual_name(String mutual_name) {
		this.mutual_name = mutual_name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getReg_num() {
		return reg_num;
	}

	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUltracall() {
		return ultracall;
	}

	public void setUltracall(int ultracall) {
		this.ultracall = ultracall;
	}

	public int getAddcount() {
		return addcount;
	}

	public void setAddcount(int addcount) {
		this.addcount = addcount;
	}

	public int getOwner_num() {
		return owner_num;
	}

	public void setOwner_num(int owner_num) {
		this.owner_num = owner_num;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
