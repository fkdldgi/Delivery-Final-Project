package com.jhta.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Order_MenuDao;
import com.jhta.delivery.vo.Order_MenuVo;

@Service
// �ֹ��޴�
public class Order_MenuService {
	@Autowired
	private Order_MenuDao dao;
	
	//�ֹ� �޴� �Էºκ�
	public int insert(Order_MenuVo vo) {
		return dao.insert(vo);
	}
}
