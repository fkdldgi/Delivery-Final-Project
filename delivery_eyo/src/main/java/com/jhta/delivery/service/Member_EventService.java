package com.jhta.delivery.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Member_EventDao;
import com.jhta.delivery.vo.Coupon_publishVo;

@Service
public class Member_EventService {
	@Autowired
	private Member_EventDao dao;
	public Coupon_publishVo selectcoupon(HashMap<String, Object> map) {
		return dao.selectcoupon(map);	
	}
}
