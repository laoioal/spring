package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.GBoardVO;

public class GBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 방명록 리스트 
	public List<GBoardVO> getList(PageUtil page) {
		return sqlSession.selectList("gSQL.glist", page);
	}
	// 방명록 작성여부 확인
	public int boardCnt(String id) {
		return sqlSession.selectOne("gSQL.boardCnt", id);
	}
	
	// 방명록 전체 게시글 수
	public int boardListCnt() {
		return sqlSession.selectOne("gSQL.boardListCnt");
	}
	
	// 방명록 작성 폼 정보
	public GBoardVO writeInfo(String id) {
		return sqlSession.selectOne("gSQL.writeInfo", id);
	}
	
	// 방명록 처리 요청
	public int gboardProc(GBoardVO gVO) {
		return sqlSession.insert("gSQL.gboardProc", gVO);
	}

}
