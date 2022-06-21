package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	// 필드
	@Autowired
	BoardService boardService;

	// 생성자
	// 메소드
	// 메소드-일반
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  방명록 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	
	@RequestMapping(value = "/addlist", method = {RequestMethod.GET, RequestMethod.POST })
	public String addList() {
		System.out.println("BoardController>addlist");
		
		
		return "";
	}
	
	

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  리스트(게시판) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//		
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST })
	public String list(String keyword, Model model){
		System.out.println("BoardController>list");
		if(keyword == null) {
			keyword = "";
		}
		keyword = "%" + keyword + "%";
		//boardList 데이터 가져오기
		List<BoardVo> bList = boardService.getboard(keyword);
		
		model.addAttribute("bList", bList);
		
		return "board/list";
	}

}
