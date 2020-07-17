package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {
	@GetMapping("/owner/shopReg")
	public String shopReg() {
		return ".owner.shopReg";
	}
	
	@PostMapping("/owner/shopReg")
	public String shopReg2() {
		return ".";
	}
}
