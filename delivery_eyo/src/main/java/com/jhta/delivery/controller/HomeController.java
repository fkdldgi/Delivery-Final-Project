package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = "/owner/main")
	public String home() {
		
		return ".owner.main";	// tiles.xml�� ������ tiles�̸� ����
	}
}