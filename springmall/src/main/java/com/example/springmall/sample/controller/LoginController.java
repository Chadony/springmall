package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springmall.sample.service.SampleService;

@Controller
public class LoginController {
	private SampleService sampleService;
	//로그인 화면
	@RequestMapping(value="/sample/login")
	public String login() {
		return "redirect:/sample/logincheck"; // sample/logincheck로 포워드
	}
	//로그인 액션
	@RequestMapping(value="/sample/logincheck")
	public String logincheck(HttpSession session) {
		session.setAttribute("session", "session");
		return "redirect:/sample/sampleList";
	}
	//로그아웃 액션
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/sample/login";
	}
}
