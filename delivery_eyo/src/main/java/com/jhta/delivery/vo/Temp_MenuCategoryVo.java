package com.jhta.delivery.vo;

import java.util.List;

public class Temp_MenuCategoryVo {
	private int category_num;
	private String menu_category_name;
	private int priority;
	private int shop_num;
	private int main_menu;
	private List<Temp_MenuVo> menu_list;
	public Temp_MenuCategoryVo() {
		super();
	}
	public Temp_MenuCategoryVo(int category_num, String menu_category_name, int priority, int shop_num, int main_menu,
			List<Temp_MenuVo> menu_list) {
		super();
		this.category_num = category_num;
		this.menu_category_name = menu_category_name;
		this.priority = priority;
		this.shop_num = shop_num;
		this.main_menu = main_menu;
		this.menu_list = menu_list;
	}
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	public String getMenu_category_name() {
		return menu_category_name;
	}
	public void setMenu_category_name(String menu_category_name) {
		this.menu_category_name = menu_category_name;
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
	public List<Temp_MenuVo> getMenu_list() {
		return menu_list;
	}
	public void setMenu_list(List<Temp_MenuVo> menu_list) {
		this.menu_list = menu_list;
	}
}
