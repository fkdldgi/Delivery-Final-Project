package com.jhta.delivery.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QnaController {
	@RequestMapping("/member/qna")
	public String qna() {
		return ".member.qna";
	}
}
