package com.jhta.delivery.vo;

public class MenuOptionVo {
	// 메뉴옵션 

	    // 옵션번호 
	    private int num;

	    // 옵션명 
	    private String name;

	    // 가격 
	    private int price;

	    // 카테고리명 옵션의 제목(기본, 토핑추가, 맛추가선택)
	    private String category;

	    // 메뉴번호 
	    private int menu_num;

	    public int getNum() {
	        return num;
	    }

	    public MenuOptionVo() {}	
	    
		public MenuOptionVo(int num, String name, int price, String category, int menu_num) {
			super();
			this.num = num;
			this.name = name;
			this.price = price;
			this.category = category;
			this.menu_num = menu_num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getMenu_num() {
			return menu_num;
		}

		public void setMenu_num(int menu_num) {
			this.menu_num = menu_num;
		}

		public void setNum(int num) {
			this.num = num;
		}

	   
}
