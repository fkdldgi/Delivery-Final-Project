package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Order_ListDao;

@Service
public class OrderListService {
	@Autowired
	private Order_ListDao dao;
	public List<HashMap<String, Object>> OrderList(int memberNum) {
		return dao.OrderList(memberNum);
		
	}
}
