package com.jhta.delivery.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.vo.MemberVo;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService service;
	
	//로그인
	@RequestMapping("/member/login")
	@ResponseBody
	public int login(String id,String pwd, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberVo vo=service.selectOne(map);
		if (vo!=null) {
			session.setAttribute("memberId",id);
			session.setAttribute("memberName",vo.getName());
			session.setAttribute("memberNum",vo.getNum());
			return 1;
		}else {
			return 0;
		}
	}
	
	//로그아웃
	@RequestMapping("/member/logout")
	@ResponseBody
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
