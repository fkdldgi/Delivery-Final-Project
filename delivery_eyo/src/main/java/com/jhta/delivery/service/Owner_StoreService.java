package com.jhta.delivery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.Owner_StoreDao;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Owner_CheckMenuVo;


@Service
public class Owner_StoreService {
	@Autowired
	private Owner_StoreDao dao;
	
	
	//메뉴카테고리,메뉴,메뉴옵션 추가 or 업데이트 트랜잭션
	@Transactional
	public int menuUpdateAndInsertTransaction(List<MenuCategoryVo> category_list){
		for(int i=0; i<category_list.size(); i++) {
			MenuCategoryVo categoryVo=category_list.get(i);
			int category_num=categoryVo.getNum();
			List<MenuVo> menu_list=categoryVo.getMenu_list();
			
			if(dao.select_menu_categoryOne(category_num)==null) { //해당번호의 메뉴카테고리가 존재하지 않을 경우 insert
				dao.insertMenu_Category(categoryVo); //메뉴카테고리 추가
				//새로운 카테고리에 메뉴 insert
				for(int j=0; j<menu_list.size(); j++) {
					MenuVo menuVo=menu_list.get(j);
					int menu_num=menuVo.getNum(); //메뉴번호
					List<MenuOptionVo> menu_option_list=menuVo.getMenu_option_list(); //메뉴옵션리스트
					dao.insertMenu_newCategory(menuVo);
				}
			}else { //해당번호의 메뉴카테고리가 존재 할 경우 update
				dao.updateMenu_Category(categoryVo);
				for(int j=0; j<menu_list.size(); j++) {
					MenuVo menuVo=menu_list.get(j);
					int menu_num=menuVo.getNum(); //메뉴번호
					List<MenuOptionVo> menu_option_list=menuVo.getMenu_option_list(); //메뉴옵션리스트
					if(dao.select_menuOne(menu_num)==null) { //해당번호의 메뉴가 존재하지 않을 경우 insert
						dao.insertMenu(menuVo);
					}else { //해당번호의 메뉴가 존재 할 경우 update
						dao.updateMenu(menuVo);
					}
				}
			}
			
		}
		return 1;
	}
	
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
	
	//메뉴카테고리 번호로 메뉴카테고리 정보 가져오기
	public MenuCategoryVo select_menu_categoryOne(int category_num) {
		return dao.select_menu_categoryOne(category_num);
	}
		
	//메뉴번호로 메뉴정보 가져오기
	public MenuVo select_menuOne(int menu_num) {
		return dao.select_menuOne(menu_num);
	}
	
	//메뉴옵션번호로 메뉴옵션정보 가져오기
	public MenuOptionVo select_menu_optionOne(int option_num) {
		return dao.select_menu_optionOne(option_num);
	}
}