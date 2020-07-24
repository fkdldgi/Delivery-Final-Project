package com.jhta.delivery.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jhta.delivery.vo.QnaVo;
@Repository
public class QnaDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="mybatis.QnaMapper";
	
	public int insert(QnaVo vo) {
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
	public int count(HashMap<String, Object>map) {
		return sqlSession.selectOne(NAMESPACE+".count",map);
	}
	public List<QnaVo> qnaList(HashMap<String, Object> map) {
		return sqlSession.selectList(NAMESPACE+".qnaList",map);
	}
	public QnaVo detail(int num) {
		return sqlSession.selectOne(NAMESPACE+".detail",num);
		
	}
	public QnaVo next(int num) {
		return sqlSession.selectOne(NAMESPACE+".next",num);
		
	}
	public QnaVo pre(int num) {
		return sqlSession.selectOne(NAMESPACE+".pre",num);
		
	}
}
