package com.jhta.delivery.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {
	@RequestMapping("/member/event_main")
	public String event() {
		return ".member.event_main";
	}
}
