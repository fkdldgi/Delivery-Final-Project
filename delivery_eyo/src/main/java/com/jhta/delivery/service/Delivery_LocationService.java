package com.jhta.delivery.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.Delivery_LocationDao;
import com.jhta.delivery.vo.Delivery_LocationVo;

@Service
public class Delivery_LocationService {
	@Autowired
	private Delivery_LocationDao del_locDao;
	
	//��ް������� �߰�
	public int insert(Delivery_LocationVo vo) {
		return del_locDao.insert(vo);
	}
	//���Թ�ȣ�� ������� ������
	public Delivery_LocationVo selectLoc(int num) {
		return del_locDao.selectLoc(num);
	}
	//������� ����
	public int delete(int num) {
		return del_locDao.delete(num);
	}
	//������ ������Ʈ
	public int update(HashMap<String, Object> map) {
		return del_locDao.update(map);
	}
	//
	@Transactional
	public void deliveryUpdate(HashMap<String,Object> map) throws Exception{
		del_locDao.delete((int)map.get("num"));
		del_locDao.reInsert(map);
	}
}
