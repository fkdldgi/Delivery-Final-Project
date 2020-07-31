package com.jhta.delivery.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.RiderVo;

@Repository
public class RiderDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.RiderMapper";
	
	// �α���
	public RiderVo selectOne(HashMap<String,Object> map) {
		return session.selectOne(NAMESPACE+".RiderOne",map);
	}
	// ȸ������
	public int insertRider(RiderVo vo) {
		return session.insert(NAMESPACE+".insertRider", vo);
	}
	// ���̴�ȸ�����
	public RiderVo RiderIdcheck(String id){
		return session.selectOne(NAMESPACE+".RiderIdcheck",id);
	}
	// ���̵�ã��
	public String RiderId(RiderVo vo) {
		return session.selectOne(NAMESPACE+".RiderId", vo);
	}
	// ��й�ȣã��
	public String RiderPwd(RiderVo vo) {
		return session.selectOne(NAMESPACE+".RiderPwd", vo);
	}
	
	// ���̴�����
	public RiderVo riderInfo(int num) {
		return session.selectOne(NAMESPACE+".RiderInfo", num);
	}
	
	// ���̴� �޸�
	public int riderDrop(int num) {
		return session.update(NAMESPACE+".RiderDrop", num);
	}
	
	// ���̴� ��������
	public int riderUpdate(RiderVo vo) {
		return session.update(NAMESPACE+".RiderUpdate", vo);
	}
}
