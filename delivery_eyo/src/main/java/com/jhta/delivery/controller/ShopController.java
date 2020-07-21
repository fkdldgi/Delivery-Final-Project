package com.jhta.delivery.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.delivery.service.ShopService;
import com.jhta.delivery.vo.AddressVo;
import com.jhta.delivery.vo.ShopVo;


@Controller
public class ShopController {
	@Autowired
	private ShopService service;
	
	@GetMapping("/owner/shopReg")
	public String shopReg() {
		return ".owner.shopReg";
	}
	
	@PostMapping("/owner/shopReg")
	public String shopReg2(AddressVo addrVo,MultipartFile file1,HttpServletRequest req,HttpSession session) {
		
		//업로드할 폴더 경로 얻어오기
		String uploadPath=session.getServletContext().getRealPath("/resources/profile");
		//전송된 파일명
		String orgfileName=file1.getOriginalFilename();
		//실제 저장할 파일명(중복되지 않도록)
		//UUID.randomUUID() 중복되지않는 난수값을 얻어옴
		String savefileName=UUID.randomUUID()+"_"+orgfileName;
		long filesize=file1.getSize();
		try {
			//전송된 파일을 읽어오는 스트림
			InputStream fis=file1.getInputStream();
			//전송된 파일을 서버에 복사(업로드) 하기위한 출력스트림
			FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
			//파일 복사하기
			FileCopyUtils.copy(fis, fos); //spring이 갖고있는 메소드(fis에서 읽어와서 fos에 저장)
			fis.close();
			fos.close();
			String profile_img=uploadPath+"\\"+savefileName;
			String name=req.getParameter("name");
			String introduce=req.getParameter("introduce");
			String tel=req.getParameter("tel");
			String buildingCode=addrVo.getBuildingCode();
			String address_detail=req.getParameter("address_detail");
			String[] shop_categories=req.getParameterValues("shop_category");
			String min_price=req.getParameter("min_price");
			String payment_option=req.getParameter("payment_option");
			String info=req.getParameter("info");
			String review_info=req.getParameter("review_info");
			String[] personal_day=req.getParameterValues("personal_day");
			String open_time=req.getParameter("open_time");
			String close_time=req.getParameter("close_time");
			String[] delivery_area=req.getParameterValues("delivery_area");
			String mutual_name=req.getParameter("mutual_name");
			String addr=req.getParameter("addr");
			String reg_num=req.getParameter("reg_num");
			
			String shop_category="";
			for(int i=0; i<shop_categories.length; i++) {
				System.out.println(shop_categories[i]);
				shop_category+=shop_categories[i]+",";
			}
			ShopVo shopVo=new ShopVo(null,profile_img,name,introduce,tel,buildingCode,
					address_detail,);
			
			service.insert(shopVo, addrVo);
			
			//DB에 파일정보 저장하기....
//			ShopVo vo=new ShopVo();
//			service.insert(vo);
			return "success";
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return "error";
		}
	}
}
