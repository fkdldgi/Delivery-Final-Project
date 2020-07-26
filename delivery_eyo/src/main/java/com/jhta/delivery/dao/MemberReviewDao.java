package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.ReviewVo;
import com.jhta.delivery.vo.Review_ImgVo;

@Repository
public class MemberReviewDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="mybatis.Member_ReviewMapper";
	
	//가게번호로 가게 리뷰 리스트 가져오기
	public List<ReviewVo> shopReviewList(int shop_num) {
		return sqlSession.selectList(NAMESPACE+".shopReviewList", shop_num);
	}
	
	//가게 이미지 리스트 가져오기
	public List<Review_ImgVo> reviewImgList(){
		return sqlSession.selectList(NAMESPACE+".reviewImgList");
	}
	
	//고객번호와 가게번호를 받아 리뷰작성 조건 판단하기 
	public String reviewAble(HashMap<String, Integer> map) {
		return sqlSession.selectOne(NAMESPACE+".reviewAble", map);
	}
	
	//주문한 고객이 리뷰를 썼는지
	public List<ReviewVo> selectMemberReview(HashMap<String, Integer> map){
		System.out.println("dao map" + map);
		return sqlSession.selectList(NAMESPACE+".selectMemberReview", map);
	}
}
