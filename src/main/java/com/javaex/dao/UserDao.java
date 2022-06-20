package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	// 생성자

	// 메소드

	// 메소드 일반
	//수정하기
	public int userUpdate(UserVo userVo) {
		System.out.println("UserDao.userUpdate()");
		
		int count = sqlSession.update("user.userUpdate", userVo);
		
		return count;
	}
		
	// 로그아웃
	public UserVo getUser(int no) {
		System.out.println("UserDao.getUser()");

		UserVo uVo = sqlSession.selectOne("user.getUser", no);

		return uVo;
	}

	// 회원정보 가져오기 login 성공
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao.getUser()");

		UserVo authVo = sqlSession.selectOne("user.getUser", userVo);
		System.out.println(authVo);

		return authVo;

	}

	// 회원정보 저장(회원가입) insert
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");

		int count = sqlSession.insert("user.insert", userVo);

		System.out.println(userVo);

		return count;
	}

}
