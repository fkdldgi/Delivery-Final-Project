package com.jhta.delivery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Owner_StoreDao;
import com.jhta.delivery.vo.MenuVo;

@Service
public class Owner_StoreService {
	@Autowired
	private Owner_StoreDao dao;
	
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
	
	// 메뉴삭제하기
	public int deleteMenu(int num) {
		return dao.deleteMenu(num);
	}
}
