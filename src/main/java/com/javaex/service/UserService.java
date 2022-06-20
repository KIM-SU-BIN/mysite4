package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// 필드
	@Autowired
	public UserDao userDao;

	// 생성자

	// 메소드

	// 메소드 일반
	//수정 update
	public int update(UserVo userVo) {
		System.out.println("UserService.update()");
		
		int count = userDao.userUpdate(userVo);

		return count;
	}
		
	
	// getUser
	public UserVo getUser(int no) {
		System.out.println("UserService.getUser()");

		UserVo userVo = userDao.getUser(no);

		return userVo;
	}

	// login 성공
	public UserVo login(UserVo userVo) {
		System.out.println("UserService.login()");

		UserVo authUser = userDao.getUser(userVo);

		return authUser;

	}

	// 회원가입
	public int join(UserVo userVo) {
		System.out.println("UserService.join()");

		// dao를 통해서 데이터 저장
		int count = userDao.userInsert(userVo);

		return count;
	}
}
