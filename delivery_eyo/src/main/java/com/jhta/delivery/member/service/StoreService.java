package com.jhta.delivery.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.delivery.member.dao.StoreDao;
import com.jhta.delivery.member.vo.MenuOptionVo;
import com.jhta.delivery.member.vo.MenuVo;

@Service
public class StoreService {
	@Autowired
	private StoreDao dao;
	
	//메인메뉴 리스트 받아오기
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
	
	//메뉴번호로 메뉴정보 가져오기
	public MenuVo menuInfo(int num) {
		return dao.menuInfo(num);
	}
	
	//메뉴번호로 옵션메뉴 가져오기
	public List<MenuOptionVo> optionInfo(int num){
		return dao.optionInfo(num);
	}
}
