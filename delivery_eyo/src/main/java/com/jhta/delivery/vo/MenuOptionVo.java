package com.jhta.delivery.vo;

public class MenuOptionVo {
	// �޴��ɼ� 

	    // �ɼǹ�ȣ 
	    private int num;

	    // �ɼǸ� 
	    private String name;

	    // ���� 
	    private int price;

	    // ī�װ��� �ɼ��� ����(�⺻, �����߰�, ���߰�����)
	    private String category;

	    // �޴���ȣ 
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
