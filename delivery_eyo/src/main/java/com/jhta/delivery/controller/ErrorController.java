package com.jhta.delivery.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
@RequestMapping("/member/error")
public String error() {
	return ".member.error";
	}
}
