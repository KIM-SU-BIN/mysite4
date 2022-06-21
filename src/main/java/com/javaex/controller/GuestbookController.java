package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping(value = "/guestbook")
public class GuestbookController {

	// 필드
	@Autowired
	GuestbookService guestbookService;

	// 생성자

	// 메소드

	// 메소드 일반
	
	
//*************************************	deleteForm *************************************		
	// 삭제폼 deleteForm
	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@RequestParam int no, Model model) {
		System.out.println("GuestController>deleteForm");

		model.addAttribute("no", no );
		
		return "guestbook/deleteForm";
	}

	
	// 삭제 delete
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestBookVo guestbookVo) {
		System.out.println("GuestController>delete");
		
		int count = guestbookService.delete(guestbookVo);
		
		return "redirect:/guestbook/addList";
	}
	
//*************************************	addList/add *************************************	

	// 방명록 addList
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestController>addList");

		// 서비스 불러오기
		List<GuestBookVo> guestbookList = guestbookService.getGuestList();
		model.addAttribute("guestbookList", guestbookList);

		return "guestbook/addList";
	}

	// 방명록 add추가
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestBookVo guestbookVo) {
		System.out.println("GuestController>add");

		// 데이터 Vo에 저장하기
		int count = guestbookService.insert(guestbookVo);

		return "redirect:/guestbook/addList";
	}

}
