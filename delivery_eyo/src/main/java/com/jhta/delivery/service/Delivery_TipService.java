package com.jhta.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Delivery_TipDao;
import com.jhta.delivery.vo.Delivery_TipVo;

@Service
public class Delivery_TipService {
	@Autowired
	private Delivery_TipDao dao;
	
	//����� �߰�
	public int insert(Delivery_TipVo vo) {
		return dao.insert(vo);
	}
	//���Թ�ȣ�� ����������� ������
	public List<Delivery_TipVo> selectTip(int shopNum){
		return dao.selectTip(shopNum);
	}
}
