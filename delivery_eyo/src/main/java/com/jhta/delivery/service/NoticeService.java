package com.jhta.delivery.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.delivery.dao.NoticeDao;
import com.jhta.delivery.vo.NoticeVo;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao dao;
	public int count(HashMap<String, Object>map) {
		return dao.count(map);
		
	}
	// 일반회원 전체공지
	public List<NoticeVo> noticeList(HashMap<String, Object> map) {
		return dao.noticeList(map);
		
	}
	
	// 기업회원 전체공지
	public List<NoticeVo> Owner_noticeList(HashMap<String, Object> map){
		return dao.Owner_noticeList(map);
	}
	
	// 공지 세부사항 
	public NoticeVo detail(int num) {
		return dao.detail(num);
		
	}
	
	// 공지 다음페이지
	public NoticeVo next(int num) {
		return dao.next(num);
		
	}
	
	// 공지 이전페이지
	public NoticeVo pre(int num) {
		return dao.pre(num);
		
	}

}
