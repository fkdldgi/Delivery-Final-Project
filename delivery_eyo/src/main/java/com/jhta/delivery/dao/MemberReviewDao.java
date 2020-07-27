package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

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
	
	//���Թ�ȣ�� ���� ���� ����Ʈ ��������
	public List<ReviewVo> shopReviewList(int shop_num) {
		return sqlSession.selectList(NAMESPACE+".shopReviewList", shop_num);
	}
	
	//���� �̹��� ����Ʈ ��������
	public List<Review_ImgVo> reviewImgList(){
		return sqlSession.selectList(NAMESPACE+".reviewImgList");
	}
	
	// ���Թ�ȣ�� ���� ����Ʈ + ȸ�� ���� ��������
	public List<HashMap<String, Object>> review_member_list(int shop_num){
		return sqlSession.selectList(NAMESPACE+".review_member_list", shop_num);
	}
	
	//����ȣ�� ���Թ�ȣ�� �޾� �����ۼ� ���� �Ǵ��ϱ� 
	public String reviewAble(HashMap<String, Integer> map) {
		return sqlSession.selectOne(NAMESPACE+".reviewAble", map);
	}
	
	//�ֹ��� ���� ���並 �����
	public List<ReviewVo> selectMemberReview(HashMap<String, Integer> map){
		System.out.println("dao map" + map);
		return sqlSession.selectList(NAMESPACE+".selectMemberReview", map);
	}
}
