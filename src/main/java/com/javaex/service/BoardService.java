package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	// 필드
	@Autowired
	private BoardDao boardDao;

	// 생성자

	// 메소드

	// 메소드 일반

	// 리스트4 (일반 게시판 =====> + 페이징 + 검색)
	// crtPage : 현재페이지
	public Map<String, Object> getBoardList4(int crtPage) {
		System.out.println("board>getBoardList4");

		//////////////////////////////////////////////
		// 리스트 가져오기
		//////////////////////////////////////////////

		// 페이지당 글 개수(총 10페이지 기준)
		int listCnt = 5;

		// 현재 페이지 -> 페이지가 -1 페이지 될 수 없음 (즉 0보다 작으면 무조건 1페이지로 돌아가라~)
		// 아래와 같은 코드 => if(crtPage>0) { }else{crtPage=1;}
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);

		// 시작글 번호 ->listCnt에 따라 startRnum가 변함
		int startRnum = (crtPage - 1) * listCnt + 1;

		// 끝글 번호
		int endRnum = (startRnum + listCnt) - 1;

		// page 찍어보기 : 브라우저 주소 mysite4/board/list4?crtPage=1
		// System.out.println(listCnt);

		List<BoardVo> boardList = boardDao.selectList4(startRnum, endRnum);

		//////////////////////////////////////////////
		// 페이징 계산
		//////////////////////////////////////////////

		// 전체 글개수
		int totalCnt = boardDao.selectTotalCnt();

		// 페이지당 버튼 갯수
		int pageBtnCount = 5;

		// 마지막 버튼 번호
		int endPageBtnNo = (int) Math.ceil(crtPage / (double) pageBtnCount) * pageBtnCount;

		// 마지막 버튼 번호
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		
		
		// 다음 화살표 유무
		boolean next = false;
		if ((listCnt * endPageBtnNo) < totalCnt) {
			next = true;

		} else {
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
		}

		// 이전 화살표 유무
		boolean prev = false;
		if (startPageBtnNo != 1) {
			prev = true;
		}

		
		
		
		// 리스트 페이징 정보 묶기
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList);
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);

		return pMap;
	}

// ================================================================================================================//	

	// 수정
	public int modify(BoardVo boardVo) {
		System.out.println("board.modify");

		int count = boardDao.modify(boardVo);

		return count;

	}

	// 조회수
	public int hitUpdate(int no) {
		System.out.println("board.hitUpdate");

		int count = boardDao.hitUpdate(no);
		return count;
	}

	// read 읽기/ 한 명 가져오기
	public BoardVo getBoard(int no) {
		System.out.println("BoardService>read");

		BoardVo bVo = boardDao.getBoard(no);

		return bVo;
	}

	// 삭제
	public int delete(int no) {
		System.out.println("BoardService>delete");

		int count = boardDao.delete(no);

		return count;
	}

	// write 글쓰기
	public int write(BoardVo boardVo) {
		System.out.println("BoardService>write");

		// list4 임시 : 127개의 게시글 작성을 위한 코드
		for (int i = 1; i <= 127; i++) {

			boardVo.setTitle(i + "번째 게시글(제목) 입니다.");
			boardVo.setContent(i + "번째 게시글(내용) 입니다.");

			boardDao.boardInsert(boardVo);

		}

		// dao를 통해서 데이터 저장
		// return boardDao.boardInsert(boardVo);

		// 임시ver
		return 1;
	}

	// getlist
	public List<BoardVo> getboard(String keyword) {
		System.out.println("BoardService>getlist");

		List<BoardVo> bList = boardDao.getBoard(keyword);

		return bList;
	}

}
