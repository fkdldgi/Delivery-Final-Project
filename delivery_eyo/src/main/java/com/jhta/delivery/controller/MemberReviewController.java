package com.jhta.delivery.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.delivery.service.MemberReviewService;
import com.jhta.delivery.vo.Order_MainVo;

@Controller
public class MemberReviewController {
	@Autowired
	private MemberReviewService memberRServiec;
	
	@RequestMapping("/member/insertReview")
	public String init(MultipartFile file123,HttpSession session,HttpServletRequest req) {
		System.out.println("���� ��Ʈ�ѷ� ����");
		//���� ����
		String grade = req.getParameter("on");
		if(grade == null) {
			grade = "1";
		}
		System.out.println("���� : " + grade);
		//�ֹ� ��ȣ
		int order_num = Integer.parseInt(req.getParameter("order_num"));
		System.out.println("�ֹ� ��ȣ : " + order_num);
//		if(req.getParameter("order_num") != "") {
//			int order_num = Integer.parseInt(req.getParameter("order_num").trim());
//			System.out.println("order_num : " + req.getParameter("order_num").trim());
//		}
		//���� ��ȣ
		int num = Integer.parseInt(req.getParameter("shop_num"));
		//���� ��ȣ
		int owner_num = Integer.parseInt(req.getParameter("owner_num"));
		//�� ��ȣ
		int memberNum = Integer.parseInt(req.getParameter("member_num"));
		
		String reviewText = req.getParameter("reviewText");
		System.out.println("shopnum : " + num);
		System.out.println("owner_num : " + owner_num);
		System.out.println("memberNum : " + memberNum);
		System.out.println("reviewText : " + reviewText);
		
		HashMap<String, Object> imgMap = new HashMap<String, Object>();
		
		String uploadPath=session.getServletContext().getRealPath("/resources/review");
		System.out.println("uploadPath : " + uploadPath);
		String orgfileName;
		String savefileName;
		
		
		HashMap<String, Integer> ablemap = new HashMap<String, Integer>();
		ablemap.put("shop_num", num);
		ablemap.put("member_num", memberNum);
//		List<Order_MainVo>  omList = memberRServiec.reviewAble(ablemap);
		
//		Order_MainVo vo = omList.get(0);
//		System.out.println("vo ��� : " + vo);
		
		try {
			System.out.println("file123 : " + file123);
			System.out.println("file123 size : " + file123.getSize());
			HashMap<String, Object> reviewMap = new HashMap<String, Object>();
			if(file123.getSize() != 0) {
				System.out.println("������ ������");
				//���۵� ���ϸ�
				orgfileName=file123.getOriginalFilename();
				//���� ������ ���ϸ�(�ߺ����� �ʵ���)
				//UUID.randomUUID() �ߺ������ʴ� �������� ����
				savefileName=UUID.randomUUID()+"_"+orgfileName;
				//���۵� ������ �о���� ��Ʈ��
				InputStream fis=file123.getInputStream();
				System.out.println("������ getInputStream");
				//���۵� ������ ������ ����(���ε�) �ϱ����� ��½�Ʈ��
				FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
				System.out.println("������ FileOutputStream");
				//���� �����ϱ� 
				FileCopyUtils.copy(fis, fos); //spring�� �����ִ� �޼ҵ�(fis���� �о�ͼ� fos�� ����)
				fis.close();
				fos.close();
				
				System.out.println("uploadPath : " + uploadPath);
				System.out.println("orgfileName : " + orgfileName);
				System.out.println("savefileName : " + savefileName);
				
				imgMap.put("img_path", uploadPath);
				imgMap.put("original_filename", orgfileName);
				imgMap.put("save_filename", savefileName);
				
				//���� �̹��� �ֱ�
				memberRServiec.review_imgInsert(imgMap);
				
				reviewMap.put("review_img_num", 1);
			}else {
				System.out.println("review_img_num : 0 ����");
				savefileName="default.png";
				reviewMap.put("review_img_num", 0);
			}
			
			reviewMap.putIfAbsent("content", reviewText);
			reviewMap.putIfAbsent("grade", grade);
			reviewMap.putIfAbsent("shop_num", num);
			reviewMap.putIfAbsent("member_num", memberNum);
			//����� ����� �����ϱ� ���� �����ȣ�� null�� �ֵ��� ��������
			reviewMap.putIfAbsent("owner_num", 0);
			
			//���� �ֱ�
			int n = memberRServiec.reviewInsert(reviewMap);
			if(n>0) {
			//�ֹ� ���̺��� ���� ������ �����ϱ�
				memberRServiec.updateReviewStatus(order_num);
			}
			System.out.println("���� ������ ���� ��");
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".owner.error";
		}
		System.out.println("���� ��");
		return "redirect:/member/storeDetail?num=" + num + "&owner_num=" + owner_num + "&memberNum=" + memberNum;
	}
}
