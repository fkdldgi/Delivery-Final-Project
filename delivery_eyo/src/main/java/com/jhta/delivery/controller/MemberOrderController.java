package com.jhta.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.Order_MainService;
import com.jhta.delivery.service.Order_MenuService;
import com.jhta.delivery.service.Order_Menu_OptionService;

@Controller
public class MemberOrderController {
	@Autowired
	private Order_MenuService menuService;
	@Autowired
	private Order_Menu_OptionService optionService;
	@Autowired
	private Order_MainService mainService;
	
	@RequestMapping("/member/orderPage")
	public String orderPage(Model model,String orderList) {
	//	{1,2,3,4,5,6 ; 4,5,6}
		String split1 [] = orderList.split(";");
	
		ArrayList<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		ArrayList<LinkedHashMap<String, String>> list2 = new ArrayList<LinkedHashMap<String,String>>();
		
		for(int i=0; i<=split1.length-1; i++) {
			String split2 [] = split1[i].split(",");
			LinkedHashMap<String, String> lmap = new LinkedHashMap<String, String>();
			HashMap<String, String> map=new HashMap<String, String>();
			for(int j=0; j<=split2.length-1; j++) {
				if(j==0) {
					map.put("num", split2[j]);
					lmap.put("num", split2[j]);
				}else if(j==1) {
					map.put("volume",split2[j]);
					lmap.put("volume", split2[j]);
				}else {
					map.put("option"+j,split2[j]);
					lmap.put("option"+j, split2[j]);
				}
			}
			list.add(map);
			list2.add(lmap);
		}
		for(int i=0; i<list.size(); i++) {
			System.out.println(list2.get(i));
		}
		//System.out.println(list.get(1));
//		for(int i=0; i<split1.length-1; i++){ //담은 메뉴의 수만큼 행이 나오도록 length의 길이를 조절했음
//			String split2 [] = split1[i].split(",");
//			for(int j=0; j<split2.length; j++){
//				System.out.println("스플릿 값 : " + split2[j]);
//			}
//		}
		return "#";
		//return ".member.memberOrder";
	}
}
