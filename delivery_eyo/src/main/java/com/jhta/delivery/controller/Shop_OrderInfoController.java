package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jhta.delivery.service.ShopService;

@Controller
public class Shop_OrderInfoController {
	@Autowired
	private ShopService shopService;
	
}
