package com.githrd.www.dao;

import java.util.List;


import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.githrd.www.util.*;
import com.githrd.www.vo.*;

/**
 * 이 클래스는 댓글게시판 관련 데이터 베이스 전담 처리함수들로 구성된 클래스
 * @author 이용현
 * @since 2022.06.08
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				2022.06.08	- 담당자 : 이용현
 * 									클래스 제작, 리스트 조회
 *
 */

public class ReBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 게시글 리스트 조회 전담 처리함수
	public List<BoardVO> getList(PageUtil page){
		return sqlSession.selectList("rSQL.getList", page);
	}
	
	// 총 게식들 수 조회 전담 처리함수
	public int getTotal() {
		return sqlSession.selectOne("rSQL.getTotal");
	}
	
	// 장성자 데이터 조회 전담 처리함수
	public BoardVO getWriterInfo(String id) {
		return sqlSession.selectOne("rSQL.getWriterInfo", id);
	}
	
	// 게시글 추가 데이터베이스 작업 전담 처리함수(댓글 포함)
	public int addReBoard(BoardVO bVO) {
		return sqlSession.insert("rSQL.addReBoard", bVO);
	}
	
	// 댓글폼 데이터 조회 전담 처리함수
	public BoardVO getCommentData(BoardVO bVO) {
		return sqlSession.selectOne("rSQL.commentData", bVO);
	}
	
	// 게시글 수정데이터 조회 전담 처리함수
	public BoardVO getEditData(BoardVO bVO) {
		return sqlSession.selectOne("rSQL.editData", bVO);
	}
	
	// 게시글 수정 등록 전담 처리함수
	public int editProc(BoardVO bVO) {
		return sqlSession.update("rSQL.editReBoard", bVO);
	}
	
	// 게시글 삭제 전담 처리함수
	public int delReBoard(BoardVO bVO) {
		return sqlSession.update("rSQL.delReBoard", bVO);
	}
	
/*	
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
*/
	
}
