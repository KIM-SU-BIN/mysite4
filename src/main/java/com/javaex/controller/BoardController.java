package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 일반+검색 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	@RequestMapping(value = "/list3", method = { RequestMethod.GET, RequestMethod.POST })
	public String search(Model model, @RequestParam( value="keyword", required=false, defaultValue="수빈킴") String keyword) {
		System.out.println("BoardController>list3");

		System.out.println("keyword");

		//List<BoardVo> bList = boardService.getBoardlist3();
		//model.addAllAttributes("boardList", boardList);

		return "/board/list3";
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 수정 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	@RequestMapping(value = "/modifyForm/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@PathVariable("no") int no, Model model) {
		System.out.println("BoardController>modifyForm");

		BoardVo bVo = boardService.getBoard(no);
		model.addAttribute("bVo", bVo);

		return "board/modifyForm";
	}

	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>modify");

		boardService.modify(boardVo);

		return "redirect:/board/list";
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 읽기 read ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	@RequestMapping(value = "/read/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@PathVariable("no") int no, Model model) {
		System.out.println("BoardController>read");

		// 1. 서비스에서 데이터를 부른다
		boardService.hitUpdate(no);

		// 2.Vo에서 불러오기
		BoardVo bVo = boardService.getBoard(no);

		// 3.모델에 저장
		model.addAttribute("bVo", bVo);

		return "/board/read";
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 삭제 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	@RequestMapping(value = "/delete/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("no") int no) {
		System.out.println("BoardController>delete");

		boardService.delete(no);

		return "redirect:/board/list";
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 쓰기 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>writeForm");

		return "board/writeForm";
	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController>write");

		boardService.write(boardVo);

		return "redirect:/board/list";
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  리스트(게시판) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//		

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(String keyword, Model model) {
		System.out.println("BoardController>list");
		if (keyword == null) {
			keyword = "";
		}
		keyword = "%" + keyword + "%";
		// boardList 데이터 가져오기
		List<BoardVo> bList = boardService.getboard(keyword);

		model.addAttribute("bList", bList);

		return "board/list";
	}

}
