package com.jhta.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Owner_ReviewDao;
import com.jhta.delivery.vo.Owner_ShopReviewVo;

@Service
public class Owner_ReviewService {
	@Autowired
	private Owner_ReviewDao dao;
	
	// ���Ը��� ��ü & ����� �Ϲ�ȸ��
	public List<Owner_ShopReviewVo> shopReview(int num){
		return dao.shopReview(num);
	}
}