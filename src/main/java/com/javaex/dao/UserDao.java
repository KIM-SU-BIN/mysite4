package com.javaex.dao;

import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	// 필드
	
	// 생성자
	
	// 메소드
	
	// 메소드 일반
	public void userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");
		
		System.out.println(userVo);
	}

}
