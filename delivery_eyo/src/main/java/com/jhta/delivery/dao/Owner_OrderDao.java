package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Owner_CalVo;
import com.jhta.delivery.vo.Owner_OrderVo;

@Repository
// �ֹ�
public class Owner_OrderDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.Owner_OrderMapper";
	
	// ���Կ��� �ֹ���û ����Ʈ
	public List<Owner_OrderVo> owner_orderList(int num){
		return session.selectList(NAMESPACE+".Owner_OrderList", num);
	}
	
	// ���Կ��� �ֹ����� ����Ʈ
	public List<Owner_OrderVo> owner_successList(int num){
		return session.selectList(NAMESPACE+".Owner_SuccessList", num);
	}
	
	// ���Կ��� �ֹ� ����
	public int update_end_ex_time(Owner_OrderVo vo) {
		return session.update(NAMESPACE+".Owner_UpdateTime", vo);
	}
	
	// ����� �Ϸ�� ��갪
	public List<Owner_CalVo> end_cal(int num){
		return session.selectList(NAMESPACE+".Owner_Cal", num);
	}
}
