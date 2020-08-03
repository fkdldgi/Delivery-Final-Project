package com.jhta.delivery.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.vo.MemberVo;
import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;

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
	//ȸ���� ���� ���� ���� ��ȸ.
	@RequestMapping(value = "/member/personalCoupon")
	public String personalCoupon(int memberNum,Model model) {
		List<HashMap<String, Object>> list1=service.personalcouponlist(memberNum);
		System.out.println("ȸ���� ���� ���� ����Ʈ" + list1);
		model.addAttribute("list1",list1);
		model.addAttribute("list1",list1);
		model.addAttribute("list1",list1);
		model.addAttribute("memberNum", memberNum);
		return ".member.personalCoupon";
	}
	@PostMapping("/member/mypageOk")
	public String changemypage(int num,String email,String tel,String pwd,MultipartFile file1,HttpSession session) {
		System.out.println("5678");
		//���ε��� ���� ��� ������
		String uploadPath=session.getServletContext().getRealPath("/resources/images");
		//���۵� ���ϸ�
		String orgfileName="";
		//���� ������ ���ϸ�(�ߺ����� �ʵ���)
		//UUID.randomUUID() �ߺ������ʴ� �������� ����
		String savefileName="";
		try {
			if(file1.getSize()!=0) {
				//���۵� ���ϸ�
				orgfileName=file1.getOriginalFilename();
				//���� ������ ���ϸ�(�ߺ����� �ʵ���)
				//UUID.randomUUID() �ߺ������ʴ� �������� ����
				savefileName=UUID.randomUUID()+"_"+orgfileName;
				//���۵� ������ �о���� ��Ʈ��
				InputStream fis=file1.getInputStream();
				//���۵� ������ ������ ����(���ε�) �ϱ����� ��½�Ʈ��
				FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
				//���� �����ϱ� 
				FileCopyUtils.copy(fis, fos); //spring�� �����ִ� �޼ҵ�(fis���� �о�ͼ� fos�� ����)
				fis.close();
				fos.close();
			}else {
				savefileName="default.png";
			}
			HashMap<String , Object> map= new HashMap<String, Object>();
			map.put("num", num);
			map.put("email",email);
			map.put("tel",tel);
			map.put("pwd",pwd);
			map.put("img",savefileName);
			int n=service.update(map);
			
			return ".member.mypage";
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".member.error";
		}

	}
	
}
