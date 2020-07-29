package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Order_MainVo;
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
	
	// 가게번호로 리뷰 리스트 + 회원 정보 가져오기
	public List<HashMap<String, Object>> review_member_list(int shop_num){
		return sqlSession.selectList(NAMESPACE+".review_member_list", shop_num);
	}
	
	//고객번호와 가게번호를 받아 리뷰작성 조건 판단하기 
	public List<Order_MainVo> reviewAble(HashMap<String, Integer> map) {
		return sqlSession.selectList(NAMESPACE+".reviewAble", map);
	}
	
	//주문한 고객이 리뷰를 썼는지
	public List<ReviewVo> selectMemberReview(HashMap<String, Integer> map){
		return sqlSession.selectList(NAMESPACE+".selectMemberReview", map);
	}
	
	//멤버번호로 주문한 가게번호 가져오기
	public List<HashMap<String, Object>> getShopByMember(int member_num){
		return sqlSession.selectList(NAMESPACE+".getShopByMember", member_num);
	}
	
	// 리뷰 이미지 넣기
	public int review_imgInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".review_imgInsert", map);
	}
	
	// 리뷰 넣기 
	public int reviewInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".reviewInsert", map);
	} 
	
	// 리뷰 작성 후  ORDER_MAIN의 리뷰구분자 수정하기 
	public int updateReviewStatus(int num) {
		return sqlSession.update(NAMESPACE+".updateReviewStatus", num);
	}
	
	// 주문 번호와 고객번호로 고객이 주문한 메뉴 정보(이름) 가져오기
	public MenuVo getMenuNum(HashMap<String, Integer> map) {
		return sqlSession.selectOne(NAMESPACE+".getMenuNum", map);
	}
}
