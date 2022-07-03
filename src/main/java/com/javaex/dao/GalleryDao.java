package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 생성자

	// 메소드

	// 메소드 일반
	//전체 가져오기
	public List<GalleryVo> getGallery() {
		System.out.println("GalleryDao>getGallery");
		
		return sqlSession.selectList("gallery.getGallery");
	}

	
	
	
	
}
