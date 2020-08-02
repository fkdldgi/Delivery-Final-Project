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
		System.out.println(category_list.size()+"카테고리 사이즈");
		
		for(int i=0; i<category_list.size(); i++) {
			MenuCategoryVo categoryVo=category_list.get(i);
			int category_num=categoryVo.getNum();
			System.out.println(category_num+"카테고리 번호");
			List<MenuVo> menu_list=categoryVo.getMenu_list();
			System.out.println(dao.select_menu_categoryOne(category_num)+"메뉴카테고리 검사");
			System.out.println(menu_list.size()+"메뉴사이즈");
			if(dao.select_menu_categoryOne(category_num)==null) { //해당번호의 메뉴카테고리가 존재하지 않을 경우 insert
				//새로운 카테고리에 메뉴 insert
				dao.insertMenu_Category(categoryVo); //메뉴카테고리 추가
				for(int j=0; j<menu_list.size(); j++) {
					MenuVo menuVo=menu_list.get(j);
					System.out.println(menuVo.getNum()+"메뉴번호");
					System.out.println(menuVo.getName()+"메뉴이름");
					List<MenuOptionVo> menu_option_list=menuVo.getMenu_option_list(); //메뉴옵션리스트
					dao.insertMenu_newCategory(menuVo); //메뉴카테고리 추가
					for(int k=0; k<menu_option_list.size(); k++) { //새로운 메뉴옵션 리스트 insert
						MenuOptionVo menu_optionVo=menu_option_list.get(k); //메뉴옵션 리스트
						dao.insert_menu_option_newMenu(menu_optionVo); //새로운 메뉴에 옵션추가
					}
				}
			}else { //해당번호의 메뉴카테고리가 존재 할 경우 update
				dao.updateMenu_Category(categoryVo);
				for(int j=0; j<menu_list.size(); j++) { //메뉴 수 만큼 반복
					MenuVo menuVo=menu_list.get(j);
					System.out.println(menuVo.getNum()+"이미있는 카테고리 메뉴번호");
					System.out.println(menuVo.getName()+"이미있는 카테고리 메뉴이름");
					int menu_num=menuVo.getNum(); //메뉴번호
					List<MenuOptionVo> menu_option_list=menuVo.getMenu_option_list(); //메뉴옵션리스트
					if(dao.select_menuOne(menu_num)==null) { //해당번호의 메뉴가 존재하지 않을 경우 insert
						dao.insertMenu(menuVo);
						for(int k=0; k<menu_option_list.size(); k++) { //새로운 메뉴옵션 리스트 insert
							MenuOptionVo menu_optionVo=menu_option_list.get(k);
							dao.insert_menu_option_newMenu(menu_optionVo); //새로운 메뉴에 옵션추가
						}
					}else { //해당번호의 메뉴가 존재 할 경우 update
						dao.updateMenu(menuVo);
						for(int k=0; k<menu_option_list.size(); k++) { //기존 메뉴옵션 리스트 update
							MenuOptionVo menu_optionVo=menu_option_list.get(k);
							int menu_option_num=menu_optionVo.getNum(); //메뉴옵션 번호
							if(dao.select_menu_optionOne(menu_option_num)==null) { // 메뉴 옵션번호가 존재하지 않을 경우 insert
								System.out.println(dao.select_menu_optionOne(menu_option_num));
								dao.insert_menu_option(menu_optionVo); //기존 메뉴에 옵션추가
							}else {
								System.out.println(dao.select_menu_optionOne(menu_option_num));
								dao.update_menu_option(menu_optionVo); //기존 메뉴에 옵션수정
							}
						}
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