package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RiderController {
	@RequestMapping(value = "/rider/main")
	public String home() {
		
		return ".rider.login";	// tiles.xml에 설정된 tiles이름 리턴
	}
}
