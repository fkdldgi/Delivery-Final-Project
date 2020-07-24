package com.jhta.delivery.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.jhta.delivery.vo.Qna_ImgVo;
@Repository
public class Qna_ImgDao {
	private SqlSessionTemplate sqlSession;
	private final String NAMESPACE="mybatis.QnaImgMapper";
	public int insert(Qna_ImgVo vo) {
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}
}
