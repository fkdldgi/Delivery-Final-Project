package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jhta.delivery.vo.ShopVo;

@Controller
public class MemberReviewController {
	
	@ResponseBody
	@RequestMapping(value = "/member/insertReview", method = RequestMethod.POST)
	public List<ShopVo> init(@RequestBody int startrow,MultipartFile file,HttpSession session) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startrow", startrow);
		
		//List<ShopVo> shopList = service.shopList(map);
		
		String uploadPath;
		String orgfileName;
		String savefileName;
		if(file != null) {
			//업로드할 폴더 경로 얻어오기
			uploadPath=session.getServletContext().getRealPath("/resources/images");
			//전송된 파일명
			orgfileName=file.getOriginalFilename();
			//실제 저장할 파일명(중복되지 않도록)
			//UUID.randomUUID() 중복되지않는 난수값을 얻어옴
			savefileName=UUID.randomUUID()+"_"+orgfileName;
		}
		
		return shopList;
	}
}
