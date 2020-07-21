package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.jhta.delivery.service.QnaService;
import com.jhta.delivery.vo.QnaVo;
@Controller
public class QnaDetailController {
	@Autowired
	private QnaService service;
	@GetMapping("/member/qnaDetail")
	public String qnadetail(int num,Model model) {
		QnaVo vo=service.detail(num);//�󼼱� ����
		QnaVo next = service.next(num);//������
		QnaVo pre = service.pre(num);//������
		model.addAttribute("vo",vo);
		model.addAttribute("next",next);
		model.addAttribute("pre",pre);
		return ".member.qnaDetail";
	}
}
