package com.jhta.delivery.vo;

// �޴����� �ִ��� ������ Ȯ��
public class Owner_CheckMenuVo {
	
	// �޴�ī�װ� ��ȣ
	private int mc_num;
	
	// �޴�ī�װ� �̸�
	private String mc_name;
	
	// �޴���ȣ
	private int mm_num;
	
	// �޴��̸�
	private String mm_name;
	
	// �޴�����
	private String mm_info;
	
	// �޴�����
	private int mm_price;
	
	// �޴� �̹���
	private String mm_img;
	
	// �޴��� ���� ī�װ� ��ȣ
	private int mm_category;
	
	// �޴��ɼ� ��ȣ
	private int mo_num;
	
	// �޴��ɼ� �̸�
	private String mo_name;
	
	// �޴��ɼ� ����
	private int mo_price;
	
	// �޴��ɼ� ī�װ�
	private String mo_category;
	
	// �޴��ɼ��� ���� �޴���ȣ
	private int mo_menu_num;
	
	public Owner_CheckMenuVo() {}

	public Owner_CheckMenuVo(int mc_num, String mc_name, int mm_num, String mm_name, String mm_info, int mm_price,
			String mm_img, int mm_category, int mo_num, String mo_name, int mo_price, String mo_category,
			int mo_menu_num) {
		this.mc_num = mc_num;
		this.mc_name = mc_name;
		this.mm_num = mm_num;
		this.mm_name = mm_name;
		this.mm_info = mm_info;
		this.mm_price = mm_price;
		this.mm_img = mm_img;
		this.mm_category = mm_category;
		this.mo_num = mo_num;
		this.mo_name = mo_name;
		this.mo_price = mo_price;
		this.mo_category = mo_category;
		this.mo_menu_num = mo_menu_num;
	}

	public int getMc_num() {
		return mc_num;
	}

	public void setMc_num(int mc_num) {
		this.mc_num = mc_num;
	}

	public String getMc_name() {
		return mc_name;
	}

	public void setMc_name(String mc_name) {
		this.mc_name = mc_name;
	}

	public int getMm_num() {
		return mm_num;
	}

	public void setMm_num(int mm_num) {
		this.mm_num = mm_num;
	}

	public String getMm_name() {
		return mm_name;
	}

	public void setMm_name(String mm_name) {
		this.mm_name = mm_name;
	}

	public String getMm_info() {
		return mm_info;
	}

	public void setMm_info(String mm_info) {
		this.mm_info = mm_info;
	}

	public int getMm_price() {
		return mm_price;
	}

	public void setMm_price(int mm_price) {
		this.mm_price = mm_price;
	}

	public String getMm_img() {
		return mm_img;
	}

	public void setMm_img(String mm_img) {
		this.mm_img = mm_img;
	}

	public int getMm_category() {
		return mm_category;
	}

	public void setMm_category(int mm_category) {
		this.mm_category = mm_category;
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
