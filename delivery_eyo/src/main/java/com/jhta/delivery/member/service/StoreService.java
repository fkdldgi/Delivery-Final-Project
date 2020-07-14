package com.jhta.delivery.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.delivery.member.dao.StoreDao;
import com.jhta.delivery.member.vo.MenuVo;

@Service
public class StoreService {
	@Autowired
	private StoreDao dao;
	
	//메인메뉴 리스트 받아오기
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
}
