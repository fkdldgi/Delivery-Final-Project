package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Order_MainVo;
import com.jhta.delivery.vo.Owner_OrderVo;

@Repository
// 주문
public class Owner_OrderDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.Owner_OrderMapper";
	
	// 가게에서 주문요청 리스트
	public List<Owner_OrderVo> owner_orderList(int num){
		return session.selectList(NAMESPACE+".Owner_OrderList", num);
	}
	
	// 가게에서 주문승인 리스트
	public List<Owner_OrderVo> owner_successList(int num){
		return session.selectList(NAMESPACE+".Owner_SuccessList", num);
	}
	
	// 가게에서 주문 승인
	public int update_end_ex_time(Owner_OrderVo vo) {
		return session.update(NAMESPACE+".Owner_UpdateTime", vo);
	}
}
