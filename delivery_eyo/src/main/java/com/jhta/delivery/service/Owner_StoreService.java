package com.jhta.delivery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Owner_StoreDao;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Owner_CheckMenuVo;

@Service
public class Owner_StoreService {
	@Autowired
	private Owner_StoreDao dao;
	
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
	
	// 메뉴삭제
	public int deleteMenu(int num) {
		return dao.deleteMenu(num);
	}
	
	// 메뉴카테고리삭제
	public int deleteMenu_Category(int num) {
		return dao.deleteMenu_Category(num);
	}
	
	// 메뉴추가
	public int insertMenu(MenuVo vo){
		return dao.insertMenu(vo);
	}
	
	// 메뉴카테고리 추가
	public int insertMenu_Category(MenuCategoryVo vo) {
		return dao.insertMenu_Category(vo);
	}

	// 메뉴 수정
	public int updateMenu(MenuVo vo) {
		return dao.updateMenu(vo);
	}
	
	// 메뉴카테고리수정
	public int updateMenu_Category(MenuCategoryVo vo) {
		return dao.updateMenu_Category(vo);
	}
	
	// 메뉴카테고리번호 찾기
	public int selectMenu_CategoryNum(MenuCategoryVo vo) {
		return dao.selectMenu_CategoryNum(vo);
	}
	
	// 메뉴옵션
	public List<MenuOptionVo> menu_optionList(){
		return dao.menu_optionList();
	}
	
	// 메뉴옵션 추가
	public int insert_menu_option(MenuOptionVo vo) {
		return dao.insert_menu_option(vo);
	}
	
	// 메뉴옵션 수정
	public int update_menu_option(MenuOptionVo vo) {
		return dao.update_menu_option(vo);
	}
	
	// 메뉴옵션 삭제
	public int delete_menu_option(int num) {
		return dao.delete_menu_option(num);
	}
	
	// 가게가 가진 메뉴카테고리, 메뉴, 메뉴옵션
	public List<Owner_CheckMenuVo> checkMenuList(int num){
		return dao.checkMenuList(num);
	}
	
	// 메뉴카테고리 추가&수정
	public int insertUpdate_MenuCategory(MenuCategoryVo vo) {
		return dao.insertUpdate_MenuCategory(vo);
	}
	
	// 메뉴 추가&수정
	public int insertUpdate_Menu(MenuVo vo) {
		return dao.insertUpdate_Menu(vo);
	}
	
	// 메뉴옵션 추가&수정
	public int insertUpdate_MenuOption(MenuOptionVo vo) {
		return dao.insertUpdate_MenuOption(vo);
	}
}