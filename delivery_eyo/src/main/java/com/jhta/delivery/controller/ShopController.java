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
		
		//���ε��� ���� ��� ������
		String uploadPath=session.getServletContext().getRealPath("/resources/profile");
		//���۵� ���ϸ�
		String orgfileName=file1.getOriginalFilename();
		//���� ������ ���ϸ�(�ߺ����� �ʵ���)
		//UUID.randomUUID() �ߺ������ʴ� �������� ����
		String savefileName=UUID.randomUUID()+"_"+orgfileName;
		long filesize=file1.getSize();
		try {
			//���۵� ������ �о���� ��Ʈ��
			InputStream fis=file1.getInputStream();
			//���۵� ������ ������ ����(���ε�) �ϱ����� ��½�Ʈ��
			FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
			//���� �����ϱ�
			FileCopyUtils.copy(fis, fos); //spring�� �����ִ� �޼ҵ�(fis���� �о�ͼ� fos�� ����)
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
			
			//DB�� �������� �����ϱ�....
//			ShopVo vo=new ShopVo();
//			service.insert(vo);
			return "success";
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return "error";
		}
	}
}
