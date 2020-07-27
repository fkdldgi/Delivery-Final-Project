package com.jhta.delivery.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.ShopVo;

@Repository
public class ShopDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.ShopMapper";
	
	//가게등록
	public int insert(ShopVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//기본정보 업데이트
	public int basic_info_update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".basicinfo_update",map);
	}
	//운영정보 업데이트
	public int operation_info_update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".operationinfo_update",map);
	}
	//가게번호로 가게정보얻어오기
	public ShopVo selectShop(int num) {
		return session.selectOne(NAMESPACE+".selectShop",num);
	}
}
