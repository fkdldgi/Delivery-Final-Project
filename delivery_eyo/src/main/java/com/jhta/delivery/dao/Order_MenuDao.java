package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Order_MainVo;
import com.jhta.delivery.vo.Order_MenuVo;

@Repository
// 주문메뉴
public class Order_MenuDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.OrderMapper";
	
	//주문메뉴 입력 부분
	public int insert(Order_MenuVo vo) {
			return session.insert(NAMESPACE+"Order_Menu_insert", vo);
	}
}
