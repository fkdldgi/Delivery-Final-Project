package com.jhta.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String manage_update(Model model,
						@RequestParam(value="shop_info") String shop_info,
						@RequestParam(value="category_num") List<String> category_num,
						@RequestParam(value="menu_category_name") List<String> menu_category_name,
						@RequestParam(value="menu_name") List<String> menu_name,
						@RequestParam(value="menu_info") List<String> menu_info,
						@RequestParam(value="min_price") List<String> min_price,
						@RequestParam(value="menu_num") List<String> menu_num) {
		
		System.out.println(shop_info); // 주문안내 가져옴
		System.out.println(menu_category_name); // 메뉴카테고리명
		System.out.println(menu_name); // 메뉴이름
		System.out.println(menu_info); // 메뉴설명
		System.out.println(min_price); // 메뉴가격	
		System.out.println(menu_num); // 메뉴번호
		System.out.println(category_num); // 메뉴카테고리 번호
		
		List<MenuVo> MenuVoList = new ArrayList<>();
		List<MenuCategoryVo> menuCateogryList = new ArrayList<>();
		
		for(int i = 0; i<menu_category_name.size(); i++) {
			MenuCategoryVo vo = new MenuCategoryVo();
			
			String menu_category_nameVo = menu_category_name.get(i);
			int category_numVo = Integer.parseInt(category_num.get(i));
			
			vo.setNum(category_numVo);
			vo.setName(menu_category_nameVo);
			menuCateogryList.add(vo);
			
		}
		
		for(int i = 0; i<menu_name.size(); i++) {
			MenuVo vo = new MenuVo();
			
			String menu_nameVo = menu_name.get(i);
			String menu_infoVo = menu_info.get(i);
			int min_priceVo = Integer.parseInt(min_price.get(i));
			int menu_numVo = Integer.parseInt(menu_num.get(i));
			int category_numVo = Integer.parseInt(category_num.get(i));
			
			vo.setNum(menu_numVo);
			vo.setName(menu_nameVo);
			vo.setMenu_info(menu_infoVo);
			vo.setPrice(min_priceVo);
			vo.setMenu_category_num(category_numVo);
			MenuVoList.add(vo);
		}
		for(MenuVo vo1: MenuVoList) {
			System.out.println(vo1.getNum());
			System.out.println(vo1.getName());
			System.out.println(vo1.getMenu_info());
			System.out.println(vo1.getPrice());
			System.out.println();
		}
		
		return ".owner.store_manage";
	}
	
	// 메뉴삭제할 경우
	@RequestMapping("/owner/store_manage/delete")
	@ResponseBody
	public int manageDeletMenu(Model model, int delete_num) {
		int n = store_service.deleteMenu(delete_num);
		System.out.println(n);
		if(n > 0) {
			return 1;
		}else {
			return -1;
		}
	}
	
	@RequestMapping("/owner/store_manage/home")
	public String manageHome(Model model, int num) {
		
		ShopVo vo = service.shop_select(num);
		
		List<MenuVo> mainMenuList = store_service.mainMenuList(num);
		List<MenuCategoryVo> menuCategoryList = menu_service.menuCategory(num);
		List<MenuVo> menu=menu_service.menu(num);		
		
		model.addAttribute("mainMenuList",mainMenuList);
		model.addAttribute("menuCategoryList", menuCategoryList);
		model.addAttribute("menu",menu);
		model.addAttribute("vo", vo);
		model.addAttribute("Shop_num", num);
		
		if(vo==null) {
			return ".owner.error";
		}else {
			return ".owner.store_manage_home";
		}
	}
}
