package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCouponDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE = "mybatis.OrderMapper";
	
	// ȸ����ȣ�� �ּ� �������� ��� ������ ���� ����Ʈ ��������
	public List<HashMap<String, Object>> useableCoupon(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".useableCoupon", map);
	}
	
	// �������� ��ȣ�� ȸ����ȣ�� ���¿� �ֹ���ȣ ���� (����� �������� ����)
	public int updateCoupon(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".updateCoupon", map);
	}
}
