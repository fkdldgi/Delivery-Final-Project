package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.MemberReviewDao;
import com.jhta.delivery.vo.ReviewVo;
import com.jhta.delivery.vo.Review_ImgVo;

@Service
public class MemberReviewService {
	@Autowired
	private MemberReviewDao dao;
	
	//가게번호로 가게 리뷰 리스트 가져오기
	public List<ReviewVo> shopReviewList(int shop_num){
		return dao.shopReviewList(shop_num);
	}
	
	//리뷰 이미지 리스트 가져오기
	public List<Review_ImgVo> reviewImgList(){
		return dao.reviewImgList();
	}
	
	// 가게번호로 리뷰 리스트 + 회원 정보 가져오기
	public List<HashMap<String, Object>> review_member_list(int shop_num){
		return dao.review_member_list(shop_num);
	}
	
	//고객번호와 가게번호를 받아 리뷰작성 조건 판단하기 
	public String reviewAble(HashMap<String, Integer> map) {
		return dao.reviewAble(map);
	}
	
	//주문한 고객이 리뷰를 썼는지
	public List<ReviewVo> selectMemberReview(HashMap<String, Integer> map){
		System.out.println("서비스  map" + map);
		return dao.selectMemberReview(map);
	}
	
}
