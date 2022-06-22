package com.javaex.service;

import java.util.List;

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
	
	
	//조회수
	public int hitUpdate(int no) {
		System.out.println("board.hitUpdate");
		
		int count = boardDao.hitUpdate(no);
		return count;
	}
	
	
	//read 읽기/ 한 명 가져오기 
	public BoardVo getBoard(int no) {
		System.out.println("BoardService>read");
		
		BoardVo bVo = boardDao.getBoard(no);
		
		return bVo;
	}
	
	
	//삭제
	public int delete(int no) {
		System.out.println("BoardService>delete");
		
		int count = boardDao.delete(no);
		
		return count;
	}
	
	//write 쓰기
	public int write(BoardVo boardVo) {
		System.out.println("BoardService>write");
		
		// dao를 통해서 데이터 저장
		int count = boardDao.boardInsert(boardVo);
		
		return count;
	}
	
	
	//getlist
	public List<BoardVo> getboard(String keyword) {
		System.out.println("BoardService>getlist");
		
		List<BoardVo> bList = boardDao.getBoard(keyword);
		
		return bList;
	}


}
