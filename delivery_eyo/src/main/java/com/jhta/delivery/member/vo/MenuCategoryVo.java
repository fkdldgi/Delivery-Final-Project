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

	// ī�װ��׷켳��
	private String info;

	public MenuCategoryVo() {}

	public MenuCategoryVo(int num, String name, int priority, int shop_num, String info) {
		super();
		this.num = num;
		this.name = name;
		this.priority = priority;
		this.shop_num = shop_num;
		this.info = info;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
