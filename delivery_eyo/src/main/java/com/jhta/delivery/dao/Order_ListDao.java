package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class Order_ListDao {
	@Autowired
	private SqlSessionTemplate session;
	private final String NAMESPACE="mybatis.OrderListMapper";
	
	public List<HashMap<String, Object>> OrderList(int memberNum){
		return session.selectList(NAMESPACE+".orderList", memberNum);
	}
}
