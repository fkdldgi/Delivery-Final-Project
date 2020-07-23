package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.NoticeVo;
@Repository
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="mybatis.NoticeMapper";
	
	public int count(HashMap<String, Object>map) {
		return sqlSession.selectOne(NAMESPACE+".count",map);
	}
	// 일반회원 공지리스트
	public List<NoticeVo> noticeList(HashMap<String, Object> map) {
		return sqlSession.selectList(NAMESPACE+".noticeList",map);
	}
	
	// 기업회원 공지리스트
	public List<NoticeVo> Owner_noticeList(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".Owner_noticeList", map);
	}
	
	public NoticeVo detail(int num) {
		return sqlSession.selectOne(NAMESPACE+".detail",num);
		
	}
	public NoticeVo next(int num) {
		return sqlSession.selectOne(NAMESPACE+".next",num);
		
	}
	public NoticeVo pre(int num) {
		return sqlSession.selectOne(NAMESPACE+".pre",num);
		
	}

}
