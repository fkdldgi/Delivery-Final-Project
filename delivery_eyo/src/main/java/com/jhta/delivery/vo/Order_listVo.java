package com.jhta.delivery.vo;

public class Order_listVo {

	//고객번호
	private int member_num;
	//주문시간
	private String start_time;
	//주문번호
	private int Order_num;
	//총결제금액
	private int total_price;
	//가게번호
	private int shop_num;
	//주문메뉴번호
	private int Order_menu_num;
	//개수
	private int count;
	//메뉴이름
	private String Order_menu_name;
	//주문메뉴옵션번호
	private int Order_menu_option_num;
	//옵션메뉴이름
	private String Order_menu_option_name;
	//가게프로필사진
	private String profile_img;
	//가게명
	private String store_name;
	
	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public int getOrder_num() {
		return Order_num;
	}

	public void setOrder_num(int order_num) {
		Order_num = order_num;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getShop_num() {
		return shop_num;
	}

	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
 
	public int getOrder_menu_num() {
		return Order_menu_num;
	}

	public void setOrder_menu_num(int order_menu_num) {
		Order_menu_num = order_menu_num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOrder_menu_name() {
		return Order_menu_name;
	}

	public void setOrder_menu_name(String order_menu_name) {
		Order_menu_name = order_menu_name;
	}

	public int getOrder_menu_option_num() {
		return Order_menu_option_num;
	}

	public void setOrder_menu_option_num(int order_menu_option_num) {
		Order_menu_option_num = order_menu_option_num;
	}

	public String getOrder_menu_option_name() {
		return Order_menu_option_name;
	}

	public void setOrder_menu_option_name(String order_menu_option_name) {
		Order_menu_option_name = order_menu_option_name;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public Order_listVo() {
		
	}
	
	public Order_listVo(int member_num, String start_time, int order_num, int total_price, int shop_num,
			int order_menu_num, int count, String order_menu_name, int order_menu_option_num,
			String order_menu_option_name, String profile_img, String store_name) {
		super();
		this.member_num = member_num;
		this.start_time = start_time;
		Order_num = order_num;
		this.total_price = total_price;
		this.shop_num = shop_num;
		Order_menu_num = order_menu_num;
		this.count = count;
		Order_menu_name = order_menu_name;
		Order_menu_option_num = order_menu_option_num;
		Order_menu_option_name = order_menu_option_name;
		this.profile_img = profile_img;
		this.store_name = store_name;
	}
	
	
	
}
