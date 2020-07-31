package com.jhta.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.MemberReviewService;
import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.service.StoreService;
import com.jhta.delivery.vo.Order_MainVo;
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
		
		System.out.println("가게 번호 : "+num);
		System.out.println("사장 번호 : "+owner_num);
		System.out.println("회원 번호 : " + memberNum);
//		System.out.println("리뷰 리스트 : " + memberReviewservice.shopReviewList(num));
		
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		map.put("member_num", memberNum);
//		map.put("shop_num", num);
		
//		model.addAttribute("reviewAble", memberReviewservice.reviewAble(map));
//		System.out.println("리뷰에이블 : " + memberReviewservice.reviewAble(map));
//		model.addAttribute("memberReviewList", memberReviewservice.selectMemberReview(map));
		List<HashMap<String, Object>> list = memberReviewservice.review_member_list(num);
		
		
		System.out.println("리뷰 리스트 : " + list);
		//{OWNER_NUM=1, IMG=ff8dbb28-c729-438a-b0fc-af8b5dc429e8_irene-kredenets-sV0KXYrb-5s-unsplash.jpg, NUM=15, REGDATE=20/07/21,
		//STEP=0, MEMBER_NUM=1, NAME=전효진, REF=0, GRADE=5, SHOP_NUM=1, GENDER=여자, CONTENT=가격이 사악하네요..., LEV=0}
		
		//리뷰 조건 판단하기
		HashMap<String, Integer> reviewMap = new HashMap<String, Integer>();
		reviewMap.put("shop_num", num);
		reviewMap.put("member_num", memberNum);
		
		
		HashMap<String, Integer> getMenuMap = new HashMap<String, Integer>();
		
		System.out.println("reviewAble 전");
		
		//리뷰작성이 가능할 때
		if(memberReviewservice.reviewAble(reviewMap).size() != 0) {
			System.out.println("작서할 리뷰가 있습니다.");
			List<Order_MainVo> reviewAble =  memberReviewservice.reviewAble(reviewMap);
			System.out.println("List<Order_MainVo> reviewAble : " + reviewAble);
			
			model.addAttribute("reviewAble", reviewAble.get(0));
			System.out.println("reviewAble : " + reviewAble.get(0));
			
			getMenuMap.put("order_main_num", reviewAble.get(0).getNum());
			System.out.println("order_main_num : " + reviewAble.get(0).getNum());
			
			getMenuMap.put("member_num", memberNum);
			System.out.println("member_num : " + memberNum);
			
			//고객이 주문한 메뉴의 정보(이름) 가져오는 함수
			model.addAttribute("menuInfo", memberReviewservice.getMenuNum(getMenuMap));
			System.out.println("menuInfo : " + memberReviewservice.getMenuNum(getMenuMap));
			
			model.addAttribute("order_num",reviewAble.get(0).getNum());
			System.out.println("order_num : " + reviewAble.get(0).getNum());
		}else {//리뷰작성 불가능할 때
			model.addAttribute("reviewAble", "impossible");
			System.out.println("reviewAble이 없습니다");
		}
		
		//가게의 리뷰 리스트
		model.addAttribute("shopReviewList", memberReviewservice.shopReviewList(num));
		model.addAttribute("review_member_list", list);
		model.addAttribute("ownerReview", list);
		//리뷰 이미지 정보들
		model.addAttribute("reviewImg", memberReviewservice.reviewImgList());
		//가게의 메인 메뉴들
		model.addAttribute("mainmenu", sservice.mainMenuList(num));
		//가게의 정보들
		model.addAttribute("info", mservice.storeInfo(num));
		System.out.println("스토어 디테일 컨트롤러 리턴 ");
		return ".member.storeDetail";
	}
}
