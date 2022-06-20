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
	// 삭제폼 deleteForm
	@RequestMapping(value = "/user/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("GuestController>deleteForm");
		
		return "guestbook/deleteForm";
	}

	// 방명록 addList
	@RequestMapping(value = "/user/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList() {
		System.out.println("GuestController>addList");

		return "guestbook/addList";
	}
}
