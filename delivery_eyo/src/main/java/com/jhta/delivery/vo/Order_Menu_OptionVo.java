package com.jhta.delivery.vo;

// �ֹ��޴��ɼ� 
public class Order_Menu_OptionVo {

	// �ֹ��޴��ɼǹ�ȣ
	private int num;

	// �޴��ɼǹ�ȣ
	private int menu_option_num;

	// �ֹ��޴���ȣ
	
	
	private int order_menu_num;
	
	public Order_Menu_OptionVo() {}

	public Order_Menu_OptionVo(int num, int menu_option_num, int order_menu_num) {
		super();
		this.num = num;
		this.menu_option_num = menu_option_num;
		this.order_menu_num = order_menu_num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getmenu_option_num() {
		return menu_option_num;
	}

	public void setmenu_option_num(int menu_option_num) {
		this.menu_option_num = menu_option_num;
	}

	public int getOrder_menu_num() {
		return order_menu_num;
	}

	public void setOrder_menu_num(int order_menu_num) {
		this.order_menu_num = order_menu_num;
	}
	
}
