package com.jhta.delivery.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.Owner_OrderService;
import com.jhta.delivery.vo.Owner_CalVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Store_Manage_CalculateController {

	@Autowired
	private OwnerService owner_service;
	
	@Autowired
	private Owner_OrderService owner_orderService;
	
	@RequestMapping("/owner/store_manage/calculate")
	public String manage_Ad(Model model, int num) {
		
		ShopVo vo = owner_service.shop_select(num); 
		List<Owner_CalVo> calList = owner_orderService.end_cal(vo.getNum());
		
		model.addAttribute("vo", vo);
		model.addAttribute("calList",calList);
		
		return ".owner.store.store_manage_calculate";
	}
	
	// JSON
	@RequestMapping("/owner/store_manage/calculate1")
	@ResponseBody
	public String manage_cal(int num) {
		
		List<Owner_CalVo> calList = owner_orderService.end_cal(num);
		Gson gson=new Gson();
		String jsonString=gson.toJson(calList);
		
		
		return jsonString;
	}
}








