package com.jhta.delivery.owner.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.member.vo.MenuCategoryVo;
import com.jhta.delivery.member.vo.Menu_OptionVo;
import com.jhta.delivery.owner.dao.Owner_MenuDao;

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
}
