package com.jhta.delivery.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.OwnerService;

@Controller
public class OwnerPwdChangeController {
	@Autowired
	private OwnerService service;
	
	@GetMapping("/owner/pwdChange")
	public String pwdChange() {
		return ".owner.mypage.pwd_change";
	}
	//비밀번호 변경
	@PostMapping("/owner/pwdChange")
	public String pwdChangeOk(String id,String pwd,HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd",pwd);
		int n=service.pwdUpdate(map);
		if(n>0) {
			session.removeAttribute("ownerPwd"); //기존 비밀번호를 세션에서 삭제
			session.setAttribute("ownerPwd", pwd); //새로운 비밀번호를 세션에 등록
			return ".owner.mypage.home";
		}else {
			return ".owner.mypage.pwd_change";
		}
	}
}
