package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GuestbookController {

	// 필드

	// 생성자

	// 메소드

	// 메소드 일반
	//삭제폼 deleteForm
	
	
	
	
	
	//방명록 addList
	@RequestMapping(value="/addList", method = {RequestMethod.GET,RequestMethod.POST})
	public String addList() {
		System.out.println("GuestController>addList");
		
		return "guestbook/addList";
	}
}
