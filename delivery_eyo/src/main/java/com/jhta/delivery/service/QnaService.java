package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jhta.delivery.dao.QnaDao;
import com.jhta.delivery.vo.QnaVo;
@Service
public class QnaService {
	@Autowired
	private QnaDao dao;
	public int count(HashMap<String, Object>map) {
		return dao.count(map);
		
	}
	public List<QnaVo> qnaList(HashMap<String, Object> map) {
		return dao.qnaList(map);
		
	}
	public QnaVo detail(int num) {
		return dao.detail(num);
		
	}
	public QnaVo next(int num) {
		return dao.next(num);
		
	}
	public QnaVo pre(int num) {
		return dao.pre(num);
		
	}
	public int insert(QnaVo vo) {
		return dao.insert(vo);
		
	}
	
}
