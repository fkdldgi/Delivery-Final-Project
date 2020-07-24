package com.jhta.delivery.vo;

//  가게에서 주문관리 확인
public class Owner_OrderVo {

	// 주문 번호
	private int main_num;
	
	// 주문시간
	private String start_time;
	
	// 도착예정시간
	private String end_ex_time;
	
	// 주문상태
	private String status;
	
	// 요청사항
	private String owner_requests;
	
	// 총결제금액
	private int total_price;
	
	// 주문금액
	private int order_price;
	
	// 주문메뉴 개수
	private int count;
	
	// 메뉴이름
	private String menu_name;
	
	// 메뉴가격
	private int price;
	
	// 메뉴옵션명
	private String menu_option_name;
	
	// 배달주소
	private String addr_num;
	
	// 배달 상세
	private String addr_detail;
	
	public Owner_OrderVo() {}

	public Owner_OrderVo(int main_num,String start_time, String end_ex_time, String status, String owner_requests, int total_price, String addr_num, String addr_detail,
			int order_price, int count, String menu_name, int price, String menu_option_name) {
		this.addr_num = addr_num;
		this.addr_detail = addr_detail;
		this.main_num = main_num;
		this.start_time = start_time;
		this.end_ex_time = end_ex_time;
		this.status = status;
		this.owner_requests = owner_requests;
		this.total_price = total_price;
		this.order_price = order_price;
		this.count = count;
		this.menu_name = menu_name;
		this.price = price;
		this.menu_option_name = menu_option_name;
	}
		
	public String getAddr_num() {
		return addr_num;
	}

	public void setAddr_num(String addr_num) {
		this.addr_num = addr_num;
	}

	public String getAddr_detail() {
		return addr_detail;
	}

	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}

	public int getMain_num() {
		return main_num;
	}

	public void setMain_num(int main_num) {
		this.main_num = main_num;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_ex_time() {
		return end_ex_time;
	}

	public void setEnd_ex_time(String end_ex_time) {
		this.end_ex_time = end_ex_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwner_requests() {
		return owner_requests;
	}

	public void setOwner_requests(String owner_requests) {
		this.owner_requests = owner_requests;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMenu_option_name() {
		return menu_option_name;
	}

	public void setMenu_option_name(String menu_option_name) {
		this.menu_option_name = menu_option_name;
	}
	
	
}
