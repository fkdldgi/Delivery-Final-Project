package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Store_Manage_CalculateController {

	@Autowired
	private OwnerService owner_service;
	
	@RequestMapping("/owner/store_manage/calculate")
	public String manage_Ad(Model model, int num) {
		
		ShopVo vo = owner_service.shop_select(num);
		
		model.addAttribute("vo", vo);
		return ".owner.store.store_manage_calculate";
	}
}