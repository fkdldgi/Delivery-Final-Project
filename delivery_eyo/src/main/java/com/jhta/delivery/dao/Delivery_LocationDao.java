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
	
	//배달가능지역추가
	public int insert(Delivery_LocationVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//가게운영-배달권역에서 배달지역 재설정 시 시,도,군,구가 다를경우 재 추가
	public int reInsert(HashMap<String,Object> map) {
		return session.insert(NAMESPACE+".reInsert",map);
	}
	//가게번호로 배달지역 얻어오기
	public Delivery_LocationVo selectLoc(int num) {
		return session.selectOne(NAMESPACE+".selectLoc",num);
	}
	//배달지역 삭제
	public int delete(int num) {
		return session.delete(NAMESPACE+".delete",num);
	}
	//행정동 업데이트
	public int update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".update",map);
	}
}
