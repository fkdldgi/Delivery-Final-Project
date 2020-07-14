package com.jhta.delivery.member.vo;

public class MenuCategoryVo {
	// 메뉴카테고리(대표메뉴,세트메뉴,치킨메뉴 등)

	// 카테고리번호
	private int num;

	// 카테고리명
	private String name;

	// 우선순위
	private int priority;

	// 가게번호
	private int shop_num;

	// 대표메뉴
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
