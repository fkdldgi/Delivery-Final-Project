package com.jhta.delivery.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.vo.MemberVo;

@Controller
public class JoinCotroller {
	@Autowired
	private MemberService service;
	@GetMapping("/member/join")
	public String join() {
		return ".member.join";
	}
	@PostMapping("/member/joinOk.do")
	public String joinOk(MemberVo vo) {
		int n=service.insert(vo);
		if (n>0) {
			return ".member.main";
		}else {
			return ".member.error";
		}
	}
}
