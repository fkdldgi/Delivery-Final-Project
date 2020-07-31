package com.jhta.delivery.vo;

import java.util.List;

public class Temp_MenuVo {
	private int menu_num;
	private String menu_name;
	private String menu_info;
	private int menu_price;
	private int status;
	private String img;
	private int category_list_num;
	private int priority;
	private List<Temp_MenuOptionVo> menu_option_list;
	public Temp_MenuVo() {
		super();
	}
	public Temp_MenuVo(int menu_num, String menu_name, String menu_info, int menu_price, int status, String img,
			int category_list_num, int priority, List<Temp_MenuOptionVo> menu_option_list) {
		super();
		this.menu_num = menu_num;
		this.menu_name = menu_name;
		this.menu_info = menu_info;
		this.menu_price = menu_price;
		this.status = status;
		this.img = img;
		this.category_list_num = category_list_num;
		this.priority = priority;
		this.menu_option_list = menu_option_list;
	}
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
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
	public int getCategory_list_num() {
		return category_list_num;
	}
	public void setCategory_list_num(int category_list_num) {
		this.category_list_num = category_list_num;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public List<Temp_MenuOptionVo> getMenu_option_list() {
		return menu_option_list;
	}
	public void setMenu_option_list(List<Temp_MenuOptionVo> menu_option_list) {
		this.menu_option_list = menu_option_list;
	}
	
	
	
}
