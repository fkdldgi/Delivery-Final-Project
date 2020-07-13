package com.jhta.delivery.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.delivery.member.service.NoticeService;
import com.jhta.delivery.member.vo.NoticeVo;


@Controller
public class NoticeInsertController {
@Autowired
private NoticeService service;
	@RequestMapping(value = "/member/insert",method=RequestMethod.GET)
	public String insertForm() {
		return "member/insert";
		
	}

@RequestMapping(value="/member/insert",method=RequestMethod.POST)
public String insertOk(NoticeVo vo) {
	
		try {
			service.insert(vo);
			return "success";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}	
	}
}