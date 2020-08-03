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
	//회원이 가진 쿠폰 정보 조회.
	@RequestMapping(value = "/member/personalCoupon")
	public String personalCoupon(int memberNum,Model model) {
		List<HashMap<String, Object>> list1=service.personalcouponlist(memberNum);
		System.out.println("회원이 가진 쿠폰 리스트" + list1);
		model.addAttribute("list1",list1);
		model.addAttribute("list1",list1);
		model.addAttribute("list1",list1);
		model.addAttribute("memberNum", memberNum);
		return ".member.personalCoupon";
	}
	@PostMapping("/member/mypageOk")
	public String changemypage(int num,String email,String tel,String pwd,MultipartFile file1,HttpSession session) {
		System.out.println("5678");
		//업로드할 폴더 경로 얻어오기
		String uploadPath=session.getServletContext().getRealPath("/resources/images");
		//전송된 파일명
		String orgfileName="";
		//실제 저장할 파일명(중복되지 않도록)
		//UUID.randomUUID() 중복되지않는 난수값을 얻어옴
		String savefileName="";
		try {
			if(file1.getSize()!=0) {
				//전송된 파일명
				orgfileName=file1.getOriginalFilename();
				//실제 저장할 파일명(중복되지 않도록)
				//UUID.randomUUID() 중복되지않는 난수값을 얻어옴
				savefileName=UUID.randomUUID()+"_"+orgfileName;
				//전송된 파일을 읽어오는 스트림
				InputStream fis=file1.getInputStream();
				//전송된 파일을 서버에 복사(업로드) 하기위한 출력스트림
				FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
				//파일 복사하기 
				FileCopyUtils.copy(fis, fos); //spring이 갖고있는 메소드(fis에서 읽어와서 fos에 저장)
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
