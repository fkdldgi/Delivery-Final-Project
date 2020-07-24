package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.MemberDao;
import com.jhta.delivery.vo.MemberVo;
import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	//�Ϲ�ȸ�� ����
	public int insert(MemberVo vo) {
		System.out.println("����");
		return dao.insert(vo);
	}
	
	public MemberVo selectOne(HashMap<String, Object> map) {
		return dao.selectOne(map);
	}
	public MemberVo idChk(String id) {
		return dao.idChk(id);
	}
	
	//���Ը�� ����Ʈ �޾ƿ���
	public List<ShopVo> shopList(HashMap<String, Object> map){
		return dao.shopList(map);
	}
	
	//Ư������ ���� �޾ƿ���
	public ShopVo storeInfo(int num) {
		return dao.storeInfo(num);
	}
	//�α��ε� ȸ�� ���� �޾ƿ���
	public MemberVo memberInfo(int num) {
		return dao.memberInfo(num);
	}
	public int update(HashMap<String, Object> map) {
		return dao.update(map);
	}

	
}
