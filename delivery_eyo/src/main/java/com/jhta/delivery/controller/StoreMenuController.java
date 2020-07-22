package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jhta.delivery.service.StoreService;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;

@Controller
public class StoreMenuController {
	@Autowired
	private StoreService sservice;
	
	//특정 메뉴의 옵션메뉴를 받아서 모달창에 보내주기
	@RequestMapping(value="/store/menu_option",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String option_menu(@RequestBody String snum){
		int num=Integer.parseInt(snum);
		List<MenuOptionVo> optionList = sservice.optionInfo(num);
		MenuVo menuInfo = sservice.menuInfo(num);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menuInfo",menuInfo);
		map.put("optionList", optionList);
		Gson gson=new Gson();
		String jsonString=gson.toJson(map);
		return jsonString;
	}
}
