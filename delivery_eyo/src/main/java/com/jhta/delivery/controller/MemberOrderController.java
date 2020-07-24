package com.jhta.delivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.service.Order_MainService;
import com.jhta.delivery.service.Order_MenuService;
import com.jhta.delivery.service.Order_Menu_OptionService;
import com.jhta.delivery.service.StoreService;
import com.jhta.delivery.vo.AddressVo;
import com.jhta.delivery.vo.MemberVo;
import com.jhta.delivery.vo.Order_MainVo;
import com.jhta.delivery.vo.Order_MenuVo;
import com.jhta.delivery.vo.Order_Menu_OptionVo;

@Controller
public class MemberOrderController {
	@Autowired
	private MemberService memService;
	@Autowired
	private Order_MenuService orderMenuService;
	@Autowired
	private Order_Menu_OptionService orderOptionService;
	@Autowired
	private Order_MainService orderMainService;
	@Autowired
	private StoreService storeService;
	
	//�ֹ� �������� �̵��ϴ� ��Ʈ�ѷ�
	@RequestMapping("/member/orderPage")
	public String orderPage(Model model,String orderList,String memberId,int shopNum,String lastPrice) {
		String split1 [] = orderList.split(";");
		String id = memberId.substring(1, memberId.length()-1);
		ArrayList<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
		
		for(int i=0; i<split1.length; i++) {
			String split2 [] = split1[i].split(",");
			LinkedHashMap<String, Object> lmap = new LinkedHashMap<String, Object>();
			for(int j=0; j<split2.length; j++) {
				if(j==0) {
					lmap.put("menuVo",storeService.menuInfo(Integer.parseInt(split2[j])));
				}else if(j==1) {
					lmap.put("volume", split2[j]);
				}else {
					lmap.put("optionVo"+(j-1),storeService.optionInfoByOption(Integer.parseInt(split2[j])));
				}
			}
			list.add(lmap);
			model.addAttribute("orderList", list);
		}
		System.out.println("model : " + model);
		MemberVo memVo = memService.idChk(id);
		
		model.addAttribute("member", memVo);
		model.addAttribute("shopNum", shopNum);
		model.addAttribute("lastPrice", Integer.parseInt(lastPrice));
		return ".member.memberOrder";
	}
	
