package com.jhta.delivery.member.vo;

public class MenuCategoryVo {
	// �޴�ī�װ�(��ǥ�޴�,��Ʈ�޴�,ġŲ�޴� ��)

	// ī�װ���ȣ
	private int num;

	// ī�װ���
	private String name;

	// �켱����
	private int priority;

	// ���Թ�ȣ
	private int shop_num;

	// ��ǥ�޴�
	private int main_menu;

	public MenuCategoryVo() {}

	public MenuCategoryVo(int num, String name, int priority, int shop_num, int main_menu) {
		super();
		this.num = num;
		this.name = name;
		this.priority = priority;
		this.shop_num = shop_num;
		this.main_menu = main_menu;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getShop_num() {
		return shop_num;
	}

	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}

	public int getMain_menu() {
		return main_menu;
	}

	public void setMain_menu(int main_menu) {
		this.main_menu = main_menu;
	}


}
