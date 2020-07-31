package com.jhta.delivery.controller;

import java.util.HashMap;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.RiderService;
import com.jhta.delivery.vo.RiderVo;

@Controller
public class RiderController {
	
	@Autowired
	private RiderService service;
	
	@RequestMapping(value = "/rider/home")
	public String home() {
		return ".rider.login";
	}
	
	// 로그인
	@RequestMapping("/rider/login")
	@ResponseBody
	public int login(String id, String pwd, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("pwd",pwd);
		RiderVo vo = service.selectOne(map);
		if(vo != null) {
			session.setAttribute("riderId", id);
			session.setAttribute("riderName", vo.getName());
			session.setAttribute("riderNum", vo.getNum());
			return 1;
		}else {
			return 0;
		}
	}
	
	// 회원가입
	@RequestMapping("/rider/join")
	public String join(String id, String pwd, String name, String email, String phone) {
		RiderVo vo = new RiderVo(0,id,pwd,name,phone,email,0,null);
		service.insertRider(vo);
		
		return ".rider.rider.home";
	}
	
	// 아이디 중복확인
	@RequestMapping("/rider/checkId")
	@ResponseBody
	public String checkId(String id) {
		RiderVo vo = service.RiderIdcheck(id);
		// 존재하는 아이디가 있을 경우
		if(vo!=null) {
			return "fail";
		}else{
			return "success";			
		}
	}
	
	// 로그아웃 처음페이지로 이동
	@RequestMapping("/rider/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return ".rider.login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
