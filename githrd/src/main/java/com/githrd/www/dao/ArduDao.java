package com.githrd.www.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.githrd.www.vo.*;

@Component
public class ArduDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	/*
		측정 데이터 추가 전담 처리함수
	 */
	public int addData(ArduVO aVO) {
		return sqlSession.insert("aSQL.addData", aVO);
	}
	
	// 최근 5개의 데이터 조회 전담 처리함수
	public List<ArduVO> getTopFive(){
		return sqlSession.selectList("aSQL.topFive");
	}
	
	// 카운트 증가 처리 전담 처리함수
	public int addCount(String sdate) {
		
		System.out.println("########## sdate :" + sdate);
		return sqlSession.update("aSQL.addCnt", sdate);
	}
	
	public int addCount() {
		return sqlSession.update("aSQL.addCnt");
	}
	
	// 온습도 측정데이터 추가 전담 처리함수
	public int addDHT(ArduVO aVO) {
		return sqlSession.insert("aSQL.addTmpHum", aVO);
	}
}