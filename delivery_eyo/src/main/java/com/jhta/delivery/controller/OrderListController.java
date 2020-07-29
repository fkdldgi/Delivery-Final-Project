package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.OrderListService;

@Controller
public class OrderListController {
	@Autowired
	private OrderListService service;
	@RequestMapping("/member/orderList")  
	public String orderListSelect(int memberNum,Model model) {
		List<HashMap<String, Object>> list1= service.OrderList(memberNum);
		model.addAttribute("list1", list1);
		model.addAttribute("memberNum", memberNum);
		return ".member.orderList";
	}
}
