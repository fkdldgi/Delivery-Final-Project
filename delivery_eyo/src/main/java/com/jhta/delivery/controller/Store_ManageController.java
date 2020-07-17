package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.Owner_MenuService;
import com.jhta.delivery.service.Owner_StoreService;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Store_ManageController {
	
	@Autowired
	private OwnerService service;
	
	@Autowired
	private Owner_StoreService store_service;
	
	@Autowired
	private Owner_MenuService menu_service;
	
	@GetMapping("/owner/store_manage")
	public String manage(Model model, String id) {
		
		List<ShopVo> shopList = service.shop_list(id);
		model.addAttribute("list", shopList);
		
		if(id==null || id=="") {
			return ".owner.error"; //이거 수정해요
		}else {
			return ".owner.store_manage";
		}
	}
	
	@PostMapping("/owner/store_manage") // 배열로 받아야함
	public String manage_update(Model model,@RequestParam HashMap<String, Object> map) {
		
		System.out.println(map.get("menu_info"));

		
		return ".owner.store_manage";
	}
	
	@RequestMapping("/owner/store_manage/home")
	public String manageHome(Model model, int num) {
		
		ShopVo vo = service.shop_select(num);
		List<MenuVo> mainMenuList = store_service.mainMenuList(num);
		List<MenuCategoryVo> menuCategoryList = menu_service.menuCategory(num);
		// List<Menu_OptionVo> ShopNum_MenuOption = menu_service.ShopNum_MenuOption(num);
		List<MenuVo> menu=menu_service.menu(num);		
		model.addAttribute("mainMenuList",mainMenuList);
		model.addAttribute("menuCategoryList", menuCategoryList);
		model.addAttribute("menu",menu);
		

		// model.addAttribute("ShopNum_MenuOption", ShopNum_MenuOption);
		model.addAttribute("vo", vo);
		
		if(vo==null) {
			return ".owner.error";
		}else {
			return ".owner.store_manage_home";
		}
	}
}
