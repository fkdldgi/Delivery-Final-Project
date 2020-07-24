package com.jhta.delivery.service;

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
}
