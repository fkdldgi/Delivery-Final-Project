package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.MemberVo;
import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.MemberMapper";
	
	//�Ϲ�ȸ�� ����
	public int insert(MemberVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//�α���
	public MemberVo selectOne(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".selectOne",map);
	}
	//���̵� �ߺ�üũ
	public MemberVo idChk(String id) {
		return session.selectOne(NAMESPACE+".idchk",id);
	}
	
	//���Ը�� ����Ʈ �޾ƿ���
	public List<ShopVo> shopList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".shopList",map);
	}
		
	//Ư�� ���� ���� �޾ƿ���
	public ShopVo storeInfo(int num) {
		return session.selectOne(NAMESPACE+".storeInfo", num);
	}
	//�α��ε� ȸ�� ���� �޾ƿ���
	public MemberVo memberInfo(int memberNum) {
		return session.selectOne(NAMESPACE+".memberInfo", memberNum);
	}
	public int update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".update",map);
		
	}
}
