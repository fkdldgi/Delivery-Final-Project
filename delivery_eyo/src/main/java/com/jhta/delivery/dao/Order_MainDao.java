package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Order_MainVo;

@Repository
// �ֹ�
public class Order_MainDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.OrderMapper";
	
	//�ֹ� �Է� �κ�
	public int insert(Order_MainVo vo) {
		return session.insert(NAMESPACE+".Order_Main_insert", vo);
	}
	
	
	//�޴� ��ȣ�� �޴� ���� ��������
	public int getMenuPrice(int num) {
		return session.selectOne(NAMESPACE+".getMenuPrice",num);
	}
	
	//�ɼ� ��ȣ�� �ɼ� �޴� ���� ��������
	public int getOptionPrice(int num) {
		return session.selectOne(NAMESPACE+".getOptionPrice",num);
	}
	
	//���� �־ �ֹ� �޴��� ���� �����ϱ�
	public int orderPriceUpdate(int price) {
		return session.update(NAMESPACE+".orderPriceUpdate", price);
	}
	
	// �ֹ��ɼ� ���̺��� �ֹ� �ɼ� ��ȣ ������(�ֹ� Ʈ����� ���� ó���� ���)
	public int getOrderMenuNumBy(int num) {
		return session.selectOne(NAMESPACE+".getOrderMenuNumBy", num);
	}
}
