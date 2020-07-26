package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.MemberReviewService;
import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.service.StoreService;
import com.jhta.delivery.vo.ReviewVo;

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
		
		System.out.println("���� ��ȣ : "+num);
		System.out.println("���� ��ȣ : "+owner_num);
		System.out.println("ȸ�� ��ȣ : " + memberNum);
		
		System.out.println("���� ����Ʈ : " + memberReviewservice.shopReviewList(num));
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("member_num", memberNum);
		map.put("shop_num", num);
		
		model.addAttribute("reviewAble", memberReviewservice.reviewAble(map));
		System.out.println("���信�̺� : " + memberReviewservice.reviewAble(map));
		model.addAttribute("memberReviewList", memberReviewservice.selectMemberReview(map));
		model.addAttribute("info", mservice.storeInfo(num));
		model.addAttribute("mainmenu", sservice.mainMenuList(num));
		model.addAttribute("shopReviewList", memberReviewservice.shopReviewList(num));
		model.addAttribute("reviewImg", memberReviewservice.reviewImgList());
		
		return ".member.storeDetail";
	}
}
