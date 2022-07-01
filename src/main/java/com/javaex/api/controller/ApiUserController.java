package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;

@Controller
public class ApiUserController {
	
	// 필드
	@Autowired
	public UserService userService;

	// 생성자

	// 메소드gs

	// 메소드 일반

	//아이디 중복체크 (login회원가입) : 정보 한번에 가져오기 위해 @RequestBody 사용
	
	@ResponseBody
	@RequestMapping(value = "/checkId", method = { RequestMethod.GET, RequestMethod.POST })
	public String checkId(@RequestBody String id)  {
		System.out.println("ApiUsersController>checkId");
		
		String check = userService.checkId(id);
		
		return check;
		//= return userService.checkId(id);
	}
	
}
