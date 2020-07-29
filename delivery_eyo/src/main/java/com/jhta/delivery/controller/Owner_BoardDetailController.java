package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhta.delivery.service.NoticeService;
import com.jhta.delivery.vo.NoticeVo;

@Controller
public class Owner_BoardDetailController {

	@Autowired
	private NoticeService service;
	
	@GetMapping("/owner/boardDetail")
	public String detail(Model model, int num) {
		
		NoticeVo vo=service.detail(num);//상세글 정보
		NoticeVo next = service.next(num);//다음글
		NoticeVo pre = service.pre(num);//이전글
		model.addAttribute("vo",vo);
		model.addAttribute("next",next);
		model.addAttribute("pre",pre);

		return ".owner.boardDetail";
 	}
}
