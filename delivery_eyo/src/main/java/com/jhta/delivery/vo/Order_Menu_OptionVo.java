package com.jhta.delivery.vo;

// �ֹ��޴��ɼ� 
public class Order_Menu_OptionVo {

	// �ֹ��޴��ɼǹ�ȣ
	private int num;

	// �޴��ɼǹ�ȣ
	private int munu_option_num;

	// �ֹ��޴���ȣ
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
