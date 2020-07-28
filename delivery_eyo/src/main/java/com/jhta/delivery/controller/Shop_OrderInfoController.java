package com.jhta.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.Delivery_LocationService;
import com.jhta.delivery.service.Delivery_TipService;
import com.jhta.delivery.service.ShopService;
import com.jhta.delivery.vo.Delivery_LocationVo;
import com.jhta.delivery.vo.Delivery_TipVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Shop_OrderInfoController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private Delivery_LocationService del_locService;
	
	@Autowired
	private Delivery_TipService del_tipService;
	
	@GetMapping("/owner/shop/orderinfo")
	public String orderinfo(int num,Model model) {
		ShopVo shopVo=shopService.selectShop(num);
		Delivery_LocationVo del_locVo=del_locService.selectLoc(num);
		
		List<Delivery_TipVo> list=del_tipService.selectTip(num);
		model.addAttribute("tipList",list);
		model.addAttribute("shopVo",shopVo);
		model.addAttribute("del_locVo",del_locVo);
		return ".owner.shop.order_info";
	}
	@PostMapping("/owner/shop/orderinfo")
	public String orderinfoOk() {
		return "";
	}
}
