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
	//��й�ȣ ����
	@PostMapping("/owner/pwdChange")
	public String pwdChangeOk(String id,String pwd,HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("pwd",pwd);
		int n=service.pwdUpdate(map);
		if(n>0) {
			session.removeAttribute("ownerPwd"); //���� ��й�ȣ�� ���ǿ��� ����
			session.setAttribute("ownerPwd", pwd); //���ο� ��й�ȣ�� ���ǿ� ���
			return ".owner.mypage.home";
		}else {
			return ".owner.mypage.pwd_change";
		}
	}
}
