package com.jhta.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.StoreDao;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;

@Service
public class StoreService {
	@Autowired
	private StoreDao dao;
	
	//���θ޴� ����Ʈ �޾ƿ���
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
	
	//�޴���ȣ�� �޴����� ��������
	public MenuVo menuInfo(int num) {
		return dao.menuInfo(num);
	}
	
	//�޴���ȣ�� �ɼǸ޴� ��������
	public List<MenuOptionVo> optionInfo(int num){
		return dao.optionInfo(num);
	}
}
