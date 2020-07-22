package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Owner_ShopReviewVo;

@Repository
public class Owner_ReviewDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="mybatis.Owner_ReviewMapper";
	
	// 가게리뷰 전체 & 리뷰단 일반회원
	public List<Owner_ShopReviewVo> shopReview(int num){
		return session.selectList(NAMESPACE+".ShopReview", num);
	}
}
