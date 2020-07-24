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
	// �Ϲ�ȸ�� ��������Ʈ
	public List<NoticeVo> noticeList(HashMap<String, Object> map) {
		return sqlSession.selectList(NAMESPACE+".noticeList",map);
	}
	
	// ���ȸ�� ��������Ʈ
	public List<NoticeVo> Owner_noticeList(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+".Owner_noticeList", map);
	}
	
	// �Ϲ�ȸ�� �󼼰���
	public NoticeVo detail(int num) {
		return sqlSession.selectOne(NAMESPACE+".detail",num);
	}
	
	// ���ȸ�� �󼼰���
	public NoticeVo Owner_noticeDetail(int num) {
		return sqlSession.selectOne(NAMESPACE+".Owner_noticeDetail", num);
	}
	
	// �Ϲ�ȸ�� ��������
	public NoticeVo next(int num) {
		return sqlSession.selectOne(NAMESPACE+".next",num);
	}
	
	// ���ȸ�� ��������
	public NoticeVo Owner_next(int num) {
		return sqlSession.selectOne(NAMESPACE+".Onwer_next", num);
	}
	
	// �Ϲ�ȸ�� ��������
	public NoticeVo pre(int num) {
		return sqlSession.selectOne(NAMESPACE+".pre",num);		
	}
	
	// ���ȸ�� ��������
	public NoticeVo Owner_prev(int num) {
		return sqlSession.selectOne(NAMESPACE+".Owner_prev", num);
	}

}




















