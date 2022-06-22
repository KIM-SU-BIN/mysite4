package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 생성자

	// 메소드

	// 메소드 일반
	// 조회수
	public int hitUpdate(int no) {
		System.out.println("BoardDao>hitUpdate");

		int count = sqlSession.update("board.hitUpdate", no);

		return count;
	}

	// read 읽기/ 한 명 가져오기
	public BoardVo getBoard(int no) {
		System.out.println("BoardDao>read");

		BoardVo bVo = sqlSession.selectOne("board.getBoard", no);

		return bVo;
	}

	// 삭제
	public int delete(int no) {
		System.out.println("BoardDao>delete");

		int count = sqlSession.delete("board.boardDelete", no);

		return count;
	}

//******************************************  write	***************************************** 	
	public int boardInsert(BoardVo boardVo) {
		System.out.println("BoardDao>write");

		int count = sqlSession.insert("board.boardInsert", boardVo);

		return count;

	}

//******************************************  list	***************************************** 
	// list 목록 불러오기
	public List<BoardVo> getBoard(String keyword) {
		System.out.println("BoardDao>boardList");

		List<BoardVo> bList = sqlSession.selectList("board.boardList", keyword);

		return bList;
	}

}
