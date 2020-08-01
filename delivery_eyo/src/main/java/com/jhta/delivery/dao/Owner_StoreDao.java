package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuOptionVo;
import com.jhta.delivery.vo.MenuVo;
import com.jhta.delivery.vo.Owner_CheckMenuVo;

@Repository
public class Owner_StoreDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="mybatis.Owner_StoreMapper";
	
	// �޴�����Ʈ
	public List<MenuVo> mainMenuList(int num){
		return session.selectList(NAMESPACE+".mainMenuList", num);
	}
	
	// �޴�����
	public int deleteMenu(int num) {
		return session.delete(NAMESPACE+".deleteMenu", num);
	}
	
	// �޴�ī�װ�����
	public int deleteMenu_Category(int num) {
		return session.delete(NAMESPACE+".deleteMenu_Category", num);
	}
	
	// �޴��߰�(���� ī�װ����� �߰��ϴ� ���)
	public int insertMenu(MenuVo vo) {
		return session.insert(NAMESPACE+".insertMenu", vo);
	}
	
	// �޴� �߰� (���ο� ī�װ��� �߰��ϴ� ���)
	public int insertMenu_newCategory(MenuVo vo) {
		return session.insert(NAMESPACE+".insertMenu_newCategory",vo);
	}
	
	// �޴�ī�װ� �߰�
	public int insertMenu_Category(MenuCategoryVo vo) {
		return session.insert(NAMESPACE+".insertMenu_Category", vo);
	}
	
	// �޴�����
	public int updateMenu(MenuVo vo) {
		return session.update(NAMESPACE+".updateMenu", vo);
	}
	
	// �޴�ī�װ�����
	public int updateMenu_Category(MenuCategoryVo vo) {
		return session.update(NAMESPACE+".updateMenu_Category", vo);
	}
	
	// �޴�ī�װ���ȣ ã��
	public int selectMenu_CategoryNum(MenuCategoryVo vo) {
		return session.selectOne(NAMESPACE+".selectMenu_CategoryNum", vo);
	}
	
	// �޴��ɼ�
	public List<MenuOptionVo> menu_optionList(){
		return session.selectList(NAMESPACE+".select_menu_option");
	}
	
	// �޴��ɼ� �߰�(���� �޴��� �ɼ� �߰�)
	public int insert_menu_option(MenuOptionVo vo) {
		return session.insert(NAMESPACE+".insert_menu_option", vo);
	}
	// �޴��ɼ� �߰�(���ο� �޴��� �ɼ� �߰�)
	public int insert_menu_option_newMenu(MenuOptionVo vo) {
		return session.insert(NAMESPACE+".insert_menu_option_newMenu", vo);
	}
	
	// �޴��ɼ� ����
	public int update_menu_option(MenuOptionVo vo) {
		return session.update(NAMESPACE+".update_menu_option",vo);
	}
	
	// �޴��ɼ� ����
	public int delete_menu_option(int num) {
		return session.delete(NAMESPACE+".delete_menu_option", num);
	}
	
	// ���԰� ���� �޴�ī�װ�, �޴�, �޴��ɼ�
	public List<Owner_CheckMenuVo> checkMenuList(int num){
		return session.selectList(NAMESPACE+".select_menuAll", num);
	}
	
	// �޴�ī�װ� �߰�& ����
	public int insertUpdate_MenuCategory(MenuCategoryVo vo) {
		return session.insert(NAMESPACE+".insertUpdate_Menu_category", vo);
	}
	
	// �޴� �߰�&����
	public int insertUpdate_Menu(MenuVo vo) {
		return session.insert(NAMESPACE+".insertUpdate_Menu", vo);
	}
	
	// �޴��ɼ� �߰�&����
	public int insertUpdate_MenuOption(MenuOptionVo vo) {
		return session.insert(NAMESPACE+".insertUpdate_MenuOption", vo);
	}
	
	//�޴�ī�װ� ��ȣ�� �޴�ī�װ� ���� ��������
	public MenuCategoryVo select_menu_categoryOne(int category_num) {
		return session.selectOne(NAMESPACE+".select_menu_categoryOne",category_num);
	}
	
	//�޴���ȣ�� �޴����� ��������
	public MenuVo select_menuOne(int menu_num) {
		return session.selectOne(NAMESPACE+".select_menuOne",menu_num);
	}
	
	//�޴��ɼǹ�ȣ�� �޴��ɼ����� ��������
	public MenuOptionVo select_menu_optionOne(int option_num) {
		return session.selectOne(NAMESPACE+".select_menu_optionOne",option_num);
	}
	
}








