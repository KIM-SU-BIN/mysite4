package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	// 필드
	@Autowired
	UserService userService;

	// 생성자

	// 메소드

	// 메소드 일반

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 수정하기 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//	

	@RequestMapping(value = "/modifyForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("UserController>modifyForm()");

		// 정보 불러오기
		UserVo userVo = userService.getUser(no);

		model.addAttribute("userVo", userVo);

		return "user/modifyForm";
	}

	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController>modify()");

		// authUser에 저장되어 있는 no를 가져오기 위해서 씀
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		int no = authUser.getNo();

		// authUser에 가져온 no를 저장하기
		userVo.setNo(no);

		// 정보 업데이트
		userService.update(userVo);

		return "redirect:/main";
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 로그아웃 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("UserController>logout()");

		// 세션값을 지운다
		session.removeAttribute("autherUser");

		// 현재 사용하고 있는 세션 값을 무효화한다.
		session.invalidate();

		return "user/loginForm";
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 회원가입 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//	

	// 회원가입 (join)
	@RequestMapping(value = "/join", method = { RequestMethod.GET, RequestMethod.POST })
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController>join()");

		int count = userService.join(userVo);
		// System.out.println("UserController: + count");

		return "user/joinOk";
	}

	// 회원가입폼 (joinForm)
	@RequestMapping(value = "/joinForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String joinForm() {
		System.out.println("UserController>joinForm()");

		return "user/joinForm";
	}

	// 아이디 중복체크 (회원가입)
	@ResponseBody
	@RequestMapping(value = "/checkId", method = { RequestMethod.GET, RequestMethod.POST })
	public String idCheck(@ModelAttribute UserVo userVo) {
		System.out.println("UserController->idCheck()");
		return userService.checkId(userVo.getId());
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 로그인 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

	// 로그인
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController>login()");

		UserVo authUser = userService.login(userVo);

		// 세션에 저장
		if (authUser != null) { // 로그인 성공

			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/main";

		} else { // 로그인 실패
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}

	}

	// 로그인폼 (loginForm)
	@RequestMapping(value = "/loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UserController>loginForm()");

		return "user/loginForm";
	}

}
