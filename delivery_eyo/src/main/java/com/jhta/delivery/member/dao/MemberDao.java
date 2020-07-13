package com.jhta.delivery.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.member.vo.MemberVo;
import com.jhta.delivery.member.vo.ShopVo;
import com.jhta.delivery.owner.vo.OwnerVo;

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
}
