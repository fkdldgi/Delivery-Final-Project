package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCouponDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE = "mybatis.OrderMapper";
	
	// 회원번호와 최소 가격으로 사용 가능한 쿠폰 리스트 가져오기
	public List<HashMap<String, Object>> useableCoupon(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".useableCoupon", map);
	}
	
	// 발행쿠폰 번호와 회원번호로 상태와 주문번호 변경 (사용한 쿠폰으로 변경)
	public int updateCoupon(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".updateCoupon", map);
	}
}
