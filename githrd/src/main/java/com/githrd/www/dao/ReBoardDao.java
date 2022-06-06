package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.GBoardVO;

public class ReBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 댓글게시판 리스트 불러오는 함수
	public List<GBoardVO> ReBoardList(PageUtil page) {
		return sqlSession.selectList("rSQL.reboardList", page);
	}
	
	// 댓글게시판 전체 개수 확인 함수
	public int reboardCnt() {
		return sqlSession.selectOne("rSQL.reboardCnt");
	}
	
	// 댓글게시판 댓글 작성자 정보 불러오는 함수
	public GBoardVO getIdInfo(String id) {
		return sqlSession.selectOne("rSQL.getIdInfo", id);
	}
	
	// 댓글 코멘트 작성 처리함수
	public int insertReboardcom(GBoardVO gVO) {
		return sqlSession.insert("rSQL.insertReboardcom", gVO);
	}
	
	// 댓글 작성 처리함수
	public int insertReboard(GBoardVO gVO) {
		return sqlSession.insert("rSQL.insertReboard", gVO);
	}
}
