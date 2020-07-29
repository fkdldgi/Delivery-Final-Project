package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.Delivery_TipService;
import com.jhta.delivery.vo.Delivery_TipVo;

@Controller
public class Shop_DeliveryTipController {
	@Autowired
	private Delivery_TipService service;
	
	@RequestMapping("/owner/shop/deliveryTip")
	@ResponseBody
	public int deliveryTip(Delivery_TipVo vo) {
		return service.insert(vo);
	}
}
