package com.jhta.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.Delivery_LocationService;
import com.jhta.delivery.service.Delivery_TipService;
import com.jhta.delivery.service.ShopService;
import com.jhta.delivery.vo.Delivery_LocationVo;
import com.jhta.delivery.vo.Delivery_TipVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Shop_OrderInfoController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private Delivery_LocationService del_locService;
	
	@Autowired
	private Delivery_TipService del_tipService;
	
	@GetMapping("/owner/shop/orderinfo")
	public String orderinfo(int num,Model model) {
		ShopVo shopVo=shopService.selectShop(num);
		Delivery_LocationVo del_locVo=del_locService.selectLoc(num); //배달지역 VO
		List<Delivery_TipVo> list=del_tipService.selectTip(num); //배달팁지역 리스트
		

		//이미 설정한 배달팁 지역의 행정동을 저장할 List
		List<String> tip_hnameList=new ArrayList<String>();
		for(Delivery_TipVo vo:list) {
			String tip_hname=vo.getHname();
			String[] tip_hnames=tip_hname.split(",");
			for(String hname:tip_hnames) {
				tip_hnameList.add(hname);
			}
		}
		
		//배달지역의 행정동을 저장 할 리스트
		List<String> loc_hnameList=new ArrayList<String>();
		String loc_getHname=del_locVo.getHname(); //배달지역 행정동
		String[] loc_hnames=loc_getHname.split(","); //배달지역 행정동을 ,로 쪼갬
		for(String loc_hname:loc_hnames) {
			loc_hnameList.add(loc_hname);
		}
		
		//배달지역의 행정동에 이미 설정한 배달팁 행정동이 있는경우 삭제
		for(int i=0; i<loc_hnameList.size(); i++) {
			for(int j=0; j<tip_hnameList.size(); j++) {
				if(loc_hnameList.get(i).equals(tip_hnameList.get(j))) {
					loc_hnameList.remove(i);
				}
			}
		}
		
		model.addAttribute("tipList",loc_hnameList);
		model.addAttribute("vo",shopVo);
		model.addAttribute("del_locVo",del_locVo);
		return ".owner.shop.order_info";
	}
	@PostMapping("/owner/shop/orderinfo")
	public String orderinfoOk(int num,String min_price) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("num", num);
		map.put("min_price",min_price);
		int n=shopService.min_price_update(map);
		if(n>0) {
			return ".owner.success";
		}else {
			return ".owner.error";
		}
	}
}
