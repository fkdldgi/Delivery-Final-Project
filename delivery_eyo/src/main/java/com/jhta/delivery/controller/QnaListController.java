package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QnaListController {
	@RequestMapping("/member/QnaList")
	public String qnaList() {
		return ".member.QnaList";
	}
}