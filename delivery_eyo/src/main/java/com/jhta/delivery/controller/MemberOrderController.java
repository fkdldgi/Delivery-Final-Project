package com.jhta.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.service.Order_MainService;
import com.jhta.delivery.service.Order_MenuService;
import com.jhta.delivery.service.Order_Menu_OptionService;
import com.jhta.delivery.vo.MemberVo;

@Controller
public class MemberOrderController {
	@Autowired
	private MemberService memService;
	@Autowired
	private Order_MenuService menuService;
	@Autowired
	private Order_Menu_OptionService optionService;
	@Autowired
	private Order_MainService mainService;
	
	//주문 페이지로 이동하는 컨트롤러
	@RequestMapping("/member/orderPage")
	public String orderPage(Model model,String orderList,String memberId,int shopNum) {
		System.out.println("주문 컨트롤러 접속");
		String split1 [] = orderList.split(";");
		String id = memberId.substring(1, memberId.length()-1);
		ArrayList<LinkedHashMap<String, String>> list2 = new ArrayList<LinkedHashMap<String,String>>();
		
		for(int i=0; i<split1.length; i++) {
			String split2 [] = split1[i].split(",");
			LinkedHashMap<String, String> lmap = new LinkedHashMap<String, String>();
			for(int j=0; j<split2.length; j++) {
				if(j==0) {
					lmap.put("num", split2[j]);
				}else if(j==1) {
					lmap.put("volume", split2[j]);
				}else {
					lmap.put("option"+(j-1), split2[j]);
				}
			}
			list2.add(lmap);
		}
		for(int i=0; i<list2.size(); i++) {	
			System.out.println("리스트2의 값 : " + list2.get(i));
		}
		System.out.println("자른 아이디 : " + id);
		MemberVo memVo = memService.idChk(id);
		System.out.println("멤버 vo : " + memVo);
		
		model.addAttribute("member", memVo);
		model.addAttribute("shopNum", shopNum);
		System.out.println("가게 번호 : " + shopNum);
		return ".member.memberOrder";
	}
	
	@RequestMapping("/member/order")
	public String order() {
		return "";
	}
}
