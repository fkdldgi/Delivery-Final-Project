package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.vo.OwnerVo;

@Controller
public class OwnerUpdateController {
	@Autowired
	private OwnerService service;
	
	@GetMapping("/owner/owner_update")
	public String owner_update(String id,Model model) {
		OwnerVo vo=service.idChk(id);
		model.addAttribute("ownerVo",vo);
		return ".owner.mypage.owner_update";
	}
	@PostMapping("/owner/owner_update")
	public String owner_updateOk() {
		return "";
	}
}
