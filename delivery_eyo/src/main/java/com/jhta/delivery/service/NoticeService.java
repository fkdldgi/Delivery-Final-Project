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
	// �Ϲ�ȸ�� ��ü����
	public List<NoticeVo> noticeList(HashMap<String, Object> map) {
		return dao.noticeList(map);
		
	}
	
	// ���ȸ�� ��ü����
	public List<NoticeVo> Owner_noticeList(HashMap<String, Object> map){
		return dao.Owner_noticeList(map);
	}
	
	// �Ϲ�ȸ�� �󼼰���
	public NoticeVo detail(int num) {
		return dao.detail(num);		
	}
	
	// ���ȸ�� �󼼰���
	public NoticeVo Owner_noticeDetail(int num) {
		return dao.Owner_noticeDetail(num);
	}
	
	// �Ϲ�ȸ�� ��������
	public NoticeVo next(int num) {
		return dao.next(num);		
	}
	
	// ���ȸ�� ��������
	public NoticeVo Owner_next(int num) {
		return dao.Owner_next(num);
	}
	
	// �Ϲ�ȸ�� ��������
	public NoticeVo pre(int num) {
		return dao.pre(num);		
	}

	// ���ȸ�� ��������
	public NoticeVo Owner_prev(int num) {
		return dao.Owner_prev(num);
	}
}
