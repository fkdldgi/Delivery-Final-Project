package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Owner_CheckMenuVo;

@Repository
public class Owner_StoreDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="mybatis.Owner_StoreMapper";
	
	// 메뉴리스트
	public List<MenuVo> mainMenuList(int num){
		return session.selectList(NAMESPACE+".mainMenuList", num);
	}
	
	// 메뉴삭제
	public int deleteMenu(int num) {
		return session.delete(NAMESPACE+".deleteMenu", num);
	}
	
	// 메뉴카테고리삭제
	public int deleteMenu_Category(int num) {
		return session.delete(NAMESPACE+".deleteMenu_Category", num);
	}
	
	// 메뉴추가(기존 카테고리리에 추가하는 경우)
	public int insertMenu(MenuVo vo) {
		return session.insert(NAMESPACE+".insertMenu", vo);
	}
	
	// 메뉴 추가 (새로운 카테고리에 추가하는 경우)
	public int insertMenu_newCategory(MenuVo vo) {
		return session.insert(NAMESPACE+".insertMenu_newCategory",vo);
	}
	
	// 메뉴카테고리 추가
	public int insertMenu_Category(MenuCategoryVo vo) {
		return session.insert(NAMESPACE+".insertMenu_Category", vo);
	}
	
	// 메뉴수정
	public int updateMenu(MenuVo vo) {
		return session.update(NAMESPACE+".updateMenu", vo);
	}
	
	// 메뉴카테고리수정
	public int updateMenu_Category(MenuCategoryVo vo) {
		return session.update(NAMESPACE+".updateMenu_Category", vo);
	}
	
	// 메뉴카테고리번호 찾기
	public int selectMenu_CategoryNum(MenuCategoryVo vo) {
		return session.selectOne(NAMESPACE+".selectMenu_CategoryNum", vo);
	}
	
	// 메뉴옵션
	public List<MenuOptionVo> menu_optionList(){
		return session.selectList(NAMESPACE+".select_menu_option");
	}
	
	// 메뉴옵션 추가(기존 메뉴에 옵션 추가)
	public int insert_menu_option(MenuOptionVo vo) {
		return session.insert(NAMESPACE+".insert_menu_option", vo);
	}
	// 메뉴옵션 추가(새로운 메뉴에 옵션 추가)
	public int insert_menu_option_newMenu(MenuOptionVo vo) {
		return session.insert(NAMESPACE+".insert_menu_option_newMenu", vo);
	}
	
	// 메뉴옵션 수정
	public int update_menu_option(MenuOptionVo vo) {
		return session.update(NAMESPACE+".update_menu_option",vo);
	}
	
	// 메뉴옵션 삭제
	public int delete_menu_option(int num) {
		return session.delete(NAMESPACE+".delete_menu_option", num);
	}
	
	// 가게가 가진 메뉴카테고리, 메뉴, 메뉴옵션
	public List<Owner_CheckMenuVo> checkMenuList(int num){
		return session.selectList(NAMESPACE+".select_menuAll", num);
	}
	
	// 메뉴카테고리 추가& 수정
	public int insertUpdate_MenuCategory(MenuCategoryVo vo) {
		return session.insert(NAMESPACE+".insertUpdate_Menu_category", vo);
	}
	
	// 메뉴 추가&수정
	public int insertUpdate_Menu(MenuVo vo) {
		return session.insert(NAMESPACE+".insertUpdate_Menu", vo);
	}
	
	// 메뉴옵션 추가&수정
	public int insertUpdate_MenuOption(MenuOptionVo vo) {
		return session.insert(NAMESPACE+".insertUpdate_MenuOption", vo);
	}
	
	//메뉴카테고리 번호로 메뉴카테고리 정보 가져오기
	public MenuCategoryVo select_menu_categoryOne(int category_num) {
		return session.selectOne(NAMESPACE+".select_menu_categoryOne",category_num);
	}
	
	//메뉴번호로 메뉴정보 가져오기
	public MenuVo select_menuOne(int menu_num) {
		return session.selectOne(NAMESPACE+".select_menuOne",menu_num);
	}
	
	//메뉴옵션번호로 메뉴옵션정보 가져오기
	public MenuOptionVo select_menu_optionOne(int option_num) {
		return session.selectOne(NAMESPACE+".select_menu_optionOne",option_num);
	}
	
}








