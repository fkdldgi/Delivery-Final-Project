package com.jhta.delivery.vo;

import java.util.List;

public class MenuVo {

	// 메뉴번호
	private int num;

	// 메뉴이름
	private String name;

	// 메뉴설명
	private String menu_info;

	// 가격
	private int price;

	// 상태 품절(0),판매중(1)
	private Integer status;

	// 메뉴사진
	private String img;

	// 메뉴카테고리번호
	private int menu_category_num;

	// 우선순위
	private int priority;
	
	//메뉴옵션 리스트
	private List<MenuOptionVo> menu_option_list;
	
	public MenuVo() {}

	public MenuVo(int num, String name, String menu_info, int price, Integer status, String img, int menu_category_num,
			int priority, List<MenuOptionVo> menu_option_list) {
		super();
		this.num = num;
		this.name = name;
		this.menu_info = menu_info;
		this.price = price;
		this.status = status;
		this.img = img;
		this.menu_category_num = menu_category_num;
		this.priority = priority;
		this.menu_option_list = menu_option_list;
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

	public String getMenu_info() {
		return menu_info;
	}

	public void setMenu_info(String menu_info) {
		this.menu_info = menu_info;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public List<MenuOptionVo> getMenu_option_list() {
		return menu_option_list;
	}

	public void setMenu_option_list(List<MenuOptionVo> menu_option_list) {
		this.menu_option_list = menu_option_list;
	}

	
}
