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
			String profile_img=uploadPath+"\\"+savefileName; //가게프로필 사진 경로
			String name=req.getParameter("name"); //가게명
			String introduce=req.getParameter("introduce"); //가게소개
			String tel=req.getParameter("tel"); //전화번호
			String buildingCode=addrVo.getBuildingCode(); //건물관리번호
			String address_detail=req.getParameter("address_detail"); //상세주소 
			String shop_category=""; //가게 카테고리를 담을 문자열
			int min_price=Integer.parseInt(req.getParameter("min_price")); //최소주문금액
			String payment_option=req.getParameter("payment_option"); //결제방법
			String info=req.getParameter("info"); //안내
			String review_info=req.getParameter("review_info"); //리뷰안내
			String personal_day=""; //휴무일
			String open_time=req.getParameter("open_time"); //오픈시간
			String close_time=req.getParameter("close_time"); //마감시간
			String delivery_area=""; //배달지역 동 or 리
			String mutual_name=req.getParameter("mutual_name"); //상호명
			String addr=req.getParameter("addr"); //사업자주소
			String reg_num=req.getParameter("reg_num"); //사업자 등록번호
			
			
			
			//가게카테고리가 담긴 배열
			String[] shop_categories=req.getParameterValues("shop_category");
			// " " 로 구분
			for(int i=0; i<shop_categories.length; i++) {
				if(i==shop_categories.length-1) {
					shop_category+=shop_categories[i]; //마지막 값이면 공백없이 추가
				}else {
					shop_category+=shop_categories[i]+" "; //마지막 값이 아니면 공백도 추가
				}
			}
			
			//휴무일이 담긴 배열
			String[] personal_days=req.getParameterValues("personal_day");
			for(int i=0; i<personal_days.length; i++) {
				if(i==personal_days.length-1) {
					personal_day+=personal_days[i]; //마지막 값이면 공백없이 추가
				}else {
					personal_day+=personal_days[i]+","; //마지막 값이 아니면 공백도 추가
				}
			}
			
			String delivery_sido=req.getParameter("delivery_sido"); //배달지역 시,도
			String delivery_sigungu=req.getParameter("delivery_sigungu"); //배달지역 시,군,구
			//배달지역 동 or 리 배열
			String[] addr_names= req.getParameterValues("addr_name");
			//배열지역 시,도+시,군,구+동,리 합치기 (','로구분)
			for(int i=0; i<addr_names.length; i++) {
				if(i==addr_names.length-1) {
					delivery_area+=delivery_sido+" "+delivery_sigungu+" "+addr_names[i];
				}else {
					delivery_area+=delivery_sido+" "+delivery_sigungu+" "+addr_names[i]+",";
				}
			}
			//로그인되어있는 아이디
			String id=(String)session.getAttribute("ownerId");
			
			
			OwnerVo ownerVo=ownerService.idChk(id);
			
			ShopVo shopVo=new ShopVo(0,profile_img,name,introduce,tel,buildingCode,
					address_detail,shop_category,min_price,payment_option,info,review_info,
					personal_day,open_time,close_time,delivery_area,mutual_name,addr,reg_num,0,0,0,0,ownerVo.getNum(),null);
			
			//DB저장 트랜잭션처리(가게,주소)
			shopService.insert(shopVo, addrVo);
			return ".owner.success";
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			return ".owner.error";
		}
	}
}
