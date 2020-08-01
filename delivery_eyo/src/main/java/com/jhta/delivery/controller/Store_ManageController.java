package com.jhta.delivery.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.Owner_MenuService;
import com.jhta.delivery.service.Owner_StoreService;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.ShopVo;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;

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

		if (id == null || id == "") {
			return ".owner.error"; // 이거 수정해요
		} else {
			return ".owner.store_manage";
		}
	}

	@PostMapping("/owner/store_manage") // 배열로 받아야함
	public String manage_update(Model model, HttpServletRequest req,
			@RequestParam(value = "owner_id") String id,
			@RequestParam(value = "trash_category", required = false) List<String> trash_category,
			@RequestParam(value = "trash", required = false) List<String> trash) {
		
		//가게번호
		int shop_num=Integer.parseInt(req.getParameter("shop_num"));
		//카테고리
		String[] category_numArr=req.getParameterValues("category_num");
		String[] menu_category_nameArr=req.getParameterValues("menu_category_name");
		//메뉴
		String[] menu_numArr=req.getParameterValues("menu_num");
		String[] menu_nameArr=req.getParameterValues("menu_name");
		String[] menu_infoArr=req.getParameterValues("menu_info");
		String[] menu_priceArr=req.getParameterValues("menu_price");
		String[] category_list_numArr=req.getParameterValues("category_list_num");
		//메뉴옵션
		String[] option_numArr=req.getParameterValues("option_num");
		String[] option_nameArr=req.getParameterValues("option_name");
		String[] option_priceArr=req.getParameterValues("option_price");
		String[] option_categoryArr=req.getParameterValues("option_category");
		String[] option_menu_numArr=req.getParameterValues("option_menu_num");
		
		List<MenuCategoryVo> category_list=new ArrayList<MenuCategoryVo>();
		List<MenuVo> menu_list=new ArrayList<MenuVo>(); //메뉴 리스트
		List<MenuOptionVo> menu_option_list=new ArrayList<MenuOptionVo>(); //메뉴옵션리스트
		//카테고리 for문
		for(int i=0; i<category_numArr.length; i++) {
			int category_num=Integer.parseInt(category_numArr[i]);
			String menu_category_name=menu_category_nameArr[i];
			//카테고리 추가
			MenuCategoryVo category_vo=new MenuCategoryVo();
			category_vo.setNum(category_num);
			category_vo.setName(menu_category_name);
			category_vo.setShop_num(shop_num);
			
			//메뉴 for문
			for(int j=0; j<menu_numArr.length; j++) {
				int menu_num=Integer.parseInt(menu_numArr[j]);
				String menu_name=menu_nameArr[j]; //메뉴이름
				String menu_info=menu_infoArr[j]; //메뉴설명
				int menu_price=Integer.parseInt(menu_priceArr[j]); //메뉴가격
				int category_list_num=Integer.parseInt(category_list_numArr[j]); //메뉴카테고리번호(소속)
				
				MenuVo menu_vo=new MenuVo(); //메뉴 VO
				if(category_list_num==category_num) { //해당 메뉴카테고리 소속의 메뉴일 경우
					menu_vo.setNum(menu_num); //메뉴번호 set
					menu_vo.setName(menu_name); //메뉴이름 set
					menu_vo.setMenu_info(menu_info); //메뉴설명 set
					menu_vo.setPrice(menu_price); //메뉴가격 set
					menu_vo.setMenu_category_num(category_list_num); //메뉴카테고리번호(소속) set
				}
				//메뉴옵션 for문
				for(int k=0; k<option_numArr.length; k++) {
					int option_num=Integer.parseInt(option_numArr[k]); //메뉴옵션번호
					String option_name=option_nameArr[k]; //메뉴옵션이름
					int option_price=Integer.parseInt(option_priceArr[k]); //메뉴옵션가격
					String option_categoty=option_categoryArr[k]; //옵션카테고리명
					int option_menu_num=Integer.parseInt(option_menu_numArr[k]); //메뉴번호(소속)
					
					MenuOptionVo option_vo=new MenuOptionVo();
					if(option_menu_num==menu_num) { //해당 메뉴 소속의 메뉴옵션일 경우
						option_vo.setNum(option_num);
						option_vo.setName(option_name);
						option_vo.setPrice(option_price);
						option_vo.setCategory(option_categoty);
						option_vo.setMenu_num(option_menu_num);
					
						menu_option_list.add(option_vo); //메뉴옵션 리스트에 옵션 VO 추가
					}
				}
				menu_vo.setMenu_option_list(menu_option_list);
				menu_list.add(menu_vo); //메뉴 리스트에 메뉴 VO 추가
			}
			category_vo.setMenu_list(menu_list); //메뉴카테고리에 메뉴리스트 넣기
			category_list.add(category_vo); //카테고리 리스트에 카테고리 VO 추가
		}
		int n=store_service.menuUpdateAndInsertTransaction(category_list);
		
		// 메뉴옵션 삭제하기
		if(req.getParameterValues("delete_menu_option") != null) {
			
			for(int i = 0; i < req.getParameterValues("delete_menu_option").length; i++) {
				
				int a = Integer.parseInt(req.getParameterValues("delete_menu_option")[i]);
				store_service.delete_menu_option(a);
			}
		}
		
		// 삭제한 메뉴카테고리번호로 메뉴카테고리 DB에서 삭제
		if (trash_category != null) {
			for (String trash_category_string : trash_category) {
				int trash_category_num = Integer.parseInt(trash_category_string);
				store_service.deleteMenu_Category(trash_category_num);
			}
		}
		
		// 삭제한 메뉴번호로 메뉴 DB에서 삭제
		if (trash != null) {
			for (String trash_string : trash) {
				int trash_num = Integer.parseInt(trash_string);
				store_service.deleteMenu(trash_num);
			}
		}

		
		
		// 전체 가게가 있는 페이지로 이동
		List<ShopVo> shopList = service.shop_list(id);
		model.addAttribute("list", shopList);

		if (id == null || id == "") {
			return ".owner.error";
		} else {
			return ".owner.store_manage";
		}
		
	}

	@RequestMapping("/owner/store_manage/home")
	public String manageHome(Model model, int num) {

		ShopVo vo = service.shop_select(num);

		List<MenuVo> mainMenuList = store_service.mainMenuList(num);
		List<MenuCategoryVo> menuCategoryList = menu_service.menuCategory(num);
		List<MenuVo> menu = menu_service.menu(num);
		List<MenuOptionVo> menu_optionList = store_service.menu_optionList();
		System.out.println(menu_optionList);
		
		int max_menu_num=0;
		if(menu_service.max_menu_num()!=null) {
			max_menu_num=Integer.parseInt(menu_service.max_menu_num());
		}
		int max_menu_category_num=0;
		if(menu_service.max_menu_category_num()!=null) {
			max_menu_category_num=Integer.parseInt(menu_service.max_menu_category_num());
		}
		model.addAttribute("max_menu_num",max_menu_num);
		model.addAttribute("max_menu_category_num",max_menu_category_num);
		model.addAttribute("mainMenuList", mainMenuList);
		model.addAttribute("menuCategoryList", menuCategoryList);
		model.addAttribute("menu", menu);
		model.addAttribute("vo", vo);
		model.addAttribute("shop_num", num);
		model.addAttribute("menu_optionList", menu_optionList);

		if (vo == null) {
			return ".owner.error";
		}
		return ".owner.store_manage_home";
	}
}
