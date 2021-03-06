package com.jhta.delivery.owner.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.member.vo.MenuVo;
import com.jhta.delivery.owner.dao.Owner_StoreDao;

@Service
public class Owner_StoreService {
	@Autowired
	private Owner_StoreDao dao;
	
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
}
