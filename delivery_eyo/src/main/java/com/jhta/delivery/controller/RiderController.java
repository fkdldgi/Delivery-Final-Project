package com.jhta.delivery.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.delivery.service.RiderService;
import com.jhta.delivery.vo.Order_MainVo;
import com.jhta.delivery.vo.RiderOrderVo;
import com.jhta.delivery.vo.RiderVo;

@Controller
public class RiderController {
	
	@Autowired
	private RiderService service;
	
	@RequestMapping(value = "/rider/home")
	public String home() {
		return ".rider.login";
	}
	
	// 로그인
	@RequestMapping("/rider/login")
	@ResponseBody
	public int login(String id, String pwd, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("pwd",pwd);
		RiderVo vo = service.selectOne(map);
		if(vo != null) {
			session.setAttribute("riderId", id);
			session.setAttribute("riderName", vo.getName());
			session.setAttribute("riderNum", vo.getNum());
			return 1;
		}else {
			return 0;
		}
	}
	
	// 회원가입
	@RequestMapping("/rider/join")
	public String join(String id, String pwd, String name, String email, String phone) {
		RiderVo vo = new RiderVo(0,id,pwd,name,phone,email,0,null);
		service.insertRider(vo);
		
		return home();
	}
	
	// 아이디 중복확인
	@RequestMapping("/rider/checkId")
	@ResponseBody
	public String checkId(String id) {
		RiderVo vo = service.RiderIdcheck(id);
		System.out.println(vo);
		// 존재하는 아이디가 있을 경우
		if(vo!=null) {
			return "fail";
		}else{
			return "success";			
		}
	}
	
	// 로그아웃 처음페이지로 이동
	@RequestMapping("/rider/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return ".rider.login";
	}
	
	// 배달에서 주문승인 리스트(아무도 안받은거)
	@RequestMapping("/rider/riderorderList")
	@ResponseBody
	public List<RiderOrderVo> deliveryList() {
		
		List<RiderOrderVo> riderOrderList = service.riderOrderList();
		System.out.println("1111111111111111111111"+riderOrderList.toString());
		return riderOrderList;
	}
	
	// 배달승인버튼 눌렀을 때
	@RequestMapping("/rider/accept")
	@ResponseBody
	public void accept(int om_num, int rider_num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", om_num);
		map.put("rider_num", rider_num);
		
		// 승인버튼 눌렀을때 상태변화
		service.RiderAcceptOrder(map);
	}
	
	// 배달에서 배달승인 리스트
	@RequestMapping("/rider/acceptList")
	@ResponseBody
	public List<RiderOrderVo> acceptList(int num){
		
		List<RiderOrderVo> riderAcceptList = service.riderAcceptList(num);		
		return riderAcceptList;
	}
	
	// 배달완료버튼 눌렀을 때
	@RequestMapping("/rider/success")
	@ResponseBody
	public void success(int om_num, int rider_num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num",om_num);
		map.put("rider_num", rider_num);
		
		// 배달완료버튼 눌렀을 때 상태 변화
		service.RiderSuccessOrder(map);
	}
	
	// 배달완료 리스트
	@RequestMapping("/rider/successList")
	@ResponseBody
	public List<RiderOrderVo> successList(int num){
		List<RiderOrderVo> riderSuccessList = service.riderSuccessList(num);
		return riderSuccessList;
	}
	
	
	
	
	
	
	
}
