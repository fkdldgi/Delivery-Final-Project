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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.delivery.service.MemberReviewService;
import com.jhta.delivery.vo.ShopVo;

@Controller
public class MemberReviewController {
	@Autowired
	private MemberReviewService memberRServiec;
	
	@RequestMapping("/member/insertReview")
	public String init(MultipartFile file,HttpSession session,HttpServletRequest req) {
		
		int num = Integer.parseInt(req.getParameter("shop_num"));
		int owner_num = Integer.parseInt(req.getParameter("owner_num"));
		int memberNum = Integer.parseInt(req.getParameter("member_num"));
		String reviewText = req.getParameter("reviewText");
		String grade="";
		
		System.out.println("shopnum : " + num);
		System.out.println("owner_num : " + owner_num);
		System.out.println("memberNum : " + memberNum);
		System.out.println("reviewText : " + reviewText);
		
		HashMap<String, Object> imgMap = new HashMap<String, Object>();
		HashMap<String, Object> reviewMap = new HashMap<String, Object>();
		
		String uploadPath=session.getServletContext().getRealPath("/resources/reivew");
		String orgfileName;
		String savefileName;
		
		try {
			
			if(file != null) {
				//���۵� ���ϸ�
				orgfileName=file.getOriginalFilename();
				//���� ������ ���ϸ�(�ߺ����� �ʵ���)
				//UUID.randomUUID() �ߺ������ʴ� �������� ����
				savefileName=UUID.randomUUID()+"_"+orgfileName;
				//���۵� ������ �о���� ��Ʈ��
				InputStream fis=file.getInputStream();
				//���۵� ������ ������ ����(���ε�) �ϱ����� ��½�Ʈ��
				FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
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
				
				//memberRServiec.review_imgInsert(imgMap);
				
				reviewMap.put("review_img_num", "REVIEW_IMG_SEQ.CURRVAL");
			}else {
				savefileName="default.png";
				reviewMap.put("review_img_num", 0);
			}
			
			reviewMap.putIfAbsent("content", reviewText);
			reviewMap.putIfAbsent("grade", grade);
			reviewMap.putIfAbsent("shop_num", num);
			reviewMap.putIfAbsent("member_num", memberNum);
			reviewMap.putIfAbsent("owner_num", owner_num);
			
			//memberRServiec.reviewInsert(reviewMap);
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".owner.error";
		}
		return "redirect:/member/storeDetail?num=" + num + "&owner_num=" + owner_num + "&memberNum=" + memberNum;
	}
}
