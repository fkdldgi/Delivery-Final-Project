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

import com.jhta.delivery.service.OwnerService;
import com.jhta.delivery.service.ShopService;
import com.jhta.delivery.vo.AddressVo;
import com.jhta.delivery.vo.OwnerVo;
import com.jhta.delivery.vo.ShopVo;


@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OwnerService ownerService;
	
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
			String profile_img=uploadPath+"\\"+savefileName; //���������� ���� ���
			String name=req.getParameter("name"); //���Ը�
			String introduce=req.getParameter("introduce"); //���ԼҰ�
			String tel=req.getParameter("tel"); //��ȭ��ȣ
			String buildingCode=addrVo.getBuildingCode(); //�ǹ�������ȣ
			String address_detail=req.getParameter("address_detail"); //���ּ� 
			String shop_category=""; //���� ī�װ��� ���� ���ڿ�
			int min_price=Integer.parseInt(req.getParameter("min_price")); //�ּ��ֹ��ݾ�
			String payment_option=req.getParameter("payment_option"); //�������
			String info=req.getParameter("info"); //�ȳ�
			String review_info=req.getParameter("review_info"); //����ȳ�
			String personal_day=""; //�޹���
			String open_time=req.getParameter("open_time"); //���½ð�
			String close_time=req.getParameter("close_time"); //�����ð�
			String delivery_area=""; //������� �� or ��
			String mutual_name=req.getParameter("mutual_name"); //��ȣ��
			String addr=req.getParameter("addr"); //������ּ�
			String reg_num=req.getParameter("reg_num"); //����� ��Ϲ�ȣ
			
			
			
			//����ī�װ��� ��� �迭
			String[] shop_categories=req.getParameterValues("shop_category");
			// " " �� ����
			for(int i=0; i<shop_categories.length; i++) {
				if(i==shop_categories.length-1) {
					shop_category+=shop_categories[i]; //������ ���̸� ������� �߰�
				}else {
					shop_category+=shop_categories[i]+" "; //������ ���� �ƴϸ� ���鵵 �߰�
				}
			}
			
			//�޹����� ��� �迭
			String[] personal_days=req.getParameterValues("personal_day");
			for(int i=0; i<personal_days.length; i++) {
				if(i==personal_days.length-1) {
					personal_day+=personal_days[i]; //������ ���̸� ������� �߰�
				}else {
					personal_day+=personal_days[i]+","; //������ ���� �ƴϸ� ���鵵 �߰�
				}
			}
			
			String delivery_sido=req.getParameter("delivery_sido"); //������� ��,��
			String delivery_sigungu=req.getParameter("delivery_sigungu"); //������� ��,��,��
			//������� �� or �� �迭
			String[] addr_names= req.getParameterValues("addr_name");
			//�迭���� ��,��+��,��,��+��,�� ��ġ�� (','�α���)
			for(int i=0; i<addr_names.length; i++) {
				if(i==addr_names.length-1) {
					delivery_area+=delivery_sido+" "+delivery_sigungu+" "+addr_names[i];
				}else {
					delivery_area+=delivery_sido+" "+delivery_sigungu+" "+addr_names[i]+",";
				}
			}
			//�α��εǾ��ִ� ���̵�
			String id=(String)session.getAttribute("ownerId");
			
			
			OwnerVo ownerVo=ownerService.idChk(id);
			
			ShopVo shopVo=new ShopVo(0,profile_img,name,introduce,tel,buildingCode,
					address_detail,shop_category,min_price,payment_option,info,review_info,
					personal_day,open_time,close_time,delivery_area,mutual_name,addr,reg_num,0,0,0,0,ownerVo.getNum(),null);
			
			//DB���� Ʈ�����ó��(����,�ּ�)
			shopService.insert(shopVo, addrVo);
			return ".owner.success";
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".owner.error";
		}
	}
}
