package com.jhta.delivery.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.ShopService;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Shop_OperationInfoController {
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/owner/shop/operationinfo")
	public String operationinfo(int num,Model model) {
		ShopVo vo=shopService.selectShop(num);
		model.addAttribute("vo",vo);
		return ".owner.shop.operation_info";
	}
	@PostMapping("/owner/shop/operationinfo")
	public String operationinfoOk(HttpServletRequest req) {
		int num=Integer.parseInt(req.getParameter("shopNum"));
		String shop_category=""; //가게 카테고리를 담을 문자열
		String payment_option=req.getParameter("payment_option"); //결제방법
		String open_time=req.getParameter("open_time"); //오픈시간
		String close_time=req.getParameter("close_time"); //마감시간
		String personal_day=""; //휴무일
		
		//가게카테고리가 담긴 배열
		String[] shop_categories=req.getParameterValues("shop_category");
		// " " 로 구분
		for(int i=0; i<shop_categories.length; i++) {
			if(i==shop_categories.length-1) {
				shop_category+=shop_categories[i]; //마지막 값이면 공백없이 추가
			}else {
				shop_category+=shop_categories[i]+" "; //마지막 값이 아니면 공백도 추가
			}
		}
		//휴무일이 담긴 배열
		String[] personal_days=req.getParameterValues("personal_day");
		for(int i=0; i<personal_days.length; i++) {
			if(i==personal_days.length-1) {
				personal_day+=personal_days[i]; //마지막 값이면 공백없이 추가
			}else {
				personal_day+=personal_days[i]+","; //마지막 값이 아니면 공백도 추가
			}
		}
		
		//운영정보 업데이트
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("num",num);
		map.put("shop_category",shop_category);
		map.put("payment_option",payment_option);
		map.put("open_time",open_time);
		map.put("close_time",close_time);
		map.put("personal_day",personal_day);
		
		int n=shopService.operation_info_update(map);
		if(n>0) {
			return ".owner.success";
		}else {
			return ".owner.error";
		}
	}
}
