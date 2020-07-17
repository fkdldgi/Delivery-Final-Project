package com.jhta.delivery.vo;

// 주문메뉴옵션 
public class Order_Menu_OptionVo {

	// 주문메뉴옵션번호
	private int num;

	// 메뉴옵션번호
	private int munu_option_num;

	// 주문메뉴번호
	private int order_menu_num;
	
	public Order_Menu_OptionVo() {}

	public Order_Menu_OptionVo(int num, int munu_option_num, int order_menu_num) {
		super();
		this.num = num;
		this.munu_option_num = munu_option_num;
		this.order_menu_num = order_menu_num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getMunu_option_num() {
		return munu_option_num;
	}

	public void setMunu_option_num(int munu_option_num) {
		this.munu_option_num = munu_option_num;
	}

	public int getOrder_menu_num() {
		return order_menu_num;
	}

	public void setOrder_menu_num(int order_menu_num) {
		this.order_menu_num = order_menu_num;
	}
	
}
