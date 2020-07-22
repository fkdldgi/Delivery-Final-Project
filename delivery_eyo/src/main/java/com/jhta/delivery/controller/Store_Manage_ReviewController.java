package com.jhta.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.Owner_ReviewService;
import com.jhta.delivery.vo.Owner_ReviewVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Store_Manage_ReviewController {
	
	@Autowired
	private OwnerService owner_service;
	
	@Autowired
	private Owner_ReviewService owner_review_service;

	@RequestMapping("/owner/store_manage/review")
	public String manage_Ad(Model model, int num) {
		
		ShopVo vo = owner_service.shop_select(num);
		List<Owner_ReviewVo> reviewList = owner_review_service.ownerReviewList(num);
		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("vo", vo);
		return ".owner.store.store_manage_review";
	}
}