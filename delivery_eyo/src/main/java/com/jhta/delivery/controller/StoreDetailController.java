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
		List<HashMap<String, Object>> list = memberReviewservice.review_member_list(num);
		//���� ���� �Ǵ��ϱ�
		HashMap<String, Integer> reviewMap = new HashMap<String, Integer>();
		reviewMap.put("shop_num", num);
		reviewMap.put("member_num", memberNum);
		HashMap<String, Integer> getMenuMap = new HashMap<String, Integer>();
		//�����ۼ��� ������ ��
		if(memberReviewservice.reviewAble(reviewMap).size() != 0) {
			System.out.println("�ۼ��� ���䰡 �ֽ��ϴ�.");
			List<Order_MainVo> reviewAble =  memberReviewservice.reviewAble(reviewMap);
			System.out.println("List<Order_MainVo> reviewAble : " + reviewAble);
			model.addAttribute("reviewAble", reviewAble.get(0));
			getMenuMap.put("order_main_num", reviewAble.get(0).getNum());
			getMenuMap.put("member_num", memberNum);
			//���� �ֹ��� �޴��� ����(�̸�) �������� �Լ�
			model.addAttribute("menuInfo", memberReviewservice.getMenuNum(getMenuMap));
			model.addAttribute("order_num",reviewAble.get(0).getNum());
		}else {//�����ۼ� �Ұ����� ��
			model.addAttribute("reviewAble", "impossible");
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
		return ".member.storeDetail";
	}
}
