package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GalleryService;

@Controller
public class GalleryController {
	
	//필드
	@Autowired
	GalleryService galleryService;
	
	//Form 
	@RequestMapping(value="/getImg", method= {RequestMethod.GET, RequestMethod.POST})
	public void getImg() {
		System.out.println("GalleryController>getImg");
		
		
	}
}
