package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class QnaDetailController {
	@RequestMapping("/member/qnaDetail")
	public String qna() {
		return ".member.qnaDetail";
	}
}
