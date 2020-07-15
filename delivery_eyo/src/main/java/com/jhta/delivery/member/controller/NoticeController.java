package com.jhta.delivery.member.controller;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.delivery.member.service.NoticeService;
import com.jhta.delivery.member.vo.NoticeVo;
import com.jhta.page.utill.PageUtill;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService service;	
	@GetMapping("/member/notice")  
	public String noticeList(Model model , @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
			String field,String keyword) {
			HashMap<String , Object> map = new HashMap<String, Object>();
			//검색조건 map에 담기
			map.put("field", field);
			map.put("keyword", keyword);
			
			//페이지 유틸 사용하기
			int totalRowCount=service.count(map);
			PageUtill pu= new PageUtill(pageNum, totalRowCount, 10, 10);
			map.put("startRow", pu.getStartRow());
			map.put("endRow", pu.getEndRow());
			
			List<NoticeVo> list= service.noticeList(map);
			model.addAttribute("startRow",pu.getStartRow());
			model.addAttribute("endRow",pu.getEndRow());
			model.addAttribute("list",list);
			model.addAttribute("pu",pu);
			model.addAttribute("field",field);
			model.addAttribute("keyword",keyword);
			
			return ".member.notice";
		}
}

