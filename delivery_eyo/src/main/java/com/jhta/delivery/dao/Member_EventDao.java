package com.jhta.delivery.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Coupon_publishVo;

@Repository
public class Member_EventDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.EventMapper";
	
	public Coupon_publishVo selectcoupon(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".couponchk", map);
	}
}
