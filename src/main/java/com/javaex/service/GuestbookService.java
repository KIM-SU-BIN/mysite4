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
	
	
	// 방명록 addList 출력
	public List<GuestBookVo> getGuestList() {
		System.out.println("GuestBookService>addlist");
		
		List<GuestBookVo> gList = guestbookDao.getGuestList();
		
		return gList;
	}
	
	
	//addList 방명록 추가
	public int insert(GuestBookVo guestbookVo) {
		System.out.println("GuesetbookService>add");
		
		// dao를 통해서 데이터 저장
		int count = guestbookDao.insert(guestbookVo);
		
		return count;
		
	}

}
