package com.jhta.delivery.vo;

public class Menu_MenuOptionVo {

	// �޴���ȣ
	private int menu_num;
	
	// �޴��̸�
	private int menu_name;
	
	// �޴�����
	private String menu_info;
	
	// �޴�����
	private int menu_price;
	
	// �޴� ����
	private int status;
	
	// �޴��̹���
	private String img;
	
	// �޴��� �޴�ī�װ���ȣ
	private int menu_category_num;
	
	// �޴��ɼǹ�ȣ
	private int mo_num;
	
	// �޴��ɼ��̸�
	private String mo_name;
	
	// �޴��ɼ� ����
	private int mo_price;
	
	// �޴��ɼ� ī�װ�
	private String mo_category;
	
	// �޴��ɼ� �޴���ȣ
	private int mo_menu_num;
	
	public Menu_MenuOptionVo() {}

	public Menu_MenuOptionVo(int menu_num, int menu_name, String menu_info, int menu_price, int status, String img,
			int menu_category_num, int mo_num, String mo_name, int mo_price, String mo_category, int mo_menu_num) {
		this.menu_num = menu_num;
		this.menu_name = menu_name;
		this.menu_info = menu_info;
		this.menu_price = menu_price;
		this.status = status;
		this.img = img;
		this.menu_category_num = menu_category_num;
		this.mo_num = mo_num;
		this.mo_name = mo_name;
		this.mo_price = mo_price;
		this.mo_category = mo_category;
		this.mo_menu_num = mo_menu_num;
	}

	public int getMenu_num() {
		return menu_num;
	}

	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}

	public int getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(int menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_info() {
		return menu_info;
	}

	public void setMenu_info(String menu_info) {
		this.menu_info = menu_info;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
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

	public int getMenu_category_num() {
		return menu_category_num;
	}

	public void setMenu_category_num(int menu_category_num) {
		this.menu_category_num = menu_category_num;
	}

	public int getMo_num() {
		return mo_num;
	}

	public void setMo_num(int mo_num) {
		this.mo_num = mo_num;
	}

	public String getMo_name() {
		return mo_name;
	}

	public void setMo_name(String mo_name) {
		this.mo_name = mo_name;
	}

	public int getMo_price() {
		return mo_price;
	}

	public void setMo_price(int mo_price) {
		this.mo_price = mo_price;
	}

	public String getMo_category() {
		return mo_category;
	}

	public void setMo_category(String mo_category) {
		this.mo_category = mo_category;
	}

	public int getMo_menu_num() {
		return mo_menu_num;
	}

	public void setMo_menu_num(int mo_menu_num) {
		this.mo_menu_num = mo_menu_num;
	}
}
