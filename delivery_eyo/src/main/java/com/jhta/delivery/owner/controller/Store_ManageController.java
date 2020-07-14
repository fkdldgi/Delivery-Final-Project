package com.jhta.delivery.owner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.member.vo.MenuVo;
import com.jhta.delivery.member.vo.ShopVo;
import com.jhta.delivery.owner.service.OwnerService;
import com.jhta.delivery.owner.service.Owner_StoreService;

@Controller
public class Store_ManageController {
	
	@Autowired
	private OwnerService service;
	
	@Autowired
	private Owner_StoreService store_service;
	
	@RequestMapping("/owner/store_manage")
	public String manage(Model model, String id) {
		
		List<ShopVo> shopList = service.shop_list(id);
		model.addAttribute("list", shopList);
		
		if(id==null || id=="") {
			return ".owner.error"; //이거 수정해요
		}else {
			return ".owner.store_manage";
		}
	}
	
	@RequestMapping("/owner/store_manage/home")
	public String manageHome(Model model, int num) {
		
		ShopVo vo = service.shop_select(num);
		List<MenuVo> mainMenuList = store_service.mainMenuList(num);
		model.addAttribute("mainMenuList",mainMenuList);
		model.addAttribute("vo", vo);
		
		if(vo==null) {
			return ".owner.error";
		}else {
			return ".owner.store_manage_home";
		}
	}
}
