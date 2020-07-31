package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.MemberReviewDao;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Order_MainVo;
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
	
	// 가게번호로 리뷰 리스트 + 회원정보 + 사장님 댓글 가져오기 
	public List<HashMap<String, Object>> reviewAll(int shop_num){
		return dao.reviewAll(shop_num);
	}
	
	//고객번호와 가게번호를 받아 리뷰작성 조건 판단하기 
//	public String reviewAble(HashMap<String, Integer> map) {
//		return dao.reviewAble(map);
//	}
	
	//주문한 고객이 리뷰를 썼는지
//	public List<ReviewVo> selectMemberReview(HashMap<String, Integer> map){
//		return dao.selectMemberReview(map);
//	}
	
	//고객번호와 가게번호를 받아 리뷰작성 조건 판단하기 
	public List<Order_MainVo> reviewAble(HashMap<String, Integer> map) {
		return dao.reviewAble(map);
	}
	
	//멤버번호로 주문한 가게번호 가져오기
	public List<HashMap<String, Object>> getShopByMember(int member_num){
		return dao.getShopByMember(member_num);
	}
	
	// 리뷰 이미지 넣기
	public int review_imgInsert(HashMap<String, Object> map) {
		return dao.review_imgInsert(map);
	}
	
	// 리뷰 넣기 
	public int reviewInsert(HashMap<String, Object> map) {
		System.out.println("서비스의 review_img_num : " + map.get("review_img_num"));
		return dao.reviewInsert(map);
	} 
	
	// 리뷰 작성 후  ORDER_MAIN의 리뷰구분자 수정하기 
	public int updateReviewStatus(int num) {
		return dao.updateReviewStatus(num);
	}
	
	// 주문 번호와 고객번호로 고객이 주문한 메뉴 정보(이름) 가져오기
	public MenuVo getMenuNum(HashMap<String, Integer> map) {
		return dao.getMenuNum(map);
	}
	
}
