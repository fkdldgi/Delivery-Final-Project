package com.jhta.delivery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.vo.MenuCategoryVo;
import com.jhta.delivery.vo.MenuVo;

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
	
	// �޴��߰�
	public int insertMenu(MenuVo vo) {
		return session.insert(NAMESPACE+".insertMenu", vo);
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
	
}
