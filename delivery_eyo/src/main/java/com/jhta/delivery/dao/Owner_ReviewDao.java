package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Owner_ReviewVo;

@Repository
public class Owner_ReviewDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="mybatis.Owner_ReviewMapper";
	
	// ¸®ºä¸®½ºÆ®
	public List<Owner_ReviewVo> ownerReviewList(int num){
		return session.selectList(NAMESPACE+".ReviewList", num);
	}	
}
