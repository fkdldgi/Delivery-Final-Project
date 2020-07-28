package com.jhta.delivery.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.ShopVo;

@Repository
public class ShopDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.ShopMapper";
	
	//���Ե��
	public int insert(ShopVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//�⺻���� ������Ʈ
	public int basic_info_update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".basicinfo_update",map);
	}
	//����� ������Ʈ
	public int operation_info_update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".operationinfo_update",map);
	}
	//���Թ�ȣ�� ��������������
	public ShopVo selectShop(int num) {
		return session.selectOne(NAMESPACE+".selectShop",num);
	}
}
