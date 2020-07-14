package com.jhta.delivery.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.delivery.member.dao.StoreDao;
import com.jhta.delivery.member.vo.MenuVo;

@Service
public class StoreService {
	@Autowired
	private StoreDao dao;
	
	//���θ޴� ����Ʈ �޾ƿ���
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
}