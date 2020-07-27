package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;

@Repository
public class OwnerDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.OwnerMapper";
	
	//회원가입
	public int insert(OwnerVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//
	public OwnerVo selectOne(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".selectOne",map);
	}
	//아이디로 회원정보 가져오기
	public OwnerVo idChk(String id) {
		return session.selectOne(NAMESPACE+".idchk",id);
	}
	//사장 비밀번호 변경
	public int pwdUpdate(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".pwd_update",map);
	}
	//사장 이름,전화번호,이메일변경
	public int ownerUpdate(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".owner_update",map);
	}
	public List<ShopVo> shop_list(String id){
		return session.selectList(NAMESPACE+".shop_list", id);
	}
	public ShopVo shop_select(int num) {
		return session.selectOne(NAMESPACE+".shop_select", num);
	}
	
}
