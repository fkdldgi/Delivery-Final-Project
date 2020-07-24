package com.jhta.delivery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.vo.OwnerVo;

@Controller
public class OwnerMyPageController {
	@Autowired
	private OwnerService service;
	
	@GetMapping("/owner/mypage")
	public String mypage(String id,Model model) {
		//아이디로 해당회원 vo얻어오기
		OwnerVo vo=service.idChk(id);
		//세션에 비밀번호 저장
		model.addAttribute("ownerPwd", vo.getPwd());
		return ".owner.mypage.mypage_content";
	}
	@PostMapping("/owner/mypage")
	public String mypageOk(String pwd,HttpSession session) {
		session.setAttribute("ownerPwd",pwd);
		return ".owner.mypage.home";
	}
}
