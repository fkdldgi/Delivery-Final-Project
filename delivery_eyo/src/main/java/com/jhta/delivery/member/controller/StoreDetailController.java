package com.jhta.delivery.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.member.service.MemberService;

@Controller
public class StoreDetailController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("/member/storeDetail")
	public String storeInfo(Model model,int num) {
		model.addAttribute("info", service.storeInfo(num));
		return ".member.storeDetail";
	}
}
