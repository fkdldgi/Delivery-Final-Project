package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Order_Menu_OptionVo;

@Repository
// �ֹ��޴��ɼ� 
public class Order_Menu_OptionDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.OrderMapper";
	
	//�ֹ��޴� �ɼ� �Է� �κ�
	public int insert(Order_Menu_OptionVo vo) {
		return session.insert(NAMESPACE+".Order_Menu_Option_insert", vo);
	}
}
