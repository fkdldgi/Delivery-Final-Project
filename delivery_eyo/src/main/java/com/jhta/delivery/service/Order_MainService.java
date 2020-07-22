package com.jhta.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Order_MainDao;
import com.jhta.delivery.vo.Order_MainVo;

@Service
// 주문
public class Order_MainService {
	@Autowired
	private Order_MainDao dao;
	
	//주문 입력부분
	public int insert(Order_MainVo vo) {
		return dao.insert(vo);
	}
	
}
