package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {

	// 필드
	@Autowired
	private GalleryService galleryService;

	// 생성자

	// 메소드

	// 메소드 일반

	// 이미지 등록
	@RequestMapping(value = "/gallery/upload", method = { RequestMethod.GET, RequestMethod.POST })
	public String imgUpload(@ModelAttribute GalleryVo galleryVo) {
		System.out.println("GalleryController->imgUpload()");

		System.out.println(galleryVo);

		galleryService.upload(galleryVo, null);
		
		return "redirect:/gallery/list";
	}

	// 이미지 1개 정보 가져오기
	@ResponseBody
	@RequestMapping(value = "/gallery/getImg", method = { RequestMethod.GET, RequestMethod.POST })
	public GalleryVo getImg(Model model, @RequestParam("no") int no) {
		
		System.out.println("GalleryController->getImg()");
	
		return galleryService.getImg(no);
	}

	// 업로드 폼
	@RequestMapping(value = "/gallery/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String listForm(Model model) {
		System.out.println("GalleryController>listForm");

		// 서비스 불러오기
		List<GalleryVo> galleryList = galleryService.getGallery();

		model.addAttribute("galleryList", galleryList);

		return "/gallery/list";
	}
}
