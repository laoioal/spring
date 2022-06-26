package com.githrd.www.interceptor;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 회원 관련 요청을 할 때
 * 로그인이 되어있는 경우는 메인페이지로 돌려보내는 작업을 처리할
 * 인터셉터 클래스
 * @author 이용현
 * @since 2022/06/24
 * @version v.1.0
 * 				
 * 				작업이력 ]
 * 					2022/06/24	- 담당자 : 이용현
 * 									클래스 제작
 */

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override	// 함수시작 전
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		System.out.println("-------------------");
		
		if(req.getSession().getAttribute("SID") != null) {
			resp.sendRedirect("/www/main.blp");
			return false; // 요청처리 함수 싱행하지 마세요
		}
		return true;	// 요청 처리함수 실행을 해주세요
	}

	@Override	// 함수시작 후
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		

	}

}
