package com.jhta.delivery.vo;

// �����̹��� 
public class Review_ImgVo {

	// �̹�����ȣ
	private int num;

	// �̹������
	private String img_path;

	// �������ϸ�
	private String original_filename;

	// ���̺����ϸ�
	private String save_filename;

	Review_ImgVo() {}

	public Review_ImgVo(int num, String img_path, String original_filename, String save_filename) {
		super();
		this.num = num;
		this.img_path = img_path;
		this.original_filename = original_filename;
		this.save_filename = save_filename;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getOriginal_filename() {
		return original_filename;
	}

	public void setOriginal_filename(String original_filename) {
		this.original_filename = original_filename;
	}

	public String getSave_filename() {
		return save_filename;
	}

	public void setSave_filename(String save_filename) {
		this.save_filename = save_filename;
	}
}
