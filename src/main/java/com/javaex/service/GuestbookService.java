package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestbookService {

	// 필드
	@Autowired
	private GuestbookDao guestbookDao;

	// 생성자

	// 메소드

	// 메소드 일반

	// 방명록 저장 ajax
	public GuestBookVo addGuest(GuestBookVo guestbookVo) {
		System.out.println("GuestService->addGuest");

		// 저장
		int count = guestbookDao.insertGuest(guestbookVo);

		int no = guestbookVo.getNo();

		//방금 저장한 1개의 데이터를 가져온다.
		GuestBookVo gVo = guestbookDao.getGuest(no);

		return gVo;

	}

/////////////////////////////////////////////////////////////////////////////////////////	

	// 삭제
	public int delete(GuestBookVo guestbookVo) {
		System.out.println("GuestBookService>delete");

		int count = guestbookDao.delete(guestbookVo);

		return count;
	}

	// 방명록 addList 전체출력
	public List<GuestBookVo> getGuestList() {
		System.out.println("GuestBookService>addlist");

		List<GuestBookVo> guestList = guestbookDao.getGuestList();

		return guestList;
	}

	// addList 방명록 추가
	public int insert(GuestBookVo guestbookVo) {
		System.out.println("GuesetbookService>add");

		// dao를 통해서 데이터 저장
		int count = guestbookDao.insert(guestbookVo);

		return count;

	}

}
