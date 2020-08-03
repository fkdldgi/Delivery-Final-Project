package com.jhta.delivery.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.AddressDao;
import com.jhta.delivery.dao.OrderCouponDao;
import com.jhta.delivery.dao.Order_MainDao;
import com.jhta.delivery.dao.Order_MenuDao;
import com.jhta.delivery.dao.Order_Menu_OptionDao;
import com.jhta.delivery.vo.AddressVo;
import com.jhta.delivery.vo.Order_MainVo;
import com.jhta.delivery.vo.Order_MenuVo;
import com.jhta.delivery.vo.Order_Menu_OptionVo;

@Service
// �ֹ�
public class Order_MainService {
	@Autowired 
	private Order_MainDao orderMinDao;
	@Autowired
	private Order_MenuDao orderMenuDao;
	@Autowired
	private Order_Menu_OptionDao orderOptionDao;
	@Autowired
	private AddressDao addDao;
	@Autowired
	private OrderCouponDao couponDao;
	//�ֹ� �Էºκ�
	public int insert(Order_MainVo vo) {
		return orderMinDao.insert(vo);
	}
	
	//�ֹ� - �ֹ� �޴� - �ֹ� �޴� �ɼ� Ʈ����� ó��(���� ����)
	@Transactional
	public int orderInsert(Order_MainVo vo1, ArrayList<Order_MenuVo> menuList, ArrayList<Order_Menu_OptionVo> optionList, AddressVo addVo,HashMap<String, Object> couponMap) {
		AddressVo avo=addDao.selectByBuildingcode(addVo.getBuildingCode());
		if(avo == null) {
			addDao.insert(addVo);
		}
		orderMinDao.insert(vo1);
		for(int i=0; i<menuList.size(); i++) {
			orderMenuDao.insert(menuList.get(i));
			if(optionList != null) {
				for(int j=0; j<optionList.size(); j++) {
					int menu_menuNum = menuList.get(i).getMenu_num();
					int option_menuOptionNum = optionList.get(j).getmenu_option_num();
					int option_menuNum = orderMinDao.getOrderMenuNumBy(option_menuOptionNum);
					
					if(menu_menuNum == option_menuNum) {
						orderOptionDao.insert(optionList.get(j));
					}
				}
			}
		}
		couponDao.updateCoupon(couponMap);
		return 1;
	}
	
	@Transactional
	public int orderInsert2(Order_MainVo vo1, ArrayList<Order_MenuVo> menuList, ArrayList<Order_Menu_OptionVo> optionList, AddressVo addVo) {
		AddressVo avo=addDao.selectByBuildingcode(addVo.getBuildingCode());
		if(avo == null) {
			addDao.insert(addVo);
		}
		orderMinDao.insert(vo1);
		for(int i=0; i<menuList.size(); i++) {
			orderMenuDao.insert(menuList.get(i));
			if(optionList != null) {
				for(int j=0; j<optionList.size(); j++) {
					int menu_menuNum = menuList.get(i).getMenu_num();
					int option_menuOptionNum = optionList.get(j).getmenu_option_num();
					int option_menuNum = orderMinDao.getOrderMenuNumBy(option_menuOptionNum);
					
					if(menu_menuNum == option_menuNum) {
						orderOptionDao.insert(optionList.get(j));
					}
				}
			}
		}
		return 1;
	}
	
	//�޴� ��ȣ�� �Ŵ� ���� ��������
	public int getMenuPrice(int num) {
		return orderMinDao.getMenuPrice(num);
	}
	
	//�ɼ� ��ȣ�� �޴� �ɼ� ���� ��������
	public int getOptionPrice(int num) {
		return orderMinDao.getOptionPrice(num);
	}
}
