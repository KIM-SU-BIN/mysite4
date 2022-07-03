package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {
	
	//필드
	@Autowired
	private GalleryService galleryService;
	
	// 생성자

	// 메소드

	// 메소드 일반
	
	//갤러리 업로드 폼
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String listForm(Model model) {
		System.out.println("GalleryController>listForm");
		
		// 서비스 불러오기
		List<GalleryVo> galleryList = galleryService.getGallery();
		
		model.addAttribute("galleryList", galleryList);
		
		return "/gallery/list";
	}
}
