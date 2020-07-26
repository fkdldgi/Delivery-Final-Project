package com.jhta.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.Owner_OrderService;
import com.jhta.delivery.vo.Owner_OrderVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Store_Manage_OrderController {
	
	@Autowired
	private OwnerService owner_service;
	
	// 가게주문관리
	@Autowired
	private Owner_OrderService owner_order_service;
	
	@RequestMapping("/owner/store_manage/order")
	public String manage_order(Model model, int num) {
		
		ShopVo vo = owner_service.shop_select(num);
		
		// 가게주문확인
		List<Owner_OrderVo> orderList = owner_order_service.owner_orderList(vo.getNum());
		
		// 가게주문 승인
		List<Owner_OrderVo> successList = owner_order_service.owner_successList(vo.getNum());
		
		model.addAttribute("vo", vo);
		model.addAttribute("orderList",orderList);
		model.addAttribute("successList",successList);
		
		return ".owner.store.store_manage_order";
	}
	
	@PostMapping("/owner/store_manage/order_accept")
	public String manage_order_accept(Model model, int num, Owner_OrderVo vo) {
		
		System.out.println(vo.getMain_num());
		System.out.println(vo.getEnd_ex_time());
		
		vo.setStatus("주문승인");
		
		int n = owner_order_service.update_end_ex_time(vo);
		
		System.out.println(n);
		
		return manage_order(model,num);
	}
}