package com.jhta.delivery.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.AddressDao;
import com.jhta.delivery.dao.ShopDao;
import com.jhta.delivery.vo.AddressVo;
import com.jhta.delivery.vo.Delivery_LocationVo;
import com.jhta.delivery.vo.ShopVo;

@Service
public class ShopService {
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AddressDao addrDao;
	@Autowired
	private Delivery_LocationService del_locDao;
	
	//���Ե�� �� �ּҵ�� Ʈ�����
	@Transactional
	public int insert(ShopVo shopVo,AddressVo addrVo,Delivery_LocationVo del_locVo) {
		addrDao.insert(addrVo);
		shopDao.insert(shopVo);
		del_locDao.insert(del_locVo);
		return 1;
	}
	//�⺻���� ������Ʈ
	public int basic_info_update(HashMap<String, Object> map) {
		return shopDao.basic_info_update(map);
	}
	//����� ������Ʈ
	public int operation_info_update(HashMap<String, Object> map) {
		return shopDao.operation_info_update(map);
	}
	//�ּ��ֹ��ݾ� ������Ʈ
	public int min_price_update(HashMap<String, Object> map) {
		return shopDao.min_price_update(map);
	}
	public ShopVo selectShop(int num) {
		return shopDao.selectShop(num);
	}
}
