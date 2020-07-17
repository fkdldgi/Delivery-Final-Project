package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;

@Repository
public class OwnerDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.OwnerMapper";
	
	public int insert(OwnerVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	public OwnerVo selectOne(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".selectOne",map);
	}
	public OwnerVo idChk(String id) {
		return session.selectOne(NAMESPACE+".idchk",id);
	}
	public List<ShopVo> shop_list(String id){
		return session.selectList(NAMESPACE+".shop_list", id);
	}
	public ShopVo shop_select(int num) {
		return session.selectOne(NAMESPACE+".shop_select", num);
	}
}
