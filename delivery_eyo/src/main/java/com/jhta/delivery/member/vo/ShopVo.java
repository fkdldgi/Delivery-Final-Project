package com.jhta.delivery.member.vo;

// ���� 
public class ShopVo {

	// ���Թ�ȣ
	private int num;

	// ���Ը�
	private String name;

	// �ּ��ֹ��ݾ�
	private int min_price;

	// �������
	private String payment_option;

	// ���ԼҰ�
	private String introduce;

	// �ȳ�
	private String info;

	// ��ð�
	private String operating_time;

	// �޹���
	private String personal_day;

	// ��ȭ��ȣ
	private String tel;

	// �������
	private String delivery_area;

	// ��ȣ��
	private String mutual_name;

	// ������ּ�
	private String addr;

	// ����� ��Ϲ�ȣ
	private String reg_num;

	// ����ȳ�
	private String review_info;

	// ���������ʻ���
	private String profile_img;

	// ���Ի��� 0(close),1(open)
	private String status;

	// �ǹ�������ȣ
	private String building_management_number;

	// ���ּ�
	private String address_detail;

	// ����ī�װ�
	private int shop_category_num;

	// ��Ʈ���� OFF(0),ON(1)
	private String ultracall;

	// ����Ŭ���� ��Ʈ����ON�� �� Ŭ������ ����
	private int addcount;

	// �����ȣ
	private int owner_num;

	public ShopVo() {}

	public ShopVo(int num, String name, int min_price, String payment_option, String introduce, String info,
			String operating_time, String personal_day, String tel, String delivery_area, String mutual_name,
			String addr, String reg_num, String review_info, String profile_img, String status,
			String building_management_number, String address_detail, int shop_category_num, String ultracall,
			int addcount, int owner_num) {
		super();
		this.num = num;
		this.name = name;
		this.min_price = min_price;
		this.payment_option = payment_option;
		this.introduce = introduce;
		this.info = info;
		this.operating_time = operating_time;
		this.personal_day = personal_day;
		this.tel = tel;
		this.delivery_area = delivery_area;
		this.mutual_name = mutual_name;
		this.addr = addr;
		this.reg_num = reg_num;
		this.review_info = review_info;
		this.profile_img = profile_img;
		this.status = status;
		this.building_management_number = building_management_number;
		this.address_detail = address_detail;
		this.shop_category_num = shop_category_num;
		this.ultracall = ultracall;
		this.addcount = addcount;
		this.owner_num = owner_num;
	}

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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getOperating_time() {
		return operating_time;
	}

	public void setOperating_time(String operating_time) {
		this.operating_time = operating_time;
	}

	public String getPersonal_day() {
		return personal_day;
	}

	public void setPersonal_day(String personal_day) {
		this.personal_day = personal_day;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getReview_info() {
		return review_info;
	}

	public void setReview_info(String review_info) {
		this.review_info = review_info;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBuilding_management_number() {
		return building_management_number;
	}

	public void setBuilding_management_number(String building_management_number) {
		this.building_management_number = building_management_number;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public int getShop_category_num() {
		return shop_category_num;
	}

	public void setShop_category_num(int shop_category_num) {
		this.shop_category_num = shop_category_num;
	}

	public String getUltracall() {
		return ultracall;
	}

	public void setUltracall(String ultracall) {
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
	
	
}
