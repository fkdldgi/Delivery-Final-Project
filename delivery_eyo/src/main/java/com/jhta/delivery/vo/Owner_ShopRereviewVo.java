package com.jhta.delivery.vo;
public class Owner_ShopRereviewVo {
	
	// 기업회원 댓글 내용
	private String content;
	
	// 기업회원 댓글 날짜
	private String regdate;
	
	// 기업회원 댓글 그룹번호
	private int ref;
	
	// 가게번호
	private int shop_num;
	
	// 기업회원 번호
	private int owner_num;

	public Owner_ShopRereviewVo() {}

	public Owner_ShopRereviewVo(String content, String regdate, int ref, int shop_num, int owner_num) {
		this.content = content;
		this.regdate = regdate;
		this.ref = ref;
		this.shop_num = shop_num;
		this.owner_num = owner_num;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getShop_num() {
		return shop_num;
	}

	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}

	public int getOwner_num() {
		return owner_num;
	}

	public void setOwner_num(int owner_num) {
		this.owner_num = owner_num;
	}
}