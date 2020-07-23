package com.jhta.delivery.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.Owner_ReviewService;
import com.jhta.delivery.vo.Owner_ShopRereviewVo;
import com.jhta.delivery.vo.Owner_ShopReviewVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Store_Manage_ReviewController {
	
	@Autowired
	private OwnerService owner_service;
	
	@Autowired
	private Owner_ReviewService owner_review_service;
	
	// ó���� ������� ����
	@RequestMapping("/owner/store_manage/review")
	public String manage_review(Model model, int num) {
		
		ShopVo vo = owner_service.shop_select(num);
		
		// ���Կ����� ����
		List<Owner_ShopReviewVo> shopReviewList = owner_review_service.shopReview(vo.getNum());
		// ���ȸ�� ���
		List<Owner_ShopRereviewVo> shopRereviewList = owner_review_service.shopRereview(vo.getNum());
		
		model.addAttribute("shopReviewList", shopReviewList);
		model.addAttribute("shopRereviewList", shopRereviewList);
		model.addAttribute("vo", vo);
		
		return ".owner.store.store_manage_review";
	}
	
	// ���� ���
	@PostMapping("/owner/store_manage/insertReview")
	public String manage_Review(Model model, Owner_ShopRereviewVo vo) {
		ShopVo shop_vo = owner_service.shop_select(vo.getShop_num());
		
		vo.setOwner_num(shop_vo.getOwner_num());
		
		System.out.println(vo.getContent());
		System.out.println(vo.getRegdate());
		System.out.println(vo.getRef());
		System.out.println(vo.getShop_num());
		
		// ������
		owner_review_service.insert_OwnerRereview(vo);
		
		// ��������� �ٽ� ���ư���(manage_review ���)
		model.addAttribute("num", shop_vo.getNum());
		return manage_review(model, shop_vo.getNum());
	}
}













