package com.jhta.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.dao.Order_Menu_OptionDao;
import com.jhta.delivery.vo.Order_Menu_OptionVo;

@Repository
// 주문메뉴옵션 
public class Order_Menu_OptionService {
	@Autowired
	private Order_Menu_OptionDao dao;
	
	//주문 메뉴 옵션 입력부분
	public int insert(Order_Menu_OptionVo vo) {
		return dao.insert(vo);
	}
}
