package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BoardController {

	@RequestMapping(value = "/owner/board")
	public String home() {
		
		return ".owner.board";	// tiles.xml에 설정된 tiles이름 리턴
	}
}
