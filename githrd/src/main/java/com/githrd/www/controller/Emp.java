package com.githrd.www.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.*;
import com.githrd.www.vo.*;

@Controller
@RequestMapping("/emp")
public class Emp {
	
	//@Autowired(required=false) 빈처리되어있지 않아도 처리해야할때 사용
	@Autowired
	EmpDao eDao;

	// 사원 페이지 폼보기 요청 처리함수
	@RequestMapping("/empPage.blp")
	public ModelAndView empPage(ModelAndView mv) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("부서");
		list.add("직급");
		
		List<EmpVO> iList = eDao.getIniList();
		mv.addObject("ILIST", iList);
		
		// 데이터 전달하고
		mv.addObject("LIST", list);
		mv.setViewName("emp/empPage");
		return mv;
	}
	
	// 분류리스트 요청 처리함수
	@RequestMapping("/selList.blp")
	@ResponseBody
	public List<EmpVO> selList(EmpVO eVO) {
		List<EmpVO> list = eDao.selList(eVO);
		return list;
	}

	// 파트리스트 요청 처리함수
	@RequestMapping("/partList.blp")
	@ResponseBody
	public List<EmpVO> partList(EmpVO eVO) {
		List<EmpVO> list = eDao.partList(eVO);
		return list;
	}
	
	// 사원정보조회 요청 처리함수
	@RequestMapping("/empInfo.blp")
	@ResponseBody
	public EmpVO empInfo(EmpVO eVO) {
		eVO = eDao.empInfo(eVO);
		return eVO;
	}
	
	// 사원정보조회 요청 처리함수
	@RequestMapping("/enameList.blp")
	@ResponseBody
	public List<EmpVO> enameList(EmpVO eVO) {
		List<EmpVO> list = eDao.nameList(eVO);
		return list;
	}
}
