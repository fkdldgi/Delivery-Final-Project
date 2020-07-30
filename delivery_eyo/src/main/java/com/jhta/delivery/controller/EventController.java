package com.jhta.delivery.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.Member_EventService;
import com.jhta.delivery.vo.Coupon_publishVo;

@Controller
public class EventController {
	@Autowired
	private Member_EventService service;
	
	@RequestMapping("/member/event_main")
	public String event() {
		
		return ".member.event_main";
	}
	@RequestMapping("/member/event01")
	public String event01(Model model,int coupon_num,int memberNum) {
		model.addAttribute("coupon_num",coupon_num);
		model.addAttribute("memberNum",memberNum);
		return ".member.event01";
	}
	@RequestMapping("/member/event02")
	public String event02(Model model,int coupon_num,int memberNum) {
		model.addAttribute("coupon_num",coupon_num);
		model.addAttribute("memberNum",memberNum);
		return ".member.event02";
	}
	@RequestMapping("/member/event03")
	public String event03(Model model,int coupon_num,int memberNum) {
		model.addAttribute("coupon_num",coupon_num);
		model.addAttribute("memberNum",memberNum);
		return ".member.event03";
	}
	@RequestMapping("/member/event04")
	public String event04(Model model,int coupon_num,int memberNum) {
		model.addAttribute("coupon_num",coupon_num);
		model.addAttribute("memberNum",memberNum);
		return ".member.event04";
	}
	
	
	@RequestMapping("/member/event")
	@ResponseBody
	public int event01(int coupon_num,int memberNum) {
		System.out.println(coupon_num);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("coupon_num", coupon_num);
		map.put("memberNum", memberNum);
		Coupon_publishVo cvo=service.selectcoupon(map);
		System.out.println(cvo);
		if(cvo!=null) { //ÀÌ¹Ì ÄíÆù¹ß±ÞµÊ
			
			return 0;
		}else { //ÄíÆù¹ß±Þ °¡´É
			//ÄíÆù¹ß±ÞÇÏ±â
			return 1;
		}


	}
}
