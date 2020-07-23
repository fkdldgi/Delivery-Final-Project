package com.jhta.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.AddressDao;
import com.jhta.delivery.dao.ShopDao;
import com.jhta.delivery.vo.AddressVo;
import com.jhta.delivery.vo.ShopVo;

@Service
public class AddressService {
	@Autowired
	private AddressDao addrDao;

	@Transactional
	public int insert(AddressVo addrVo) {
		addrDao.insert(addrVo);
		return 1;
	}
}
