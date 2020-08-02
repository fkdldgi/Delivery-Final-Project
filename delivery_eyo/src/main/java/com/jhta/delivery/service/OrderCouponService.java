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
	// ȸ����ȣ�� �ּ� �������� ��� ������ ���� ����Ʈ ��������
		public List<HashMap<String, Object>> useableCoupon(HashMap<String, Object> map){
			return dao.useableCoupon(map);
		}
}
