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
	
	// 메뉴리스트
	public List<MenuVo> mainMenuList(int num){
		return session.selectList(NAMESPACE+".mainMenuList", num);
	}
	
	// 메뉴삭제
	public int deleteMenu(int num) {
		return session.delete(NAMESPACE+".deleteMenu", num);
	}
	
	// 메뉴카테고리삭제
	public int deleteMenu_Category(int num) {
		return session.delete(NAMESPACE+".deleteMenu_Category", num);
	}
	
	// 메뉴추가
	public int insertMenu(MenuVo vo) {
		return session.insert(NAMESPACE+".insertMenu", vo);
	}
	
	// 메뉴카테고리 추가
	public int insertMenu_Category(MenuCategoryVo vo) {
		return session.insert(NAMESPACE+".insertMenu_Category", vo);
	}
	
	// 메뉴수정
	public int updateMenu(MenuVo vo) {
		return session.update(NAMESPACE+".updateMenu", vo);
	}
	
	// 메뉴카테고리수정
	public int updateMenu_Category(MenuCategoryVo vo) {
		return session.update(NAMESPACE+".updateMenu_Category", vo);
	}
	
	// 메뉴카테고리번호 찾기
	public int selectMenu_CategoryNum(MenuCategoryVo vo) {
		return session.selectOne(NAMESPACE+".selectMenu_CategoryNum", vo);
	}
	
}
