package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.OwnerDao;
import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;

@Service
public class OwnerService {
	@Autowired
	private OwnerDao dao;
	//회원가입
	public int insert(OwnerVo vo) {
		return dao.insert(vo);
	}
	//로그인
	public OwnerVo selectOne(HashMap<String, Object> map) {
		return dao.selectOne(map);
	}
	//아이디로 회원정보 가져오기
	public OwnerVo idChk(String id) {
		return dao.idChk(id);
	}
	//사장 비밀번호 변경
	public int pwdUpdate(HashMap<String, Object> map) {
		return dao.pwdUpdate(map);
	}
	//사장 이름,전화번호,이메일변경
	public int ownerUpdate(HashMap<String, Object> map) {
		return dao.ownerUpdate(map);
	}
	public List<ShopVo> shop_list(String id){
		return dao.shop_list(id);
	}
	public ShopVo shop_select(int num) {
		return dao.shop_select(num);
	}
}
