package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jhta.delivery.service.Order_MainService;
import com.jhta.delivery.service.Order_MenuService;
import com.jhta.delivery.service.Order_Menu_OptionService;

@Controller
public class MemberOrderController {
	@Autowired
	private Order_MenuService menuService;
	@Autowired
	private Order_Menu_OptionService optionService;
	@Autowired
	private Order_MainService mainService;
	
}
