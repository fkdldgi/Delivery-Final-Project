package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Order_MainVo;
import com.jhta.delivery.vo.RiderOrderVo;
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
	
	// ���̴��� ���� ���� �ֹ����� ����Ʈ
	public List<RiderOrderVo> riderOrderList(){
		return session.selectList(NAMESPACE+".RiderOrderList");
	}
	
	// ���̴��� ��޽���
	public int RiderAcceptOrder(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".RiderAcceptOrder", map);
	}
	
	// ���̴��� ��޽��ι��� ����Ʈ
	public List<RiderOrderVo> riderAcceptList(int num){
		return session.selectList(NAMESPACE+".RiderAcceptList", num);
	}
	
	// ���̴��� ��޿Ϸ�
	public int RiderSuccessOrder(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".RiderSuccessOrder", map);
	}
	
	// ���̴��� ��޿Ϸ��� ����Ʈ
	public List<RiderOrderVo> riderSuccessList(int num){
		return session.selectList(NAMESPACE+".RiderSuccessList", num);
	}
}













