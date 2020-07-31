package com.jhta.delivery.vo;

import java.util.List;

public class Temp_MenuOptionVo {
	private int option_num;
	private String option_name;
	private int option_price;
	private String option_categoty;
	private int option_menu_num;
	
	public Temp_MenuOptionVo() {
		super();
	}

	public Temp_MenuOptionVo(int option_num, String option_name, int option_price, String option_categoty,
			int option_menu_num) {
		super();
		this.option_num = option_num;
		this.option_name = option_name;
		this.option_price = option_price;
		this.option_categoty = option_categoty;
		this.option_menu_num = option_menu_num;
	}

	public int getOption_num() {
		return option_num;
	}

	public void setOption_num(int option_num) {
		this.option_num = option_num;
	}

	public String getOption_name() {
		return option_name;
	}

	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}

	public int getOption_price() {
		return option_price;
	}

	public void setOption_price(int option_price) {
		this.option_price = option_price;
	}

	public String getOption_categoty() {
		return option_categoty;
	}

	public void setOption_categoty(String option_categoty) {
		this.option_categoty = option_categoty;
	}

	public int getOption_menu_num() {
		return option_menu_num;
	}

	public void setOption_menu_num(int option_menu_num) {
		this.option_menu_num = option_menu_num;
	}
	
}
