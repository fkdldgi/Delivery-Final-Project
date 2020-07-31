package com.jhta.delivery.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.RiderDao;
import com.jhta.delivery.vo.RiderVo;

@Service
public class RiderService {
	@Autowired
	private RiderDao dao;
	//�α���
	public RiderVo selectOne(HashMap<String, Object> map) {
		return dao.selectOne(map);
	}
	// ȸ������
	public int insertRider(RiderVo vo) {
		return dao.insertRider(vo);
	}
	// ���̴����̵� Ȯ��
	public RiderVo RiderIdcheck(String id) {
		return dao.RiderIdcheck(id);
	}
	// ���̵�ã��
	public String RiderId(RiderVo vo) {
		return dao.RiderId(vo);
	}
	// ��й�ȣ ã��
	public String RiderPwd(RiderVo vo) {
		return dao.RiderPwd(vo);
	}
	// ���̴�����
	public RiderVo riderInfo(int num) {
		return dao.riderInfo(num);
	}
	// ���̴� �޸�
	public int riderDrop(int num) {
		return dao.riderDrop(num);
	}
	// ���̴� ��������
	public int riderUpdate(RiderVo vo) {
		return dao.riderUpdate(vo);
	}
}
