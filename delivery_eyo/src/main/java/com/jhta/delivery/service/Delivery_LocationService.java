package com.jhta.delivery.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.Delivery_LocationDao;
import com.jhta.delivery.vo.Delivery_LocationVo;

@Service
public class Delivery_LocationService {
	@Autowired
	private Delivery_LocationDao del_locDao;
	
	//배달가능지역 추가
	public int insert(Delivery_LocationVo vo) {
		return del_locDao.insert(vo);
	}
	//가게번호로 배달지역 얻어오기
	public Delivery_LocationVo selectLoc(int num) {
		return del_locDao.selectLoc(num);
	}
	//배달지역 삭제
	public int delete(int num) {
		return del_locDao.delete(num);
	}
	//행정동 업데이트
	public int update(HashMap<String, Object> map) {
		return del_locDao.update(map);
	}
	//
	@Transactional
	public void deliveryUpdate(HashMap<String,Object> map) throws Exception{
		del_locDao.delete((int)map.get("num"));
		del_locDao.reInsert(map);
	}
}
