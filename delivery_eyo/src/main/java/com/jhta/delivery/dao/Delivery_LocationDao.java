package com.jhta.delivery.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Delivery_LocationVo;

@Repository
public class Delivery_LocationDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.Delivery_LocationMapper";
	
	//��ް��������߰�
	public int insert(Delivery_LocationVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//���Կ-��ޱǿ����� ������� �缳�� �� ��,��,��,���� �ٸ���� �� �߰�
	public int reInsert(HashMap<String,Object> map) {
		return session.insert(NAMESPACE+".reInsert",map);
	}
	//���Թ�ȣ�� ������� ������
	public Delivery_LocationVo selectLoc(int num) {
		return session.selectOne(NAMESPACE+".selectLoc",num);
	}
	//������� ����
	public int delete(int num) {
		return session.delete(NAMESPACE+".delete",num);
	}
	//������ ������Ʈ
	public int update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".update",map);
	}
}
