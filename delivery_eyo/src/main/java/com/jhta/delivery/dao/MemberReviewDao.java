package com.jhta.delivery.dao;

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
}
