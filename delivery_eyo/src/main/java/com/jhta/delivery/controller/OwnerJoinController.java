package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.vo.OwnerVo;

@Controller
public class OwnerJoinController {
	@Autowired
	private OwnerService service;
	@GetMapping("/owner/join")
	public String join() {
		return ".join";
	}
	@PostMapping("/owner/join")
	public String joinOk(OwnerVo vo) {
		try {
			service.insert(vo);
			return ".owner.success";
		}catch(Exception e) {
			e.printStackTrace();
			return ".owner.error";
		}
	}
	@RequestMapping("/owner/idchk")
	@ResponseBody
	public int idChk(String id) {
		OwnerVo vo=service.idChk(id);
		if(vo!=null) {
			return 0; //아이디가 사용중이므로 사용불가
		}else {
			return 1; //아이디 사용가능
		}
	}
}