	@RequestMapping("/member/order")
	public String order(HttpServletRequest req ) {
//		System.out.println(req.getParameter("buildingCode"));
//		System.out.println(req.getParameter("zonecode"));
//		System.out.println(req.getParameter("address"));
//		System.out.println(req.getParameter("addressEnglish"));
//		System.out.println(req.getParameter("addressType"));
//		System.out.println(req.getParameter("userSelectedType"));
//		System.out.println(req.getParameter("userLanguageType"));
//		System.out.println(req.getParameter("roadAddress"));
//		System.out.println(req.getParameter("roadAddressEnglish"));
//		System.out.println(req.getParameter("jibunAddress"));
//		System.out.println(req.getParameter("jibunAddressEnglish"));
//		System.out.println(req.getParameter("buildingName"));
//		System.out.println(req.getParameter("apartment"));
//		System.out.println(req.getParameter("sido"));
//		System.out.println(req.getParameter("sigungu"));
//		System.out.println(req.getParameter("sigunguCode"));
//		System.out.println(req.getParameter("roadnameCode"));
//		System.out.println(req.getParameter("bcode"));
//		System.out.println(req.getParameter("roadname"));
//		System.out.println(req.getParameter("bname"));
//		System.out.println(req.getParameter("bname1"));
//		System.out.println(req.getParameter("bname2"));
//		System.out.println(req.getParameter("hname"));
//		System.out.println(req.getParameter("query"));
//		System.out.println(req.getParameter("addr_x"));
//		System.out.println(req.getParameter("addr_y"));
		
		
//		
//		System.out.println(req.getParameter("shopNum"));
//		System.out.println(req.getParameter("memberNum"));
//		System.out.println(req.getParameter("userAddr"));
//		System.out.println(req.getParameter("addr_detail"));
//		System.out.println(req.getParameter("tel"));
//		System.out.println(req.getParameter("owner_request"));
//		System.out.println(req.getParameter("rider_request"));
//		System.out.println(req.getParameter("menuNum"));
//		System.out.println(req.getParameter("optionNum"));
//		System.out.println(req.getParameter("volume").trim());
//		System.out.println(req.getParameter("lastPrice"));
		
		System.out.println("�޴� ��ȣ ũ�� : " + req.getParameterValues("menuNum").length);
//		System.out.println("�ɼ� ��ȣ ũ�� : " + req.getParameterValues("optionNum").length);
		System.out.println("�޴� ��ȣ : " + req.getParameterValues("menuNum")[0]);
	//		System.out.println("�ɼ� ��ȣ : " + req.getParameterValues("optionNum")[0]);
	//	System.out.println("�ɼ� ��ȣ : " + req.getParameter("optionNum"));
		System.out.println("���� : " + req.getParameter("volume").trim());
		
		int vol;
		int lastPrice;
		int price = 0;
		
		System.out.println("���� ��巹�� : " + req.getParameter("jibunAddress"));
		
		AddressVo addVo = new AddressVo(
				req.getParameter("buildingCode"),
				req.getParameter("zonecode"),
				req.getParameter("address"), 
				req.getParameter("addressEnglish"),
				req.getParameter("addressType"),
				req.getParameter("userSelectedType"),
				req.getParameter("userLanguageType"),
				req.getParameter("roadAddress"),
				req.getParameter("roadAddressEnglish"),
				req.getParameter("jibunAddress"),
				req.getParameter("jibunAddressEnglish"),
				req.getParameter("buildingName"),
				req.getParameter("apartment"),
				req.getParameter("sido"),
				req.getParameter("sigungu"),
				req.getParameter("sigunguCode"),
				req.getParameter("roadnameCode"),
				req.getParameter("bcode"),
				req.getParameter("roadname"),
				req.getParameter("bname"),
				req.getParameter("bname1"),
				req.getParameter("bname2"),
				req.getParameter("hname"),
				req.getParameter("query"),
				Double.parseDouble(req.getParameter("addr_x")),
				Double.parseDouble(req.getParameter("addr_y"))
				);
		
		ArrayList<Order_MenuVo> menuList = new ArrayList<Order_MenuVo>();
		ArrayList<Order_Menu_OptionVo> optionList = new ArrayList<Order_Menu_OptionVo>();
		Order_MainVo orderMainvo = new Order_MainVo(0, //pk��
													null, null, null, //�ֹ��ð�, ���������ð�, �����ð�
													Integer.parseInt(req.getParameter("memberNum")), //�ֹ��ϴ� ���� pk��
													"1234", //�����ϴ� ���� �ּ�pk��
													req.getParameter("addr_detail"), //���� �Է��ϴ� ���ּ�
													0, //�������ȣ (�ϴ� ���������� ����)
													null, //�ֹ�����
													0, //���̴� ��ȣ(�ϴ� ���������� ����)
													req.getParameter("owner_request"), //����� ��û����
													req.getParameter("rider_request"), //���̴� ��û����
													Integer.parseInt(req.getParameter("lastPrice")), //�� �ֹ��ݾ�
													0 //���Ұ����ο� (�̱���)
													);
		
		for(int i=0; i<req.getParameterValues("menuNum").length; i++) {
			vol = Integer.parseInt(req.getParameterValues("volume")[i].trim());
			lastPrice = Integer.parseInt(req.getParameter("lastPrice"));
			price = (lastPrice/vol);
			Order_MenuVo orderMenuvo = new Order_MenuVo(0, //pk��
														0, //�ֹ���ȣ ����(�������� ����)
														Integer.parseInt(req.getParameterValues("menuNum")[i]), //�޴���ȣ ���� 
														price, //�ֹ��ݾ�
														vol //����
														);
			menuList.add(orderMenuvo);
			//�ش� �ֹ��� ���� �ɼ� �޴��� ������ ��
			if(req.getParameterValues("optionNum"+i) != null) {
				for(int j=0; j<req.getParameterValues("optionNum"+i).length; j++) {
					Order_Menu_OptionVo orderOptionvo = new Order_Menu_OptionVo(
																				0,//pk��
																				Integer.parseInt(req.getParameterValues("optionNum"+i)[j]), //�ɼǹ�ȣ ����
																				Integer.parseInt(req.getParameterValues("menuNum")[i]) //�޴���ȣ ����
																				);
					optionList.add(orderOptionvo);
				}
			}
		}
		try {
			orderMainService.orderInsert(orderMainvo, menuList, optionList, addVo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ".member.orderSuccess";
	}
}
