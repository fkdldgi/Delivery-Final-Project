package com.jhta.delivery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.Owner_ReviewDao;
import com.jhta.delivery.vo.Owner_ReviewVo;

@Service
public class Owner_ReviewService {
	@Autowired
	private Owner_ReviewDao dao;
	
	// ���Կ� ���� ���� ����Ʈ
	public List<Owner_ReviewVo> ownerReviewList(int num){
		return dao.ownerReviewList(num);
	}
}