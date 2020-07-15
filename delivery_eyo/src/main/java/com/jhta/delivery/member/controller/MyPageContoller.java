package com.jhta.delivery.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageContoller {
	@RequestMapping(value = "/member/mypage")
	public String mypage() {
		return ".member.mypage";
	}
}
