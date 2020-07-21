package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jhta.delivery.service.QnaService;
import com.jhta.delivery.vo.QnaVo;
import com.jhta.page.utill.PageUtill;

@Controller
public class QnaListController {
	@Autowired
	private QnaService service;
	@GetMapping("/member/QnaList")
	public String qnaList(Model model,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
		String field,String keyword,int memberNum) {
		HashMap<String , Object> map = new HashMap<String, Object>();
		//�˻����� map�� ���
		map.put("field", field);
		map.put("keyword", keyword);
		
		//������ ��ƿ ����ϱ�
		int totalRowCount=service.count(map);
		PageUtill pu= new PageUtill(pageNum, totalRowCount, 10, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("memberNum", memberNum);
		
		System.out.println(memberNum);
		List<QnaVo> list= service.qnaList(map);
		model.addAttribute("startRow",pu.getStartRow());
		model.addAttribute("endRow",pu.getEndRow());
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		model.addAttribute("field",field);
		model.addAttribute("keyword",keyword);
		model.addAttribute("memberNum",memberNum);
		
		return ".member.QnaList";
	}
}
