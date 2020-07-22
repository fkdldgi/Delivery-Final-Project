package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class StoreListController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/storeList")
	public String storeList(Model model,int startrow) {
		int endrow=startrow+4;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		
		List<ShopVo> shopList = service.shopList(map);
		
		model.addAttribute("list", shopList);
		
		return ".member.storeList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/storeList1", method = RequestMethod.POST)
	public List<ShopVo> init(@RequestBody int startrow) {
		int endrow=startrow+4;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		
		List<ShopVo> shopList = service.shopList(map);
		return shopList;
	}
}
