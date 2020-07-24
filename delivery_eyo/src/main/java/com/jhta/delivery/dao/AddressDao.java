package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.AddressVo;

@Repository
public class AddressDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.AddressMapper";
	
	public int insert(AddressVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public AddressVo selectByBuildingcode(String buildingCode) {
		return session.selectOne(NAMESPACE+".selectByBuildingcode", buildingCode);
	}
}
