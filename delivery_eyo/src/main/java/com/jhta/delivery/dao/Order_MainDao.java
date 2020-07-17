package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Order_MainVo;

@Repository
// 주문
public class Order_MainDao {
	@Autowired
	private SqlSession session;
	String NAMESPACE = "mybatis.OrderMapper";
	
	//주문 입력 부분
	public int insert(Order_MainVo vo) {
		return session.insert(NAMESPACE+"Order_MainVo_insert", vo);
	}
	
}
