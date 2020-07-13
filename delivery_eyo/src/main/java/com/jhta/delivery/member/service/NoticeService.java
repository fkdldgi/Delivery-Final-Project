package com.jhta.delivery.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.member.dao.NoticeDao;
import com.jhta.delivery.member.vo.NoticeVo;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao dao;
	public int insert(NoticeVo vo) {
		return dao.insert(vo);
	}
	public int count(HashMap<String, Object>map) {
		return dao.count(map);
		
	}
	public List<NoticeVo> list(HashMap<String, Object> map) {
		return dao.list(map);
		
	}
	public NoticeVo detail(int num) {
		return dao.detail(num);
		
	}
	public NoticeVo next(int num) {
		return dao.next(num);
		
	}
	public NoticeVo pre(int num) {
		return dao.pre(num);
		
	}
	public int delete(int num) {
		return dao.delete(num);
		
	}
	public int update(NoticeVo vo) {
		return dao.update(vo);
		
	}
}
