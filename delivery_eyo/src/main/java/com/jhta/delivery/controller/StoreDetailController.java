package com.jhta.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.MemberReviewService;
import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.service.StoreService;

@Controller
public class StoreDetailController {
	@Autowired
	private MemberService mservice;
	@Autowired
	private StoreService sservice;
	@Autowired
	private MemberReviewService memberReviewservice;
	
	@RequestMapping("/member/storeDetail")
	public String storeInfo(Model model,int num,int owner_num,int memberNum) {
		
		System.out.println("가게 번호 : "+num);
		System.out.println("사장 번호 : "+owner_num);
		System.out.println("회원 번호 : " + memberNum);
		
		
		
		model.addAttribute("info", mservice.storeInfo(num));
		model.addAttribute("mainmenu", sservice.mainMenuList(num));
		model.addAttribute("shopReviewList", memberReviewservice.shopReviewList(num));
		model.addAttribute("reviewImg", memberReviewservice.reviewImgList());
		
		return ".member.storeDetail";
	}
}
