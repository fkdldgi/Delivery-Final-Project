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
	
	//일반회원 가입
	public int insert(MemberVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//로그인
	public MemberVo selectOne(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".selectOne",map);
	}
	//아이디 중복체크
	public MemberVo idChk(String id) {
		return session.selectOne(NAMESPACE+".idchk",id);
	}
	
	//가게목록 리스트 받아오기
	public List<ShopVo> shopList(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".shopList",map);
	}
		
	//특정 가게 정보 받아오기
	public ShopVo storeInfo(int num) {
		return session.selectOne(NAMESPACE+".storeInfo", num);
	}
	//로그인된 회원 정보 받아오기
	public MemberVo memberInfo(int memberNum) {
		return session.selectOne(NAMESPACE+".memberInfo", memberNum);
	}
	public int update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".update",map);
		
	}
}
