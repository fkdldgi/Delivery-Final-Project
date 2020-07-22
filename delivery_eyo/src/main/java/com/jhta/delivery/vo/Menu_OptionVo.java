package com.jhta.delivery.vo;
public class Menu_OptionVo {

	// 메뉴옵션 번호
	private int Menu_Option_num;
	
	// 메뉴옵션 이름
	private String Menu_Option_name;
	
	// 메뉴옵션 가격
	private int Menu_Option_price;
	
	// 메뉴옵션 카테고리명
	private String Menu_Option_category;
	
	// 메뉴옵션 메뉴번호
	private int Menu_Option_menu_num;
	
	public Menu_OptionVo() {}

	public Menu_OptionVo(int menu_Option_num, String menu_Option_name, int menu_Option_price,
			String menu_Option_category, int menu_Option_menu_num) {
		Menu_Option_num = menu_Option_num;
		Menu_Option_name = menu_Option_name;
		Menu_Option_price = menu_Option_price;
		Menu_Option_category = menu_Option_category;
		Menu_Option_menu_num = menu_Option_menu_num;
	}

	public int getMenu_Option_num() {
		return Menu_Option_num;
	}

	public void setMenu_Option_num(int menu_Option_num) {
		Menu_Option_num = menu_Option_num;
	}

	public String getMenu_Option_name() {
		return Menu_Option_name;
	}

	public void setMenu_Option_name(String menu_Option_name) {
		Menu_Option_name = menu_Option_name;
	}

	public int getMenu_Option_price() {
		return Menu_Option_price;
	}

	public void setMenu_Option_price(int menu_Option_price) {
		Menu_Option_price = menu_Option_price;
	}

	public String getMenu_Option_category() {
		return Menu_Option_category;
	}

	public void setMenu_Option_category(String menu_Option_category) {
		Menu_Option_category = menu_Option_category;
	}

	public int getMenu_Option_menu_num() {
		return Menu_Option_menu_num;
	}

	public void setMenu_Option_menu_num(int menu_Option_menu_num) {
		Menu_Option_menu_num = menu_Option_menu_num;
	}
	
	
	
}