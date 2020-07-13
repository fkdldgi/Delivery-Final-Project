package com.jhta.delivery.member.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.member.vo.NoticeVo;
@Repository
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="mybatis.NoticeMapper";
	public int insert(NoticeVo vo) {
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
	public int count(HashMap<String, Object>map) {
		return sqlSession.selectOne(NAMESPACE+".count",map);
	}
	public List<NoticeVo> list(HashMap<String, Object> map) {
		return sqlSession.selectList(NAMESPACE+".list",map);
	}
	public NoticeVo detail(int num) {
		return sqlSession.selectOne(NAMESPACE+".list",num);
		
	}
	public NoticeVo next(int num) {
		return sqlSession.selectOne(NAMESPACE+".next",num);
		
	}
	public NoticeVo pre(int num) {
		return sqlSession.selectOne(NAMESPACE+".pre",num);
		
	}
	public int delete(int num) {
		return sqlSession.delete(NAMESPACE+".delete",num);
		
	}
	public int update(NoticeVo vo) {
		return sqlSession.update(NAMESPACE+".update",vo);
		
	}
}
