package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Menu_OptionVo;

@Repository
public class StoreDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.StoreMapper";
	
	//���� ���θ޴� ����Ʈ �޾ƿ���
	public List<MenuVo> mainMenuList(int num){
		return session.selectList(NAMESPACE+".mainMenuList", num);
	}
	
	//�޴���ȣ�� �޴� ��������
	public MenuVo menuInfo(int num) {
		return session.selectOne(NAMESPACE+".menuInfo", num);
	}
	
	//�޴���ȣ�� �ɼǸ޴� ��������
	public List<MenuOptionVo> optionInfo(int num){
		int menu_num = num;
		return session.selectList(NAMESPACE+".optionInfo", menu_num);
	}
}
