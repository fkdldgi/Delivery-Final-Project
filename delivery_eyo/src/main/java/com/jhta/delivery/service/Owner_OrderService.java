package com.jhta.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.delivery.dao.Owner_OrderDao;
import com.jhta.delivery.vo.Owner_OrderVo;

@Service
// ���Կ��� �ֹ�Ȯ��
public class Owner_OrderService {
	@Autowired
	private Owner_OrderDao dao;
	
	// ���Կ��� �ֹ����� ���
	public List<Owner_OrderVo> owner_orderList(int num){
		return dao.owner_orderList(num);
	}
	
	// ���Կ��� �ֹ����� ����Ʈ
	public List<Owner_OrderVo> owner_successList(int num){
		return dao.owner_successList(num);
	}
	
}
