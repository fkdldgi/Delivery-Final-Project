package com.jhta.delivery.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.vo.OwnerVo;

@Controller
public class OwnerLoginController {
	@Autowired
	private OwnerService service;
	
	@RequestMapping("/owner/login")
	@ResponseBody
	public int login(String id,String pwd,HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id",id);
		map.put("pwd",pwd);
		OwnerVo vo=service.selectOne(map);
		if(vo!=null) {
			session.setAttribute("ownerId", id);
			session.setAttribute("ownerName", vo.getName());
			return 1;
		}else {
			return 0;
		}
	}
	@RequestMapping("/owner/logout")
	@ResponseBody
	public void logout(HttpSession session) {
		session.invalidate();
	}
}
