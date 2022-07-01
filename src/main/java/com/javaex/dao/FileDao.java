package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVo;

@Repository
public class FileDao {

	@Autowired
	private SqlSession sqlSession;

	// 생성자

	// 메소드

	// 메소드 일반
	//저장
	public int insertFile(FileVo fileVo) {
		System.out.println("FileDao>insertFile");
		
		int count = sqlSession.insert("insert.file", fileVo);

		return count;
		// ==return sqlSession.insert("insert.file", fileVo);

	}

}
