package com.jhta.delivery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Owner_MenuDao;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Menu_OptionVo;

@Service
public class Owner_MenuService {
	@Autowired
	private Owner_MenuDao dao;
	
	public List<MenuCategoryVo> menuCategory(int num){
		return dao.menuCategory(num);
	}
	
	public List<Menu_OptionVo> menuOption(int num){
		return dao.menuOption(num);
	}
	
	public List<Menu_OptionVo> ShopNum_MenuOption(int num){
		return dao.ShopNum_MenuOption(num);
	}
	
	public List<MenuVo> menu(int num){
		return dao.menu(num);
	}
}
