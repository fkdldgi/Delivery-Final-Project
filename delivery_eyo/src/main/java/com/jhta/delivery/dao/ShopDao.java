package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.ShopVo;

@Repository
public class ShopDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.ShopMapper";
	
	public int insert(ShopVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
}
