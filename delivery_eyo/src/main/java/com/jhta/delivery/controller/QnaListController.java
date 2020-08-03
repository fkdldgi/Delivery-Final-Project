package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		//페이지 유틸 사용하기
		int totalRowCount=service.count(map);
		PageUtill pu= new PageUtill(pageNum, totalRowCount, 10, 10);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("memberNum", memberNum);
		
	
		List<QnaVo> list= service.qnaList(map);
		model.addAttribute("startRow",pu.getStartRow());
		model.addAttribute("endRow",pu.getEndRow());
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		model.addAttribute("memberNum",memberNum);

		return ".member.QnaList";
	}
	
	@GetMapping("/member/qnaDetail")
	public String qnadetail(int num,Model model) {
		QnaVo vo=service.detail(num);//상세글 정보
		QnaVo next = service.next(num);//다음글
		QnaVo pre = service.pre(num);//이전글
		model.addAttribute("vo",vo);
		model.addAttribute("next",next);
		model.addAttribute("pre",pre);
		return ".member.qnaDetail";
		
	}
	@RequestMapping("/member/qna")
	public String qna() {
		return ".member.qna";
	}
	@RequestMapping(value = "/member/personalQna",method=RequestMethod.GET)
	public String qnainsert() {
		return ".member.personalQna";
	}
	@PostMapping("/member/insertQnaOk")
	public String insertQnaOk(QnaVo vo) {
		int n=service.insert(vo);
		if (n>0) {
			return ".member.insertQnaOk";	
		}else {
			return ".member.error";
		}
	}
	
	@PostMapping("/member/personalQna")
	public String qnainsertOk(QnaVo vo) {
//		System.out.println("인서트 컨트롤러 접속");
//		System.out.println(vo.getMemberNum());
		try {
			System.out.println("qnaVo" + vo);
			service.insert(vo);
			//성공하면 다시 리스트로 돌아가도록
			System.out.println("인서트 성공!");
			return ".member.QnaList";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return "error";
		}
	}
}
