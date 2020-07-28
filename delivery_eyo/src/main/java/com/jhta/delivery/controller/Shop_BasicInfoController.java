package com.jhta.delivery.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.ShopService;
import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class Shop_BasicInfoController {
	@Autowired
	private ShopService shopService;
	
	@GetMapping("/owner/shop/basicinfo")
	public String basicinfo(int num,Model model) {
		ShopVo vo=shopService.selectShop(num);
		model.addAttribute("vo",vo);
		return ".owner.shop.basic_info";
	}
	
	@PostMapping("/owner/shop/basicinfo")
	public String basicinfoOk(MultipartFile file1,HttpServletRequest req,HttpSession session,Model model) {
		//업로드할 폴더 경로 얻어오기
		String uploadPath=session.getServletContext().getRealPath("/resources/profile");
		//전송된 파일명
		String orgfileName=file1.getOriginalFilename();
		//실제 저장할 파일명(중복되지 않도록)
		//UUID.randomUUID() 중복되지않는 난수값을 얻어옴
		String savefileName=UUID.randomUUID()+"_"+orgfileName;
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
			int num=Integer.parseInt(req.getParameter("shopNum"));
			String profile_img=savefileName; //가게프로필 사진 파일명
			String introduce=req.getParameter("introduce"); //가게소개
			String info=req.getParameter("info"); //안내
			String review_info=req.getParameter("review_info");
			String tel=req.getParameter("tel"); //전화번호
			int status=Integer.parseInt(req.getParameter("status")); //가게상태(open,close)
			
			//가게정보
			ShopVo vo=shopService.selectShop(num);
			model.addAttribute("vo",vo);
			
			//가게정보 업데이트
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("profile_img",profile_img);
			map.put("introduce",introduce);
			map.put("info",info);
			map.put("review_info",review_info);
			map.put("tel",tel);
			map.put("status",status);
			map.put("num",num);
			shopService.basic_info_update(map);
			
			return ".owner.success";
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return ".owner.error";
		}
	}
}
