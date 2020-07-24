package com.jhta.delivery.controller;

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
	@PostMapping("/owner/pwdChange")
	public String pwdChangeOk() {
		
		return "";
	}
}
