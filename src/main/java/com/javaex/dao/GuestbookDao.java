package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 생성자

	// 메소드

	// 메소드 일반
	
	// 방명록 저장(ajax)
	public int insertGuest(GuestBookVo guestbookVo) {
		System.out.println("guestbookDao>insertGuest");

		int count = sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		
		return count;
		
	}
	
	
	// 방명록 저장 후 등록한 데이터 가져오기  ajax
	public GuestBookVo getGuest(int no) {
		System.out.println("guestbookDao>getGuest");

		GuestBookVo guestbookVo = sqlSession.selectOne("guestbook.getGuest", no);
		
		return guestbookVo;
		
	}

/////////////////////////////////////////////////////////////////////////////////////////
	
	// 방명록 삭제 -> 모달
	public int delete2(GuestBookVo guestbookVo) {
		System.out.println("guestbookDao>delete2");

		return sqlSession.delete("guestbook.delete2", guestbookVo);
		
		
	}
	
	
	// 삭제
	public int delete(GuestBookVo guestbookVo) {
		System.out.println("guestbookDao>delete");

		int count = sqlSession.delete("guestbook.delete", guestbookVo);

		return count;
	}

	// addList 전체출력
	public List<GuestBookVo> getGuestList() {
		System.out.println("guestbookDao>addList");

		List<GuestBookVo> bookList = sqlSession.selectList("guestbook.bookList");

		return bookList;
	}

	// addList 추가
	public int insert(GuestBookVo guestbookVo) {
		System.out.println("guestbookDao>integer");

		// 입력정보 저장하기
		int count = sqlSession.insert("guestbook.insert", guestbookVo);

		return count;
	}

}
