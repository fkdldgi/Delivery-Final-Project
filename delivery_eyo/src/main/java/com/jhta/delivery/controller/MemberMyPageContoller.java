package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.vo.MemberVo;

@Controller
public class MemberMyPageContoller {
	@Autowired
	private MemberService service;
	@RequestMapping(value = "/member/mypage")
	public String mypagegetinfo(String memberNum,Model model) {
		System.out.println(memberNum);
		MemberVo vo=service.memberInfo(Integer.parseInt(memberNum));
		System.out.println("11");
		model.addAttribute("vo",vo);
		return ".member.mypage";
	}
	@PostMapping("/member/mypageOk")
	public String changemypage(int num,String email,String tel,String pwd,MultipartFile file1,HttpSession session) {
		System.out.println("5678");
		//���ε��� ���� ��� ������
		String uploadPath=session.getServletContext().getRealPath("/resources/images");
		//���۵� ���ϸ�
		String orgfileName=file1.getOriginalFilename();
		//���� ������ ���ϸ�(�ߺ����� �ʵ���)
		//UUID.randomUUID() �ߺ������ʴ� �������� ����
		String savefileName=UUID.randomUUID()+"_"+orgfileName;
		HashMap<String , Object> map= new HashMap<String, Object>();
		map.put("num", num);
		map.put("email",email);
		map.put("tel",tel);
		map.put("pwd",pwd);
		map.put("img",savefileName);
		int n=service.update(map);
		
		if (n>0) {
			return ".member.mypage";
		}else {
			return ".member.error";
		}
	}
	
}
