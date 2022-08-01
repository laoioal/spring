package com.githrd.www.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MapTest {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<Map<String, String>> getData(String id) {
		return sqlSession.selectList("rsmember", id);
	}
}
