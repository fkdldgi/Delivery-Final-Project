package com.jhta.delivery.vo;

// �ֹ��޴�
public class Order_MenuVo {

	// �ֹ��޴���ȣ
	private int num;

	// �ֹ���ȣ
	private int order_num;

	// �޴���ȣ
	private int menu_num;

	// �ֹ��ݾ�
	private int order_price;

	// ����
	private int count;

	public Order_MenuVo(){}

	public Order_MenuVo(int num, int order_num, int menu_num, int order_price, int count) {
		super();
		this.num = num;
		this.order_num = order_num;
		this.menu_num = menu_num;
		this.order_price = order_price;
		this.count = count;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getMenu_num() {
		return menu_num;
	}

	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
