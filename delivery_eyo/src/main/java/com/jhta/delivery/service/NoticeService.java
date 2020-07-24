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
	
	// 일반회원 상세공지
	public NoticeVo detail(int num) {
		return dao.detail(num);		
	}
	
	// 기업회원 상세공지
	public NoticeVo Owner_noticeDetail(int num) {
		return dao.Owner_noticeDetail(num);
	}
	
	// 일반회원 다음공지
	public NoticeVo next(int num) {
		return dao.next(num);		
	}
	
	// 기업회원 다음공지
	public NoticeVo Owner_next(int num) {
		return dao.Owner_next(num);
	}
	
	// 일반회원 이전공지
	public NoticeVo pre(int num) {
		return dao.pre(num);		
	}

	// 기업회원 이전공지
	public NoticeVo Owner_prev(int num) {
		return dao.Owner_prev(num);
	}
}
