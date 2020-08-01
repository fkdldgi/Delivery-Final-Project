package com.jhta.delivery.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhta.delivery.dao.Owner_StoreDao;
import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Owner_CheckMenuVo;


@Service
public class Owner_StoreService {
	@Autowired
	private Owner_StoreDao dao;
	
	
	//�޴�ī�װ�,�޴�,�޴��ɼ� �߰� or ������Ʈ Ʈ�����
	@Transactional
	public int menuUpdateAndInsertTransaction(List<MenuCategoryVo> category_list){
		for(int i=0; i<category_list.size(); i++) {
			MenuCategoryVo categoryVo=category_list.get(i);
			int category_num=categoryVo.getNum();
			List<MenuVo> menu_list=categoryVo.getMenu_list();
			
			if(dao.select_menu_categoryOne(category_num)==null) { //�ش��ȣ�� �޴�ī�װ��� �������� ���� ��� insert
				dao.insertMenu_Category(categoryVo); //�޴�ī�װ� �߰�
				//���ο� ī�װ��� �޴� insert
				for(int j=0; j<menu_list.size(); j++) {
					MenuVo menuVo=menu_list.get(j);
					int menu_num=menuVo.getNum(); //�޴���ȣ
					List<MenuOptionVo> menu_option_list=menuVo.getMenu_option_list(); //�޴��ɼǸ���Ʈ
					dao.insertMenu_newCategory(menuVo);
				}
			}else { //�ش��ȣ�� �޴�ī�װ��� ���� �� ��� update
				dao.updateMenu_Category(categoryVo);
				for(int j=0; j<menu_list.size(); j++) {
					MenuVo menuVo=menu_list.get(j);
					int menu_num=menuVo.getNum(); //�޴���ȣ
					List<MenuOptionVo> menu_option_list=menuVo.getMenu_option_list(); //�޴��ɼǸ���Ʈ
					if(dao.select_menuOne(menu_num)==null) { //�ش��ȣ�� �޴��� �������� ���� ��� insert
						dao.insertMenu(menuVo);
					}else { //�ش��ȣ�� �޴��� ���� �� ��� update
						dao.updateMenu(menuVo);
					}
				}
			}
			
		}
		return 1;
	}
	
	public List<MenuVo> mainMenuList(int num){
		return dao.mainMenuList(num);
	}
	
	// �޴�����
	public int deleteMenu(int num) {
		return dao.deleteMenu(num);
	}
	
	// �޴�ī�װ�����
	public int deleteMenu_Category(int num) {
		return dao.deleteMenu_Category(num);
	}
	
	// �޴��߰�
	public int insertMenu(MenuVo vo){
		return dao.insertMenu(vo);
	}
	
	// �޴�ī�װ� �߰�
	public int insertMenu_Category(MenuCategoryVo vo) {
		return dao.insertMenu_Category(vo);
	}

	// �޴� ����
	public int updateMenu(MenuVo vo) {
		return dao.updateMenu(vo);
	}
	
	// �޴�ī�װ�����
	public int updateMenu_Category(MenuCategoryVo vo) {
		return dao.updateMenu_Category(vo);
	}
	
	// �޴�ī�װ���ȣ ã��
	public int selectMenu_CategoryNum(MenuCategoryVo vo) {
		return dao.selectMenu_CategoryNum(vo);
	}
	
	// �޴��ɼ�
	public List<MenuOptionVo> menu_optionList(){
		return dao.menu_optionList();
	}
	
	// �޴��ɼ� �߰�
	public int insert_menu_option(MenuOptionVo vo) {
		return dao.insert_menu_option(vo);
	}
	
	// �޴��ɼ� ����
	public int update_menu_option(MenuOptionVo vo) {
		return dao.update_menu_option(vo);
	}
	
	// �޴��ɼ� ����
	public int delete_menu_option(int num) {
		return dao.delete_menu_option(num);
	}
	
	// ���԰� ���� �޴�ī�װ�, �޴�, �޴��ɼ�
	public List<Owner_CheckMenuVo> checkMenuList(int num){
		return dao.checkMenuList(num);
	}
	
	// �޴�ī�װ� �߰�&����
	public int insertUpdate_MenuCategory(MenuCategoryVo vo) {
		return dao.insertUpdate_MenuCategory(vo);
	}
	
	// �޴� �߰�&����
	public int insertUpdate_Menu(MenuVo vo) {
		return dao.insertUpdate_Menu(vo);
	}
	
	// �޴��ɼ� �߰�&����
	public int insertUpdate_MenuOption(MenuOptionVo vo) {
		return dao.insertUpdate_MenuOption(vo);
	}
	
	//�޴�ī�װ� ��ȣ�� �޴�ī�װ� ���� ��������
	public MenuCategoryVo select_menu_categoryOne(int category_num) {
		return dao.select_menu_categoryOne(category_num);
	}
		
	//�޴���ȣ�� �޴����� ��������
	public MenuVo select_menuOne(int menu_num) {
		return dao.select_menuOne(menu_num);
	}
	
	//�޴��ɼǹ�ȣ�� �޴��ɼ����� ��������
	public MenuOptionVo select_menu_optionOne(int option_num) {
		return dao.select_menu_optionOne(option_num);
	}
}