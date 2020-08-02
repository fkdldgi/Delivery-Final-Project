package com.jhta.delivery.controller;

import java.util.HashMap;
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
		
		// 정산된 계산값
		List<Owner_CalVo> calList = owner_orderService.calList(vo.getNum());
		
		// 정산대기 계산값
		List<Owner_CalVo> waiting_calList = owner_orderService.waiting_calList(vo.getNum());
		
		model.addAttribute("vo", vo);
		model.addAttribute("calList",calList);
		model.addAttribute("waiting_calList",waiting_calList);
		
		return ".owner.store.store_manage_calculate";
	}
	
	@RequestMapping("/owner/store_cal")
	@ResponseBody
	public List<Owner_CalVo> store_cal(int num, String year, String month) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num",num);
		map.put("year", year);
		map.put("month", month);
		
		List<Owner_CalVo> list = owner_orderService.cal_search(map);
		return list;
	}
}








