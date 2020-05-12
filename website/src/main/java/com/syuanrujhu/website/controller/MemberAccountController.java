package com.syuanrujhu.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.syuanrujhu.website.service.MemberAccountService;

@Controller
public class MemberAccountController {
	@Autowired
	MemberAccountService checkAccount;
	
	@RequestMapping(value="MemberAccount/LogInPage", method=RequestMethod.POST)
    public String LogInCheck(@RequestParam(value="userID", required=true, defaultValue="null") String userID, 
    		@RequestParam(value="password", required=true, defaultValue="null") String password,
    		String loginresult,
    		Model model) throws InterruptedException {
		Thread.sleep(3000);
		if(!userID.equals("null") & !password.equals("null")) {
			System.out.println(userID + "：" + password);
			String checkResult = checkAccount.checkLoginInfo(userID, password);
			
	        if(checkResult == "pass!") {
	        	loginresult = "pass!";
	        	model.addAttribute("loginresult", loginresult);
	            System.out.println("Requestmapping：" + loginresult);
	            return "mainPage";
	        }
	        else{
	        	loginresult = "User/Password error!";
	        	model.addAttribute("loginresult", loginresult);
	            System.out.println("Requestmapping：" + loginresult);
	            return "logInPage";
	        }
		}else if(!password.equals("null")){
			loginresult = "User can't be empty!";
        	model.addAttribute("loginresult", loginresult);
            System.out.println("Requestmapping：" + loginresult);
            return "logInPage";
		}else {
			loginresult = "Password can't be empty!";
        	model.addAttribute("loginresult", loginresult);
            System.out.println("Requestmapping：" + loginresult);
            return "logInPage";
		}
    }
	
	@RequestMapping(value="MemberAccount/RegisterPage", method=RequestMethod.POST)
    public String register(@RequestParam(value="userID", required=true, defaultValue="null") String userID, 
    		@RequestParam(value="password", required=true, defaultValue="null") String password,
    		@RequestParam(value="password2", required=true, defaultValue="null") String password2,
    		@RequestParam(value="email", required=true, defaultValue="null") String email,
    		@RequestParam(value="cellphone", required=false, defaultValue="null") String cellphone,
    		@RequestParam(value="address", required=false, defaultValue="null") String address,
    		String registerResult,
    		Model model) throws InterruptedException {
		System.out.println(userID + "：" + password + "：" + password2 + "：" + email + "：" + cellphone + "：" + address);
		
		Thread.sleep(3000);
		if(!userID.equals("null") & !password.equals("null") & 
				!password2.equals("null") & !email.equals("null")) {
			if(password.equals(password2)) {
				System.out.println(userID + "：" + password);
				String checkResult = checkAccount.registerInfo(userID, password2, email, cellphone, address);
				
		        if(checkResult == "pass!") {
		        	registerResult = "pass!";
		        	model.addAttribute("registerResult", registerResult);
		            System.out.println("Requestmapping：" + registerResult);
		            return "logInPage";
		        }
		        else{
		        	registerResult = "Something error!";
		        	model.addAttribute("registerResult", registerResult);
		            System.out.println("Requestmapping：" + registerResult);
		            return "registerPage";
		        }
			}else {
				registerResult = "password should be the same!";
	        	model.addAttribute("registerResult", registerResult);
	            System.out.println("Requestmapping：" + registerResult);
	            return "registerPage"; 
			}
		}else if(userID.equals("null")){
			registerResult = "User can't be empty!";
        	model.addAttribute("registerResult", registerResult);
            System.out.println("Requestmapping：" + registerResult);
            return "registerPage";
		}else if(password.equals("null") || 
				password2.equals("null")){
			registerResult = "Password can't be empty!";
        	model.addAttribute("registerResult", registerResult);
            System.out.println("Requestmapping：" + registerResult);
            return "registerPage";
		}else{
			registerResult = "e-mail can't be empty!";
        	model.addAttribute("registerResult", registerResult);
            System.out.println("Requestmapping：" + registerResult);
            return "registerPage";
		}
	}
}
