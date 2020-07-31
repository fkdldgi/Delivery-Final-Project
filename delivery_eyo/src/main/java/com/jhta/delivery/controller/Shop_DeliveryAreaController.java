package com.jhta.delivery.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhta.delivery.service.Delivery_LocationService;
import com.jhta.delivery.service.ShopService;
import com.jhta.delivery.vo.Delivery_LocationVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Shop_DeliveryAreaController {
	@Autowired
	private Delivery_LocationService del_LocService;
	
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/owner/shop/deliveryLocation")
	public String deliveryLocation(int num,Model model) {
		ShopVo vo=shopService.selectShop(num);
		model.addAttribute("vo",vo);
		return ".owner.shop.delivery_area";
	}
	@PostMapping("/owner/shop/deliveryLocation")
	public String deliveryLocationOk(HttpServletRequest req) {
		
		int num=Integer.parseInt(req.getParameter("num"));
		Delivery_LocationVo locVo=del_LocService.selectLoc(num);
		String originalSido=locVo.getSido();
		String originalSigungu=locVo.getSigungu();
		
		String delivery_sido=req.getParameter("delivery_sido"); //배달지역 시,도
		String delivery_sigungu=req.getParameter("delivery_sigungu"); //배달지역 시,군,구
		//배달지역 동 or 리 배열
		String[] addr_names= req.getParameterValues("addr_name");
		String delivery_area=""; //배달지역 동 or 리
		for(int i=0; i<addr_names.length; i++) {
			if(i==addr_names.length-1) {
				delivery_area+=addr_names[i];
			}else {
				delivery_area+=addr_names[i]+",";
			}
		}
		HashMap<String, Object> map=new HashMap<String, Object>();
		if(originalSido.equals(delivery_sido) && originalSigungu.equals(delivery_sigungu)) {
			map.put("hname", delivery_area);
			map.put("num",num);
			del_LocService.update(map);
		}else {
			map.put("num",num);
			map.put("sido",delivery_sido);
			map.put("sigungu",delivery_sigungu);
			map.put("hname",delivery_area);
			try {
				del_LocService.deliveryUpdate(map);
			}catch(Exception e) {
				e.printStackTrace();
				return ".owner.error";
			}
		}
		return ".owner.success";
	}
}











