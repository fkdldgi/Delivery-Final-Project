package com.jhta.delivery.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.member.vo.MenuVo;

@Repository
public class StoreDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.StoreMapper";
	
	//���� ���θ޴� ����Ʈ �޾ƿ���
	public List<MenuVo> mainMenuList(int num){
		return session.selectList(NAMESPACE+".mainMenuList", num);
	}
	
}
