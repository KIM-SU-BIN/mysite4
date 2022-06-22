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
