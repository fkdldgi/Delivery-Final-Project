package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.delivery.service.NoticeService;
import com.jhta.delivery.vo.NoticeVo;
import com.jhta.page.utill.PageUtill;

@Controller
public class Owner_BoardController {
	@Autowired
	private NoticeService service;
	@RequestMapping(value = "/owner/board")
	public String home(Model model, @RequestParam(value="pageNum", defaultValue="1") int pageNum,
		String field,String keyword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//�˻����� map�� ���
		map.put("field", field);
		map.put("keyword", keyword);
		
		//������ ��ƿ ���
		int totalRowCount = service.Owner_noticeCount(map);
		PageUtill pu = new PageUtill(pageNum, totalRowCount,10, 10 );
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		
		//���ȸ�� ���� ����Ʈ
		List<NoticeVo> list = service.Owner_noticeList(map);
		model.addAttribute("startRow",pu.getStartRow());
		model.addAttribute("endRow",pu.getEndRow());
		model.addAttribute("pu", pu);
		model.addAttribute("list", list);
		model.addAttribute("field", field);
		model.addAttribute("keyword", keyword);
	
		return ".owner.board";	// tiles.xml�� ������ tiles�̸� ����
	}
}
