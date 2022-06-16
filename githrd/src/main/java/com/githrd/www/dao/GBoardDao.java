package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.*;

public class GBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 방명록 작성 글 수 조회 전담 처리 함수
	public int getMyCount(String id) {
		return sqlSession.selectOne("gSQL.myCount", id);
	}
	
	// 총 게시글 수 조회 전담 처리 함수
	public int getTotal() {
		return sqlSession.selectOne("gSQL.totalCount");
	}
	
	// 게시글 리스트 조회 전담 처리함수
	public List<BoardVO> getList(PageUtil page) {
		return sqlSession.selectList("gSQL.gBoardList", page);
	}
	
	// 게시글 작성 폼 데이터 조회 전담 처리함수
	public BoardVO getWriteData(String id) {
		return sqlSession.selectOne("gSQL.writeData", id);
	}
	
	// 게시글 데이터베이스 등록 전담 처리 함수
	public int addGBoard(BoardVO bVO) {
		return sqlSession.insert("gSQL.addGBoard", bVO);
	}
/*	
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
*/
}
