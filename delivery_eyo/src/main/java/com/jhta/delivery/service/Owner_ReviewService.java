package com.jhta.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Owner_ReviewDao;
import com.jhta.delivery.vo.Owner_ShopRereviewVo;
import com.jhta.delivery.vo.Owner_ShopReviewVo;

@Service
public class Owner_ReviewService {
	@Autowired
	private Owner_ReviewDao dao;
	
	// 가게리뷰 전체 & 리뷰단 일반회원
	public List<Owner_ShopReviewVo> shopReview(int num){
		return dao.shopReview(num);
	}
	
	// 기업회원 대댓글 전체
	public List<Owner_ShopRereviewVo> shopRereview(int num){
		return dao.shopRereview(num);
	}
	
	// 기업회원 댓글 넣기
	public int insert_OwnerRereview(Owner_ShopRereviewVo vo) {
		return dao.insert_OwnerReview(vo);
	}
}