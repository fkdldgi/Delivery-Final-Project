package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.delivery.service.QnaService;
import com.jhta.delivery.vo.QnaVo;
@Controller
public class PersonalQnaController {
	@Autowired
	private QnaService service;
	//1대1문의 작성하기 
	@RequestMapping(value = "/member/personalQna",method=RequestMethod.GET)
	public String qnainsert() {
		return ".member.personalQna";
	}
	@RequestMapping(value = "/member/personalQna",method=RequestMethod.POST)
	public String qnainsertOk(QnaVo vo) {
		try {
			service.insert(vo);
			//성공하면 다시 리스트로 돌아가도록
			return ".member.QnaList";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "error";
		}
	}
}
