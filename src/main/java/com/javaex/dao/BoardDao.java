package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	//리스트4 (일반 게시판 =====> + 페이징 + 검색)
	public List<BoardVo> selectList4(int startRnum , int endRnum) {
		System.out.println("BoardDao>selectList4");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		System.out.println(map);		//출력 결과 : {startRnum=1, endRnum=5} -> Dao에 int listCnt = 5; 페이지당 글 수가 5이기 때문

		List<BoardVo> boardList = sqlSession.selectList("board.selectList4", map);
		System.out.println("boardList");
		
		return boardList;
	}
	
// ================================================================================================================//
	
	//수정
	public int modify(BoardVo boardVo) {
		System.out.println("BoardDao>modify");
		
		int count = sqlSession.update("board.modify", boardVo);
		
		return count;
	}
	
	
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
	
//******************************************  삭제 ***************************************** 	

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
	
	// list 전체 글 가져올 경우 String keyword만 없음!
	/*public List<BoardVo> getBoard() {
		System.out.println("BoardDao>boardList");

		List<BoardVo> bList = sqlSession.selectList("board.boardList");

		return bList;
	}*/

}
