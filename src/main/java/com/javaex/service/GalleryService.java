package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	GalleryDao galleryDao;

	//전체 가져오기
	public List<GalleryVo> getGallery() {
		System.out.println("GalleryService>getGallery");

		return galleryDao.getGallery();

	}

}
