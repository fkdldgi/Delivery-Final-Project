package com.jhta.delivery.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.AddressDao;
import com.jhta.delivery.dao.ShopDao;
import com.jhta.delivery.vo.AddressVo;
import com.jhta.delivery.vo.ShopVo;

@Service
public class ShopService {
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AddressDao addrDao;
	
	@Transactional
	public int insert(ShopVo shopVo,AddressVo addrVo) {
		addrDao.insert(addrVo);
		shopDao.insert(shopVo);
		return 1;
	}
	public int basic_info_update(HashMap<String, Object> map) {
		return shopDao.basic_info_update(map);
	}
	public ShopVo selectShop(int num) {
		return shopDao.selectShop(num);
	}
}
