package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PersonalQnaController {
	@RequestMapping("/member/personalQna")
	public String qna() {
		return ".member.personalQna";
	}
}
