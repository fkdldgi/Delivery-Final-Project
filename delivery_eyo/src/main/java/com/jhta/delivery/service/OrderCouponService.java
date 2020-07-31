package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.OrderCouponDao;

@Service
public class OrderCouponService {
	@Autowired
	private OrderCouponDao dao;
	// 회원번호와 최소 가격으로 사용 가능한 쿠폰 리스트 가져오기
		public List<HashMap<String, Object>> useableCoupon(HashMap<String, Object> map){
			return dao.useableCoupon(map);
		}
}
