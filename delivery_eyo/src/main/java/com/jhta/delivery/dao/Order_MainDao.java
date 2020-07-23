package com.jhta.delivery.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.Order_MainVo;

@Repository
// 주문
public class Order_MainDao {
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "mybatis.OrderMapper";
	
	//주문 입력 부분
	public int insert(Order_MainVo vo) {
		return session.insert(NAMESPACE+".Order_Main_insert", vo);
	}
	
	
	//메뉴 번호로 메뉴 가격 가져오기
	public int getMenuPrice(int num) {
		return session.selectOne(NAMESPACE+".getMenuPrice",num);
	}
	
	//옵션 번호로 옵션 메뉴 가격 가져오기
	public int getOptionPrice(int num) {
		return session.selectOne(NAMESPACE+".getOptionPrice",num);
	}
	
	//가격 넣어서 주문 메뉴의 가격 변경하기
	public int orderPriceUpdate(int price) {
		return session.update(NAMESPACE+".orderPriceUpdate", price);
	}
	
	// 주문옵션 테이블의 주문 옵션 번호 얻어오기(주문 트랜잭션 로직 처리에 사용)
	public int getOrderMenuNumBy(int num) {
		return session.selectOne(NAMESPACE+".getOrderMenuNumBy", num);
	}
}
