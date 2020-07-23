package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Owner_ShopRereviewVo;
import com.jhta.delivery.vo.Owner_ShopReviewVo;

@Repository
public class Owner_ReviewDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="mybatis.Owner_ReviewMapper";
	
	// ���Ը��� ��ü & ����� �Ϲ�ȸ��
	public List<Owner_ShopReviewVo> shopReview(int num){
		return session.selectList(NAMESPACE+".ShopReview", num);
	}
	
	// ���ȸ�� ���� ��ü
	public List<Owner_ShopRereviewVo> shopRereview(int num){
		return session.selectList(NAMESPACE+".Owner_Review", num);
	}
	
	// ���ȸ�� ��� �ֱ�
	public int insert_OwnerReview(Owner_ShopRereviewVo vo) {
		return session.insert(NAMESPACE+".insert_OwnerReview", vo);
	}
}
