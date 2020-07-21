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
						@RequestParam(value="menu_num") List<String> menu_num,
						@RequestParam(value="category_list_num") List<String> category_list_num,
						@RequestParam(value="trash_category", required=false) List<String> trash_category,
						@RequestParam(value="trash", required=false) List<String> trash) {
		
		System.out.println(shop_info); // 주문안내 가져옴
		System.out.println(menu_category_name); // 메뉴카테고리명
		System.out.println(menu_name); // 메뉴이름
		System.out.println(menu_info); // 메뉴설명
		System.out.println(min_price); // 메뉴가격	
		System.out.println(menu_num); // 메뉴번호
		System.out.println(category_num); // 메뉴카테고리 번호
		System.out.println(trash_category); // 삭제한 메뉴카테고리 번호
		System.out.println(trash); // 삭제한 메뉴
		System.out.println();
		System.out.println(category_list_num);
		
		/*
		 * // 삭제한 메뉴카테고리번호로 메뉴카테고리 DB에서 삭제 if(trash_category != null) { for(String
		 * trash_category_string:trash_category) { int trash_category_num =
		 * Integer.parseInt(trash_category_string);
		 * store_service.deleteMenu_Category(trash_category_num); } }
		 * 
		 * // 삭제한 메뉴번호로 메뉴 DB에서 삭제 if(trash != null) { for(String trash_string:trash) {
		 * int trash_num = Integer.parseInt(trash_string);
		 * store_service.deleteMenu(trash_num); } }
		 */
		
		List<MenuVo> MenuVoList = new ArrayList<>();
		List<MenuCategoryVo> menuCateogryList = new ArrayList<>();
		
		int tmp=0;
		int j=0;
		for(int i = 0; i<min_price.size(); i++) {
			MenuCategoryVo vo = new MenuCategoryVo();
			int category_numVo = Integer.parseInt(category_list_num.get(i));
			String menu_category_nameVo = menu_category_name.get(j);
			if(tmp!=category_numVo) {
				tmp = category_numVo;
			}else {
				j++;
			}
			vo.setNum(category_numVo);
			vo.setName(menu_category_nameVo);
			menuCateogryList.add(vo);
			
		}
		
		for(int i = 0; i<min_price.size(); i++) {
			MenuVo vo = new MenuVo();
			
			int category_numVo = Integer.parseInt(category_list_num.get(i));	// 카테고리 번호
			String menu_nameVo = menu_name.get(i);								// 카테고리 명
			String menu_infoVo = menu_info.get(i);								// 메뉴 설명
			int min_priceVo = Integer.parseInt(min_price.get(i));				// 메뉴 가격
			int menu_numVo = Integer.parseInt(menu_num.get(i));					// 메뉴 번호
			
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
			System.out.println(vo1.getMenu_category_num());
			System.out.println();
		}
		
		return ".owner.store_manage";
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
