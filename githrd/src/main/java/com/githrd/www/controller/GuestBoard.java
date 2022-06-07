package com.githrd.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.githrd.www.dao.GBoardDao;
import com.githrd.www.dao.MemberDao;
import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.BoardVO;
import com.githrd.www.vo.GBoardVO;
import com.githrd.www.vo.MemberVO;

@Controller
@RequestMapping("/gBoard")
public class GuestBoard {
	@Autowired
	GBoardDao gDao;
	
	@Autowired
	MemberDao mDao;
	
	@Autowired
	PageUtil page;

	@RequestMapping("/gBoardList.blp")
	public ModelAndView gBoardList(ModelAndView mv, PageUtil page) {
//		System.out.println("page.nowPage : " + page.getNowPage());
//		System.out.println("page.nowPage : " + page.getPageRow());
		
		
		// 총 게시글 수 조회
		int total = gDao.getTotal();
		page.setPage(page.getNowPage(), total);
		
		// 게시글 목록 조회
		List<BoardVO> list = gDao.getList(page);
		
		// 데이터 심고
		mv.addObject("LIST", list);
		mv.addObject("PAGE", page);

		
		// 뷰 부르고				
		mv.setViewName("gBoard/gBoardList");
		return mv;
	}
	
	
	
	
	
	/*
	@RequestMapping(path="/gboardList.blp", params="nowPage")
	public ModelAndView gBoardList(ModelAndView mv, HttpSession session, int nowPage) {
		String id = (String) session.getAttribute("SID");
		
		if(id != null) {
			int cnt = gDao.boardCnt(id);
			mv.addObject("CNT", cnt);
		}
		
		
		int totalPage = gDao.boardListCnt();
		page = new PageUtil(nowPage, totalPage);
		mv.addObject("PAGE", page);
		List<GBoardVO> list = gDao.getList(page);
		mv.addObject("LIST", list);
		mv.setViewName("guestBoard/gBoardList");
		return mv;
	}
	
	@RequestMapping("/gboardForm.blp")
	public ModelAndView gBoardForm(ModelAndView mv, HttpSession session, RedirectView rv) {
		String id = (String) session.getAttribute("SID");
		if(id == null) {
			rv.setUrl("/www/member/login.blp");
			mv.setView(rv);
			return mv;
		}
		GBoardVO gVO = gDao.writeInfo(id);
		mv.addObject("DATA", gVO);
		mv.setViewName("guestBoard/gBoardWrite");
		return mv;
		
	}
	
	@RequestMapping(path="/gboardProc.blp", method=RequestMethod.POST, params={"mno", "body", "nowPage"})
	public ModelAndView gBoardPrco(ModelAndView mv, GBoardVO gVO, int nowPage, HttpSession session, RedirectView rv) {
		String id = (String) session.getAttribute("SID");
		if(id == null) {
			rv.setUrl("/www/member/login.blp");
			mv.setView(rv);
			return mv;
		}

		int cnt = gDao.gboardProc(gVO);
		if(cnt == 1) {
			int totalPage = gDao.boardListCnt();
			page = new PageUtil(nowPage, totalPage);
			
			mv.addObject("VIEW", "/www/gboard/gboardList.blp");
			mv.addObject("NOWPAGE", page.getNowPage());
			mv.setViewName("guestBoard/redirect");

			return mv;
		} else {
			rv.setUrl("/www/gboard/gboardForm.blp");
			mv.setView(rv);
			return mv;
		}
		

	}
	*/
}
