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
	public List<Order_MainVo> reviewAble(HashMap<String, Integer> map) {
		return sqlSession.selectList(NAMESPACE+".reviewAble", map);
	}
	
	//�ֹ��� ���� ���並 �����
	public List<ReviewVo> selectMemberReview(HashMap<String, Integer> map){
		return sqlSession.selectList(NAMESPACE+".selectMemberReview", map);
	}
	
	//�����ȣ�� �ֹ��� ���Թ�ȣ ��������
	public List<HashMap<String, Object>> getShopByMember(int member_num){
		return sqlSession.selectList(NAMESPACE+".getShopByMember", member_num);
	}
	
	// ���� �̹��� �ֱ�
	public int review_imgInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".review_imgInsert", map);
	}
	
	// ���� �ֱ� 
	public int reviewInsert(HashMap<String, Object> map) {
		return sqlSession.insert(NAMESPACE+".reviewInsert", map);
	} 
	
	// ���� �ۼ� ��  ORDER_MAIN�� ���䱸���� �����ϱ� 
	public int updateReviewStatus(int num) {
		return sqlSession.update(NAMESPACE+".updateReviewStatus", num);
	}
	
	// �ֹ� ��ȣ�� ����ȣ�� ���� �ֹ��� �޴� ����(�̸�) ��������
	public MenuVo getMenuNum(HashMap<String, Integer> map) {
		return sqlSession.selectOne(NAMESPACE+".getMenuNum", map);
	}
}
