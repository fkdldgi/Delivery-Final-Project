package com.jhta.delivery.controller;


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
			return ".owner.error"; // �̰� �����ؿ�
		} else {
			return ".owner.store_manage";
		}
	}

	@PostMapping("/owner/store_manage") // �迭�� �޾ƾ���
	public String manage_update(Model model, HttpServletRequest req,
			@RequestParam(value = "owner_id") String id,
			@RequestParam(value = "trash_category", required = false) List<String> trash_category,
			@RequestParam(value = "trash", required = false) List<String> trash) {
		
		//���Թ�ȣ
		int shop_num=Integer.parseInt(req.getParameter("shop_num"));
		//ī�װ�
		String[] category_numArr=req.getParameterValues("category_num");
		String[] menu_category_nameArr=req.getParameterValues("menu_category_name");
		//�޴�
		String[] menu_numArr=req.getParameterValues("menu_num");
		String[] menu_nameArr=req.getParameterValues("menu_name");
		String[] menu_infoArr=req.getParameterValues("menu_info");
		String[] menu_priceArr=req.getParameterValues("menu_price");
		String[] category_list_numArr=req.getParameterValues("category_list_num");
		//�޴��ɼ�
		String[] option_numArr=req.getParameterValues("option_num");
		String[] option_nameArr=req.getParameterValues("option_name");
		String[] option_priceArr=req.getParameterValues("option_price");
		String[] option_categoryArr=req.getParameterValues("option_category");
		String[] option_menu_numArr=req.getParameterValues("option_menu_num");
		
		
		//ī�װ� for��
		for(int i=0; i<category_numArr.length; i++) {
			int category_num=Integer.parseInt(category_numArr[i]);
			String category_name=menu_category_nameArr[i];
			if(store_service.select_menu_categoryOne(category_num)==null) {
				//ī�װ� �߰�
				MenuCategoryVo categoryVo=new MenuCategoryVo(0,category_name,0,shop_num,0);
				int n=store_service.insertMenu_Category(categoryVo);
			}else {
				//ī�װ� ������Ʈ
				
			}
			//�޴� for��
			for(int j=0; j<menu_numArr.length; j++) {
				int menu_num=Integer.parseInt(menu_numArr[j]);
				if(store_service.select_menuOne(menu_num)==null) {
					//�߰�
					
				}else {
					//������Ʈ
					
				}
				
				//�޴��ɼ� for��
				for(int k=0; k<option_numArr.length; k++) {
					int option_num=Integer.parseInt(option_numArr[k]);
					if(store_service.select_menu_optionOne(option_num)==null) {
						//�߰�
						
					}else {
						//������Ʈ
						
					}
				}
			}
		}
		
		
		// �޴��ɼ� �����ϱ�
		if(req.getParameterValues("delete_menu_option") != null) {
			
			for(int i = 0; i < req.getParameterValues("delete_menu_option").length; i++) {
				
				int a = Integer.parseInt(req.getParameterValues("delete_menu_option")[i]);
				store_service.delete_menu_option(a);
			}
		}
		
		// ������ �޴�ī�װ���ȣ�� �޴�ī�װ� DB���� ����
		if (trash_category != null) {
			for (String trash_category_string : trash_category) {
				int trash_category_num = Integer.parseInt(trash_category_string);
				store_service.deleteMenu_Category(trash_category_num);
			}
		}
		
		// ������ �޴���ȣ�� �޴� DB���� ����
		if (trash != null) {
			for (String trash_string : trash) {
				int trash_num = Integer.parseInt(trash_string);
				store_service.deleteMenu(trash_num);
			}
		}

		
		
		// ��ü ���԰� �ִ� �������� �̵�
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
		model.addAttribute("shop_num", num);
		model.addAttribute("menu_optionList", menu_optionList);

		if (vo == null) {
			return ".owner.error";
		}
		return ".owner.store_manage_home";
	}
}
