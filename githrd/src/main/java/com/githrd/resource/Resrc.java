package com.githrd.resource;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Resrc {
	
	@RequestMapping({"/img/*", "/css/*", "/js/*"})
	public String getResouece() {
		String view = "";
		// /img/avatar/img_avatar1.png
		// ==> img/avatar/img_avatar1
		
		// 여기서 요청 내용에 따라 뷰처리
		return view;
	}
}
