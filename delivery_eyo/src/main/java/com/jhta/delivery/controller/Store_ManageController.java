package com.jhta.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Owner_CheckMenuVo;
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

		if (id == null || id == "") {
			return ".owner.error"; // 이거 수정해요
		} else {
			return ".owner.store_manage";
		}
	}

	@PostMapping("/owner/store_manage") // 배열로 받아야함
	public String manage_update(Model model, HttpServletRequest req, @RequestParam(value = "owner_id") String id,
			@RequestParam(value = "Shop_num") int shop_num, @RequestParam(value = "shop_info") String shop_info,
			// 카테고리 번호
			@RequestParam(value = "category_num") List<String> category_num,
			// 카테고리명
			@RequestParam(value = "menu_category_name") List<String> menu_category_name,
			// 메뉴이름
			@RequestParam(value = "menu_name") List<String> menu_name,
			// 메뉴정보
			@RequestParam(value = "menu_info") List<String> menu_info,
			// 메뉴가격
			@RequestParam(value = "min_price") List<String> min_price,
			// 메뉴번호
			@RequestParam(value = "menu_num") List<String> menu_num,
			// 메뉴가 속해있는 카테고리 번호
			@RequestParam(value = "category_list_num") List<String> category_list_num,
			// 메뉴옵션이 속해있는 메뉴
			@RequestParam(value="option_menu_num") List<String> option_menu_num,
			@RequestParam(value = "trash_category", required = false) List<String> trash_category,
			@RequestParam(value = "trash", required = false) List<String> trash) {
		
		
		System.out.println("카테고리번호: "+category_num);
		System.out.println("카테고리이믈: "+menu_category_name);
		System.out.println();
		System.out.println("메뉴이름: "+menu_name);
		System.out.println("메뉴정보: "+menu_info);
		System.out.println("메뉴가격:"+min_price);
		System.out.println("메뉴번호: "+menu_num);
		System.out.println("메뉴카테고리번호:"+category_list_num);
		System.out.println("메뉴옵션메뉴번호: "+option_menu_num);
		
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

		List<MenuVo> MenuVoList = new ArrayList<>();
		List<MenuCategoryVo> menuCateogryList = new ArrayList<>();

		for (int i = 0; i < min_price.size(); i++) {
			MenuCategoryVo vo = new MenuCategoryVo();
			
			int category_numVo = Integer.parseInt(category_num.get(i));
			String menu_category_nameVo = menu_category_name.get(category_num.indexOf(category_list_num.get(i)));
			
			vo.setNum(category_numVo);
			vo.setName(menu_category_nameVo);
			
			// insertupdate MenuCategoryVo
			store_service.insertUpdate_MenuCategory(vo);
			
			// vo에 값넣기
			for (int j = 0; j < min_price.size(); j++) {
				MenuVo vo11 = new MenuVo();
				
				int menu_numVo = Integer.parseInt(menu_num.get(i)); // 메뉴 번호
				String menu_nameVo = menu_name.get(i); // 메뉴 명
				String menu_infoVo = menu_info.get(i); // 메뉴 설명
				int min_priceVo = Integer.parseInt(min_price.get(i)); // 메뉴 가격
				int category_numVo1 = Integer.parseInt(category_list_num.get(i)); // 카테고리 번호
				
				vo11.setNum(menu_numVo);
				vo11.setName(menu_nameVo);
				vo11.setMenu_info(menu_infoVo);
				vo11.setPrice(min_priceVo);
				vo11.setMenu_category_num(category_numVo1);
				
				// insertupdate MenuVo
				store_service.insertUpdate_Menu(vo11);
			}
		}


		// 메뉴옵션 가져오기
		if (req.getParameterValues("option_name") != null) {
			
			for (int i = 0; i < req.getParameterValues("option_name").length; i++) {
				
				int num_option = Integer.parseInt(req.getParameterValues("option_num")[i]);
				String name_option = req.getParameterValues("option_name")[i];
				int price_option = Integer.parseInt(req.getParameterValues("option_price")[i]);
				String category_option = req.getParameterValues("option_category")[i];
				int menu_num_option = Integer.parseInt(req.getParameterValues("option_menu_num")[i]);
				
				MenuOptionVo vo1 = 
						new MenuOptionVo(num_option, name_option, price_option, category_option, menu_num_option);
				
				store_service.insertUpdate_MenuOption(vo1);
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
		
		int max_menu_num=menu_service.max_menu_num();
		int max_menu_category_num=menu_service.max_menu_category_num();
		System.out.println();
		model.addAttribute("max_menu_num",max_menu_num);
		model.addAttribute("max_menu_category_num",max_menu_category_num);
		model.addAttribute("mainMenuList", mainMenuList);
		model.addAttribute("menuCategoryList", menuCategoryList);
		model.addAttribute("menu", menu);
		model.addAttribute("vo", vo);
		model.addAttribute("Shop_num", num);
		model.addAttribute("menu_optionList", menu_optionList);

		if (vo == null) {
			return ".owner.error";
		}
		return ".owner.store_manage_home";
	}
}
