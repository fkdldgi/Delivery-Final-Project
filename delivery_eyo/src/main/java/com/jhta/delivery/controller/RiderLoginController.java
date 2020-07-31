package com.jhta.delivery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.RiderService;
import com.jhta.delivery.vo.RiderVo;

@Controller
public class RiderLoginController {
	
	@Autowired
	private RiderService service;
	
	// 로그인 하면 메인페이지로 이동
	@RequestMapping("/rider/main")
	public String main() {
		
		return ".rider.main";
	}	
	
	// 내정보 변경페이지
	@RequestMapping("/rider/update")
	public String updateInfo(Model model, int num) {
		
		RiderVo vo = service.riderInfo(num);
		
		model.addAttribute("vo", vo);
		
		return ".rider.mypage";
	}
	
	// 내정보 변경확인
	@PostMapping("/rider/mypageOk")
	public String updateInfo1(Model model, RiderVo vo) {
		
		service.riderUpdate(vo);
		
		return ".rider.main";
	}
	
	// 탈퇴
	@RequestMapping("/rider/drop")
	public String logout(HttpSession session, int num) {
		service.riderDrop(num);
		session.invalidate();
		
		return ".rider.login";
	}
}
