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
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.delivery.service.MemberService;
import com.jhta.delivery.service.OrderCouponService;
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
	@Autowired
	private OrderCouponService couponService;
	
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
		
		//�ش� ȸ���� ��� ������ ���� ��������
		HashMap<String, Object> couponMap = new HashMap<String, Object>();
		couponMap.put("member_num", memVo.getNum());
		couponMap.put("last_price", Integer.parseInt(lastPrice));
		List<HashMap<String, Object>> couponList = couponService.useableCoupon(couponMap);
		System.out.println("��� ���� ���� ����Ʈ �� : " + couponList);
		
		model.addAttribute("couponList", couponList);
		model.addAttribute("member", memVo);
		model.addAttribute("shopNum", shopNum);
		model.addAttribute("lastPrice", Integer.parseInt(lastPrice));
		return ".member.memberOrder";
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//�ֹ����������� �ֹ� api�� �Ѿ�� ��Ʈ�ѷ�
	@RequestMapping("/member/order")
	public String order(HttpServletRequest req) {
		int cpNum=0;
		String couponInfo = req.getParameter("lastCoupon").trim();
		if(!(couponInfo.equals("0"))) {
			cpNum = Integer.parseInt(couponInfo.split(",")[1]);
			System.out.println("���� ��� ���� �� : " + cpNum);
		}
		HashMap<String, Object> couponMap = new HashMap<String, Object>();
		couponMap.put("num", cpNum);
		
		int vol;
		int lastPrice;
		int price = 0;
		int shopNum = Integer.parseInt(req.getParameter("shopNum"));
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
													req.getParameter("buildingCode"), //�����ϴ� ���� �ּ�pk��
													req.getParameter("addr_detail"), //���� �Է��ϴ� ���ּ�
													0, //�������ȣ (�ϴ� ���������� ����)
													null, //�ֹ�����
													0, //���̴� ��ȣ(�ϴ� ���������� ����)
													req.getParameter("owner_request"), //����� ��û����
													req.getParameter("rider_request"), //���̴� ��û����
													Integer.parseInt(req.getParameter("lastPrice")), //�� �ֹ��ݾ�
													0, //���Ұ����ο� (�̱���)
													0, //���� ������
													shopNum //���� ��ȣ
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
			if(cpNum==0) {
				System.out.println("���� �̻��");
				orderMainService.orderInsert2(orderMainvo, menuList, optionList, addVo);
			}else {
				System.out.println("���� ���");
				orderMainService.orderInsert(orderMainvo, menuList, optionList, addVo, couponMap);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ".member.orderSuccess";
	}
}
