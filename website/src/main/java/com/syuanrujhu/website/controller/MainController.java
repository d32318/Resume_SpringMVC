package com.syuanrujhu.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("MemberAccount/LogInPage")
	public String LoggingPage(String loginresult, Model model) {
		System.out.println("GetMapping：Start");
		loginresult = "Welcome!";
		model.addAttribute("loginresult", loginresult);
		return "logInPage";
	}
	
	@GetMapping("MemberAccount/registerPage")
	public String registerPage(String registerResult, Model model) {
		System.out.println("GetMapping：registerPage");
		registerResult = "Welcome registerPage!";
		model.addAttribute("registerResult", registerResult);
		return "registerPage";
	}
	
	@GetMapping("MemberAccount/SyuanRuJhu/MainPage")
	public String MainPage() {
		return "mainPage";
	}
	
	@GetMapping("MemberAccount/SyuanRuJhu/SchoolPage")
	public String SchoolPage() {
		return "schoolPage";
	}
	
	@GetMapping("MemberAccount/SyuanRuJhu/WorkPage")
	public String WorkPage() {
		return "workPage";
	}
	
	@GetMapping("MemberAccount/SyuanRuJhu/SkillPage")
	public String SkillPage() {
		return "skillPage";
	}
}
