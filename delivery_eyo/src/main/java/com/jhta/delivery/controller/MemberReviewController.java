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
		//리뷰 점수
		String grade = req.getParameter("on");
		if(grade == null) {
			grade = "1";
		}
		System.out.println("점수 : " + grade);
		//주문 번호
		int order_num = Integer.parseInt(req.getParameter("order_num"));
		//가게 번호
		int num = Integer.parseInt(req.getParameter("shop_num"));
		//사장 번호
		int owner_num = Integer.parseInt(req.getParameter("owner_num"));
		//고객 번호
		int memberNum = Integer.parseInt(req.getParameter("member_num"));
		String reviewText = req.getParameter("reviewText");
		HashMap<String, Object> imgMap = new HashMap<String, Object>();
		String uploadPath=session.getServletContext().getRealPath("/resources/review");
		String orgfileName;
		String savefileName;
		HashMap<String, Integer> ablemap = new HashMap<String, Integer>();
		ablemap.put("shop_num", num);
		ablemap.put("member_num", memberNum);
		try {
			System.out.println("file123 : " + file123);
			System.out.println("file123 size : " + file123.getSize());
			HashMap<String, Object> reviewMap = new HashMap<String, Object>();
			if(file123.getSize() != 0) {
				//전송된 파일명
				orgfileName=file123.getOriginalFilename();
				//실제 저장할 파일명(중복되지 않도록)
				//UUID.randomUUID() 중복되지않는 난수값을 얻어옴
				savefileName=UUID.randomUUID()+"_"+orgfileName;
				//전송된 파일을 읽어오는 스트림
				InputStream fis=file123.getInputStream();
				//전송된 파일을 서버에 복사(업로드) 하기위한 출력스트림
				FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+savefileName);
				//파일 복사하기 
				FileCopyUtils.copy(fis, fos); //spring이 갖고있는 메소드(fis에서 읽어와서 fos에 저장)
				fis.close();
				fos.close();
				imgMap.put("img_path", uploadPath);
				imgMap.put("original_filename", orgfileName);
				imgMap.put("save_filename", savefileName);
				//리뷰 이미지 넣기
				memberRServiec.review_imgInsert(imgMap);
				reviewMap.put("review_img_num", 1);
			}else {
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
		}catch(IOException ie) {
			return ".owner.error";
		}
		return "redirect:/member/storeDetail?num=" + num + "&owner_num=" + owner_num + "&memberNum=" + memberNum;
	}
}
