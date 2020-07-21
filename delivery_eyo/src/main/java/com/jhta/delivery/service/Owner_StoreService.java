package com.jhta.delivery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Owner_StoreDao;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuVo;

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
	
	// 메뉴카테고리수정
	public int updateMenu_Category(MenuCategoryVo vo) {
		return dao.updateMenu_Category(vo);
	}
	
	// 메뉴카테고리 넣기
	public int insertMenu_Category(MenuCategoryVo vo) {
		return dao.insertMenu_Category(vo);
	}
}