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
	
	// �α���
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
	
	// ȸ������
	@RequestMapping("/rider/join")
	public String join(String id, String pwd, String name, String email, String phone) {
		RiderVo vo = new RiderVo(0,id,pwd,name,phone,email,0,null);
		service.insertRider(vo);
		
		return home();
	}
	
	// ���̵� �ߺ�Ȯ��
	@RequestMapping("/rider/checkId")
	@ResponseBody
	public String checkId(String id) {
		RiderVo vo = service.RiderIdcheck(id);
		System.out.println(vo);
		// �����ϴ� ���̵� ���� ���
		if(vo!=null) {
			return "fail";
		}else{
			return "success";			
		}
	}
	
	// �α׾ƿ� ó���������� �̵�
	@RequestMapping("/rider/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return ".rider.login";
	}
	
	// ��޿��� �ֹ����� ����Ʈ(�ƹ��� �ȹ�����)
	@RequestMapping("/rider/riderorderList")
	@ResponseBody
	public List<RiderOrderVo> deliveryList() {
		
		List<RiderOrderVo> riderOrderList = service.riderOrderList();
		System.out.println("1111111111111111111111"+riderOrderList.toString());
		return riderOrderList;
	}
	
	// ��޽��ι�ư ������ ��
	@RequestMapping("/rider/accept")
	@ResponseBody
	public void accept(int om_num, int rider_num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num", om_num);
		map.put("rider_num", rider_num);
		
		// ���ι�ư �������� ���º�ȭ
		service.RiderAcceptOrder(map);
	}
	
	// ��޿��� ��޽��� ����Ʈ
	@RequestMapping("/rider/acceptList")
	@ResponseBody
	public List<RiderOrderVo> acceptList(int num){
		
		List<RiderOrderVo> riderAcceptList = service.riderAcceptList(num);		
		return riderAcceptList;
	}
	
	// ��޿Ϸ��ư ������ ��
	@RequestMapping("/rider/success")
	@ResponseBody
	public void success(int om_num, int rider_num) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("num",om_num);
		map.put("rider_num", rider_num);
		
		// ��޿Ϸ��ư ������ �� ���� ��ȭ
		service.RiderSuccessOrder(map);
	}
	
	// ��޿Ϸ� ����Ʈ
	@RequestMapping("/rider/successList")
	@ResponseBody
	public List<RiderOrderVo> successList(int num){
		List<RiderOrderVo> riderSuccessList = service.riderSuccessList(num);
		return riderSuccessList;
	}
	
	
	
	
	
	
	
}
