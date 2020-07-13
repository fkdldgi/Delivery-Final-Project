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
	
	//일반회원 가입
	public int insert(MemberVo vo) {
		System.out.println("서비스");
		return dao.insert(vo);
	}
	
	public MemberVo selectOne(HashMap<String, Object> map) {
		return dao.selectOne(map);
	}
	public MemberVo idChk(String id) {
		return dao.idChk(id);
	}
	
	
	//가게목록 리스트 받아오기
	public List<ShopVo> shopList(HashMap<String, Object> map){
		return dao.shopList(map);
	}
	
	//특정가게 정보 받아오기
	public ShopVo storeInfo(int num) {
		return dao.storeInfo(num);
	}
}
