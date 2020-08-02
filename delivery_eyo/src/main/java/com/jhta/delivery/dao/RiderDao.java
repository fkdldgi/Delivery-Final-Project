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
	
	// 로그인
	public RiderVo selectOne(HashMap<String,Object> map) {
		return session.selectOne(NAMESPACE+".RiderOne",map);
	}
	// 회원가입
	public int insertRider(RiderVo vo) {
		return session.insert(NAMESPACE+".insertRider", vo);
	}
	// 라이더회원목록
	public RiderVo RiderIdcheck(String id){
		return session.selectOne(NAMESPACE+".RiderIdcheck",id);
	}
	// 아이디찾기
	public String RiderId(RiderVo vo) {
		return session.selectOne(NAMESPACE+".RiderId", vo);
	}
	// 비밀번호찾기
	public String RiderPwd(RiderVo vo) {
		return session.selectOne(NAMESPACE+".RiderPwd", vo);
	}
	
	// 라이더정보
	public RiderVo riderInfo(int num) {
		return session.selectOne(NAMESPACE+".RiderInfo", num);
	}
	
	// 라이더 휴면
	public int riderDrop(int num) {
		return session.update(NAMESPACE+".RiderDrop", num);
	}
	
	// 라이더 정보수정
	public int riderUpdate(RiderVo vo) {
		return session.update(NAMESPACE+".RiderUpdate", vo);
	}
}
