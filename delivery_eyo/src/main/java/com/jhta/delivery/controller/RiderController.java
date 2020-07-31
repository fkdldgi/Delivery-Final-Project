package com.jhta.delivery.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RiderController {
	@RequestMapping(value = "/rider/main")
	public String home() {
		
		return ".rider.login";	// tiles.xml에 설정된 tiles이름 리턴
	}
	
	@RequestMapping("/rider/login")
	@ResponseBody
	public int login(String id, String pwd, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("pwd",pwd);
		
		return 1;
	}
	
	@RequestMapping("/rider/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();
		return home();
	}
}
