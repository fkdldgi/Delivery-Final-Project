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
		
		System.out.println("���� ��ȣ : "+num);
		System.out.println("���� ��ȣ : "+owner_num);
		System.out.println("ȸ�� ��ȣ : " + memberNum);
//		System.out.println("���� ����Ʈ : " + memberReviewservice.shopReviewList(num));
		
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		map.put("member_num", memberNum);
//		map.put("shop_num", num);
		
//		model.addAttribute("reviewAble", memberReviewservice.reviewAble(map));
//		System.out.println("���信�̺� : " + memberReviewservice.reviewAble(map));
//		model.addAttribute("memberReviewList", memberReviewservice.selectMemberReview(map));
		List<HashMap<String, Object>> list = memberReviewservice.review_member_list(num);
		
		
		System.out.println("���� ����Ʈ : " + list);
		//{OWNER_NUM=1, IMG=ff8dbb28-c729-438a-b0fc-af8b5dc429e8_irene-kredenets-sV0KXYrb-5s-unsplash.jpg, NUM=15, REGDATE=20/07/21,
		//STEP=0, MEMBER_NUM=1, NAME=��ȿ��, REF=0, GRADE=5, SHOP_NUM=1, GENDER=����, CONTENT=������ ����ϳ׿�..., LEV=0}
		
		//���� ���� �Ǵ��ϱ�
		HashMap<String, Integer> reviewMap = new HashMap<String, Integer>();
		reviewMap.put("shop_num", num);
		reviewMap.put("member_num", memberNum);
		
		
		HashMap<String, Integer> getMenuMap = new HashMap<String, Integer>();
		
		System.out.println("reviewAble ��");
		
		//�����ۼ��� ������ ��
		if(memberReviewservice.reviewAble(reviewMap).size() != 0) {
			System.out.println("�ۼ��� ���䰡 �ֽ��ϴ�.");
			List<Order_MainVo> reviewAble =  memberReviewservice.reviewAble(reviewMap);
			System.out.println("List<Order_MainVo> reviewAble : " + reviewAble);
			
			model.addAttribute("reviewAble", reviewAble.get(0));
			System.out.println("reviewAble : " + reviewAble.get(0));
			
			getMenuMap.put("order_main_num", reviewAble.get(0).getNum());
			System.out.println("order_main_num : " + reviewAble.get(0).getNum());
			
			getMenuMap.put("member_num", memberNum);
			System.out.println("member_num : " + memberNum);
			
			//���� �ֹ��� �޴��� ����(�̸�) �������� �Լ�
			model.addAttribute("menuInfo", memberReviewservice.getMenuNum(getMenuMap));
			System.out.println("menuInfo : " + memberReviewservice.getMenuNum(getMenuMap));
			
			model.addAttribute("order_num",reviewAble.get(0).getNum());
			System.out.println("order_num : " + reviewAble.get(0).getNum());
		}else {//�����ۼ� �Ұ����� ��
			model.addAttribute("reviewAble", "impossible");
			System.out.println("reviewAble�� �����ϴ�");
		}
		
		//������ ���� ����Ʈ
		model.addAttribute("shopReviewList", memberReviewservice.shopReviewList(num));
		model.addAttribute("review_member_list", list);
		model.addAttribute("ownerReview", list);
		//���� �̹��� ������
		model.addAttribute("reviewImg", memberReviewservice.reviewImgList());
		//������ ���� �޴���
		model.addAttribute("mainmenu", sservice.mainMenuList(num));
		//������ ������
		model.addAttribute("info", mservice.storeInfo(num));
		System.out.println("����� ������ ��Ʈ�ѷ� ���� ");
		return ".member.storeDetail";
	}
}
