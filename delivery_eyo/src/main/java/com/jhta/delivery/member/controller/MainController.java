
package com.jhta.delivery.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value = "/member/main")
	public String home() {
		
		return ".member.main";	// tiles.xml�� ������ tiles�̸� ����
	}
	
}
