package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Delivery_TipVo;

@Repository
public class Delivery_TipDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE="mybatis.Delivery_TipMapper";
	
	//지역배달팁추가
	public int insert(Delivery_TipVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	//가게번호로 지역별배달팁 얻어오기
	public List<Delivery_TipVo> selectTip(int shopNum){
		return session.selectList(NAMESPACE+".selectTip",shopNum);
	}
}
