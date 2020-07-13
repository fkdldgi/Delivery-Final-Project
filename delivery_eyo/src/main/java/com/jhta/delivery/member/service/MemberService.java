package com.jhta.delivery.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.delivery.member.dao.MemberDao;
import com.jhta.delivery.member.vo.MemberVo;
import com.jhta.delivery.member.vo.ShopVo;
import com.jhta.delivery.owner.vo.OwnerVo;

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
}
