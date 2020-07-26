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
	
	@Autowired
	private OwnerService ownerService;
	
	@GetMapping("/owner/shop/basicinfo")
	public String basicinfo(int num,Model model) {
		ShopVo vo=shopService.selectShop(num);
		model.addAttribute("vo",vo);
		model.addAttribute("profile_img",vo.getProfile_img());
		model.addAttribute("introduce",vo.getIntroduce());
		model.addAttribute("tel",vo.getTel());
		model.addAttribute("status",vo.getStatus());
		return ".owner.shop.basic_info";
	}
	
	@PostMapping("/owner/shop/basicinfo")
	public String basicinfoOk(MultipartFile file1,HttpServletRequest req,HttpSession session,Model model) {
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
			int shopNum=Integer.parseInt(req.getParameter("shopNum"));
			String profile_img=savefileName; //���������� ���� ���ϸ�
			String introduce=req.getParameter("introduce"); //���ԼҰ�
			String tel=req.getParameter("tel"); //��ȭ��ȣ
			int status=Integer.parseInt(req.getParameter("status")); //���Ի���(open,close)
			
			//�α��εǾ��ִ� ���̵�
			String id=(String)session.getAttribute("ownerId");
			
			OwnerVo ownerVo=ownerService.idChk(id);
			int num=ownerVo.getNum();
			
			//��������
			ShopVo vo=shopService.selectShop(shopNum);
			model.addAttribute("vo",vo);
			
			//�������� ������Ʈ
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("profile_img",profile_img);
			map.put("introduce",introduce);
			map.put("tel",tel);
			map.put("status",status);
			map.put("num",num);
			int n=shopService.basic_info_update(map);
			
			return ".owner.success";
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".owner.error";
		}
	}
}
