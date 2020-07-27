package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Delivery_LocationVo;

@Repository
public class Delivery_LocationDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.Delivery_LocationMapper";
	
	//��ް��������߰�
	public int insert(Delivery_LocationVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
}
