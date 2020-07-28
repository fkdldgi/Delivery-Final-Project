package com.jhta.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Delivery_LocationDao;
import com.jhta.delivery.vo.Delivery_LocationVo;

@Service
public class Delivery_LocationService {
	@Autowired
	private Delivery_LocationDao dao;
	
	//��ް������� �߰�
	public int insert(Delivery_LocationVo vo) {
		return dao.insert(vo);
	}
	//���Թ�ȣ�� ������� ������
	public Delivery_LocationVo selectLoc(int num) {
		return dao.selectLoc(num);
	}
}
