package com.jhta.delivery.owner.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.member.vo.ShopVo;
import com.jhta.delivery.owner.dao.OwnerDao;
import com.jhta.delivery.owner.vo.OwnerVo;

@Service
public class OwnerService {
	@Autowired
	private OwnerDao dao;
	public int insert(OwnerVo vo) {
		return dao.insert(vo);
	}
	public OwnerVo selectOne(HashMap<String, Object> map) {
		return dao.selectOne(map);
	}
	public OwnerVo idChk(String id) {
		return dao.idChk(id);
	}
	public List<ShopVo> shop_list(String id){
		return dao.shop_list(id);
	}
	public ShopVo shop_select(int num) {
		return dao.shop_select(num);
	}
}
