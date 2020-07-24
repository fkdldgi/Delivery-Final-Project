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
	//로그인된 회원 정보 받아오기
	public MemberVo memberInfo(int num) {
		return dao.memberInfo(num);
	}
	public int update(HashMap<String, Object> map) {
		return dao.update(map);
	}

	
}
