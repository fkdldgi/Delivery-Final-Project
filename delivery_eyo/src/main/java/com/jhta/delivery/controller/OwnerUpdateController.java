package com.jhta.delivery.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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
	public String owner_update(HttpServletRequest req,Model model) {
		String id=req.getParameter("id");
		OwnerVo vo=service.idChk(id);
		model.addAttribute("name",vo.getName());
		model.addAttribute("tel",vo.getTel());
		model.addAttribute("email",vo.getEmail());
		return ".owner.mypage.owner_update";
	}
	@PostMapping("/owner/owner_update")
	public String owner_updateOk(HttpServletRequest req,Model model) {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String tel=req.getParameter("tel");
		String email=req.getParameter("email");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("name",name);
		map.put("tel",tel);
		map.put("email",email);
		int n=service.ownerUpdate(map);
		model.addAttribute("name",name);
		model.addAttribute("tel",tel);
		model.addAttribute("email",email);
		if(n>0) {
			return ".owner.mypage.home";
		}else {
			return ".owner.mypage.owner_update";
		}
	}
}
