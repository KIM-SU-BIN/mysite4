package com.javaex.controller;

import java.util.List;
import java.util.Map;

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
	//리스트4 (일반 게시판 =====> + 페이징 + 검색) 
	@RequestMapping (value = "/list4", method = { RequestMethod.GET, RequestMethod.POST })
	public String list4(Model model, 
			@RequestParam(value = "crtPage", required = false, defaultValue = "1") int crtPage) {
		//이렇게 쓰는 이유 : 사용자가 list4?crtPage=1 주소가 아닌 list4 만 쓸 수 있기 때문에 오류 방지를 위하여 사용
		//required = false 오류 발생을 줄여주는 역할, defaultValue는 crtPage(현재페이지)라는 정보가 없을 경우 1페이지로 가라는 의미
		
		System.out.println("BoardController>list4");
		
		//getBoardList4() -> crtPage 넣어서 서비스로 넘겨주기
		//List<BoardVo> boardList = boardService.getBoardList4(crtPage);
		//model.addAttribute("boardList", boardList);
		
		Map<String, Object> pMap = boardService.getBoardList4(crtPage);
		model.addAttribute("pMap", pMap);
		
		System.out.println("controller --> " + pMap);
		
		return "board/list4";
	}
	
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
