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
	
	
	//******************************************  list	***************************************** 
	//list 목록 불러오기
	public List<BoardVo> getBoard(String keyword) {
		System.out.println("BoardDao>boardList");
		
		List<BoardVo> bList = sqlSession.selectList("board.boardList", keyword);
		
		return bList;
	} 

}
