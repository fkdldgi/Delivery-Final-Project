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
	
	//���Թ�ȣ�� ���� ���� ����Ʈ ��������
	public List<ReviewVo> shopReviewList(int shop_num){
		return dao.shopReviewList(shop_num);
	}
	
	//���� �̹��� ����Ʈ ��������
	public List<Review_ImgVo> reviewImgList(){
		return dao.reviewImgList();
	}
	
	// ���Թ�ȣ�� ���� ����Ʈ + ȸ�� ���� ��������
	public List<HashMap<String, Object>> review_member_list(int shop_num){
		return dao.review_member_list(shop_num);
	}
	
	//����ȣ�� ���Թ�ȣ�� �޾� �����ۼ� ���� �Ǵ��ϱ� 
	public String reviewAble(HashMap<String, Integer> map) {
		return dao.reviewAble(map);
	}
	
	//�ֹ��� ���� ���並 �����
	public List<ReviewVo> selectMemberReview(HashMap<String, Integer> map){
		System.out.println("����  map" + map);
		return dao.selectMemberReview(map);
	}
	
}
