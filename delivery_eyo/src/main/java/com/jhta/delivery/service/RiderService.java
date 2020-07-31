package com.jhta.delivery.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.RiderDao;
import com.jhta.delivery.vo.RiderVo;

@Service
public class RiderService {
	@Autowired
	private RiderDao dao;
	//로그인
	public RiderVo selectOne(HashMap<String, Object> map) {
		return dao.selectOne(map);
	}
	// 회원가입
	public int insertRider(RiderVo vo) {
		return dao.insertRider(vo);
	}
	// 라이더아이디 확인
	public RiderVo RiderIdcheck(String id) {
		return dao.RiderIdcheck(id);
	}
	// 아이디찾기
	public String RiderId(RiderVo vo) {
		return dao.RiderId(vo);
	}
	// 비밀번호 찾기
	public String RiderPwd(RiderVo vo) {
		return dao.RiderPwd(vo);
	}
	// 라이더정보
	public RiderVo riderInfo(int num) {
		return dao.riderInfo(num);
	}
	// 라이더 휴면
	public int riderDrop(int num) {
		return dao.riderDrop(num);
	}
	// 라이더 정보수정
	public int riderUpdate(RiderVo vo) {
		return dao.riderUpdate(vo);
	}
}
