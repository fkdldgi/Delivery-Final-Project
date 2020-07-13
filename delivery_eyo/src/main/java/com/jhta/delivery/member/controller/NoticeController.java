package com.jhta.delivery.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class NoticeController {
	@RequestMapping("/member/notice")
	public String notice() {
		return ".member.notice";
	}
}
