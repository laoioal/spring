package com.githrd.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.githrd.www.dao.*;
import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.*;

@Controller
@RequestMapping("/reboard")
public class ReBoard {
	@Autowired
	ReBoardDao rDao ;
	@Autowired
	PageUtil page;

	
	@RequestMapping(path="/reboardList", method=RequestMethod.POST, params="nowPage")
	public ModelAndView ReBoardList(ModelAndView mv, PageUtil page, int nowPage) {
		
		int totalPage = rDao.reboardCnt();
		page = new PageUtil(nowPage, totalPage);
		mv.addObject("PAGE", page);
		
		List<GBoardVO> list = rDao.ReBoardList(page);
		mv.addObject("LIST", list);
		
		mv.setViewName("reboard/reboardList");
		return mv;
		
	}
	
	@RequestMapping("/reboardWrite.blp")
	public ModelAndView ReBoardWrite(ModelAndView mv, HttpSession session, RedirectView rv) {
		String id = (String) session.getAttribute("SID");
		if(id == null) {
			rv.setUrl("/www/member/login.blp");
			mv.setView(rv);
			return mv;
		}

		GBoardVO gVO = rDao.getIdInfo(id);
		mv.addObject("DATA", gVO);
		mv.setViewName("reboard/reboardWrite");
		return mv;
	}
	
	@RequestMapping(path="reboardWriteProc.blp", method=RequestMethod.POST, params={"nowPage", "body"})
	public ModelAndView ReBoardWriteProc(ModelAndView mv, HttpSession session, RedirectView rv, GBoardVO gVO, int nowPage) {
		String id = (String) session.getAttribute("SID");
		if(id == null) {
			rv.setUrl("/www/member/login.blp");
			mv.setView(rv);
			return mv;
		}
		
		int totalPage = rDao.reboardCnt();
		page = new PageUtil(nowPage, totalPage);
		mv.addObject("PAGE", page);
		
		int cnt = rDao.insertReboard(gVO);
		
		if(cnt == 1) {
			
		} else {
			
		}
		
		return mv;
	}
	
}
