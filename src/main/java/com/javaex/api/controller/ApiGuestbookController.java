package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestBookVo;

@Controller
public class ApiGuestbookController {
	
	//필드
	@Autowired
	public GuestbookService guestbookService;
	
	//생성자
	
	//메소드gs
	
	//메소드 일반

	@RequestMapping(value = "/api/guestbook/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList() {
		System.out.println("ApiGuestbookController>addList()");

		return "apiGuestbook/addList";
	}

	// 방명록 리스트 데이터만 보내줘
	@ResponseBody
	@RequestMapping(value = "/api/guestbook/list", method = { RequestMethod.GET, RequestMethod.POST })
	public List<GuestBookVo> list() {
		System.out.println("ApiGuestbookController>list()");
		
		 List<GuestBookVo> guestbookList = guestbookService.getGuestList();
		 System.out.println(guestbookList);
		 
		return guestbookList;
	}
}
