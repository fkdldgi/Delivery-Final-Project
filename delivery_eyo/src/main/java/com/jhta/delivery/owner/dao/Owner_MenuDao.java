package com.jhta.delivery.owner.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jhta.delivery.member.vo.MenuCategoryVo;
import com.jhta.delivery.member.vo.Menu_OptionVo;
@Repository
public class Owner_MenuDao {
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="mybatis.MenuMapper";
	
	public List<MenuCategoryVo> menuCategory(int num){
		return session.selectList(NAMESPACE+".Menu_category", num);
	}
	
	public List<Menu_OptionVo> menuOption(int num){
		return session.selectList(NAMESPACE+".Menu_Option", num);
	}
}
