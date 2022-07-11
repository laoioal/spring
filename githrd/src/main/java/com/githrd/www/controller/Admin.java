package com.githrd.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.githrd.www.dao.*;
import com.githrd.www.service.*;
import com.githrd.www.vo.*;


@Controller
@RequestMapping("/admin")
public class Admin {
	@Autowired
	MemberDao mDao;
	
	@Autowired
	DeleteMember dMemb;
	
	// 관리자페이지 폼보기 요청 처리함수
	@RequestMapping("/adminPage.blp")
	public ModelAndView AdminPage(ModelAndView mv) {
		List<String> list = mDao.idList();
		mv.addObject("LIST", list);
		
		// 뷰 부르고
		mv.setViewName("member/admin");
		return mv;
	}
	
	// 회원데이터 삭체 요청 처리함수
	@RequestMapping("/delMember.blp")
	public ModelAndView delMember(ModelAndView mv, MemberVO mVO, RedirectView rv) {
		String result = "삭제 작업 실패";
		try {
			dMemb.delMember(mVO);
			result = mVO.getId() + " 회원 삭제 성공";
		} catch(Exception e) {
			result = "삭제 작업 실패";
		}
		mv.addObject("MSG", result);
		rv.setUrl("/www/admin/adminPage.blp");
		mv.setView(rv);
		return mv;
	}
}
