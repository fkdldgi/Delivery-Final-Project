package com.jhta.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Store_Manage_ADController {

	@RequestMapping("/owner/store_manage/advertisement")
	public String manage_Ad(Model model, int num) {
		System.out.println('1');
		return ".owner.store.store_manage_Ad";
	}
}