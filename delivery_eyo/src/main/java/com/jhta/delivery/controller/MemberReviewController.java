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
		System.out.println("리뷰 컨트롤러 접속");
		//리뷰 점수
		String grade = req.getParameter("on");
		if(grade == null) {
			grade = "1";
		}
		System.out.println("점수 : " + grade);
		//주문 번호
		int order_num = Integer.parseInt(req.getParameter("order_num"));
		System.out.println("주문 번호 : " + order_num);
//		if(req.getParameter("order_num") != "") {
//			int order_num = Integer.parseInt(req.getParameter("order_num").trim());
//			System.out.println("order_num : " + req.getParameter("order_num").trim());
//		}
		//가게 번호
		int num = Integer.parseInt(req.getParameter("shop_num"));
		//사장 번호
		int owner_num = Integer.parseInt(req.getParameter("owner_num"));
		//고객 번호
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
//		System.out.println("vo 출력 : " + vo);
		
		try {
			System.out.println("file123 : " + file123);
			System.out.println("file123 size : " + file123.getSize());
			HashMap<String, Object> reviewMap = new HashMap<String, Object>();
			if(file123.getSize() != 0) {
				System.out.println("파일이 존재함");
				//전송된 파일명
				orgfileName=file123.getOriginalFilename();
				//실제 저장할 파일명(중복되지 않도록)
				//UUID.randomUUID() 중복되지않는 난수값을 얻어옴
				savefileName=UUID.randomUUID()+"_"+orgfileName;
				//전송된 파일을 읽어오는 스트림
				InputStream fis=file123.getInputStream();
				System.out.println("파일이 getInputStream");
				//전송된 파일을 서버에 복사(업로드) 하기위한 출력스트림
				FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
				System.out.println("파일이 FileOutputStream");
				//파일 복사하기 
				FileCopyUtils.copy(fis, fos); //spring이 갖고있는 메소드(fis에서 읽어와서 fos에 저장)
				fis.close();
				fos.close();
				
				System.out.println("uploadPath : " + uploadPath);
				System.out.println("orgfileName : " + orgfileName);
				System.out.println("savefileName : " + savefileName);
				
				imgMap.put("img_path", uploadPath);
				imgMap.put("original_filename", orgfileName);
				imgMap.put("save_filename", savefileName);
				
				//리뷰 이미지 넣기
				memberRServiec.review_imgInsert(imgMap);
				
				reviewMap.put("review_img_num", 1);
			}else {
				System.out.println("review_img_num : 0 진입");
				savefileName="default.png";
				reviewMap.put("review_img_num", 0);
			}
			
			reviewMap.putIfAbsent("content", reviewText);
			reviewMap.putIfAbsent("grade", grade);
			reviewMap.putIfAbsent("shop_num", num);
			reviewMap.putIfAbsent("member_num", memberNum);
			//사장님 댓글을 구분하기 위해 사장번호는 null로 넣도록 변경했음
			reviewMap.putIfAbsent("owner_num", 0);
			
			//리뷰 넣기
			int n = memberRServiec.reviewInsert(reviewMap);
			if(n>0) {
			//주문 테이블의 리뷰 구분자 수정하기
				memberRServiec.updateReviewStatus(order_num);
			}
			System.out.println("리뷰 구분자 수정 후");
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".owner.error";
		}
		System.out.println("리턴 전");
		return "redirect:/member/storeDetail?num=" + num + "&owner_num=" + owner_num + "&memberNum=" + memberNum;
	}
}
