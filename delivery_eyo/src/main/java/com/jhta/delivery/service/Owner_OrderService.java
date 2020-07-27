package com.jhta.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.delivery.dao.Owner_OrderDao;
import com.jhta.delivery.vo.Owner_OrderVo;

@Service
// 가게에서 주문확인
public class Owner_OrderService {
	@Autowired
	private Owner_OrderDao dao;
	
	// 가게에서 주문받은 목록
	public List<Owner_OrderVo> owner_orderList(int num){
		return dao.owner_orderList(num);
	}
	
	// 가게에서 주문승인 리스트
	public List<Owner_OrderVo> owner_successList(int num){
		return dao.owner_successList(num);
	}
	
}
