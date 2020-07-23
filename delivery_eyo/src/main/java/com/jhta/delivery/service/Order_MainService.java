package com.jhta.delivery.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.Order_MainDao;
import com.jhta.delivery.dao.Order_MenuDao;
import com.jhta.delivery.dao.Order_Menu_OptionDao;
import com.jhta.delivery.vo.Order_MainVo;
import com.jhta.delivery.vo.Order_MenuVo;
import com.jhta.delivery.vo.Order_Menu_OptionVo;

@Service
// 주문
public class Order_MainService {
	@Autowired
	private Order_MainDao dao;
	@Autowired
	private Order_MenuDao dao2;
	@Autowired
	private Order_Menu_OptionDao dao3;
	//주문 입력부분
	public int insert(Order_MainVo vo) {
		return dao.insert(vo);
	}
	
	//주문 - 주문 메뉴 - 주문 메뉴 옵션 트랜잭션 처리(최초 실행)
	@Transactional
	public int orderInsert(Order_MainVo vo1, ArrayList<Order_MenuVo> menuList, ArrayList<Order_Menu_OptionVo> optionList) {
		dao.insert(vo1);
		for(int i=0; i<menuList.size(); i++) {
			dao2.insert(menuList.get(i));
			if(optionList != null) {
				for(int j=0; j<optionList.size(); j++) {
					int menu_menuNum = menuList.get(i).getMenu_num();
					System.out.println("menu_menuNum : " + menu_menuNum);
					int option_menuOptionNum = optionList.get(j).getMunu_option_num();
					System.out.println("option_menuOptionNum : " + option_menuOptionNum);
					int option_menuNum = dao.getOrderMenuNumBy(option_menuOptionNum);
					System.out.println("option_menuNum : " + option_menuNum);
					
					if(menu_menuNum == option_menuNum) {
						dao3.insert(optionList.get(j));
					}
				}
			}
		}
		return 1;
	}
	
	//메뉴 번호로 매뉴 가격 가져오기
	public int getMenuPrice(int num) {
		return dao.getMenuPrice(num);
	}
	
	//옵션 번호로 메뉴 옵션 가격 가져오기
	public int getOptionPrice(int num) {
		return dao.getOptionPrice(num);
	}
}
