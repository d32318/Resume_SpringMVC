package com.syuanrujhu.website.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.syuanrujhu.website.modle.MemberAccountModle;
import com.syuanrujhu.website.repository.MemberAccountDao;

@Service
public class MemberAccountService extends MemberAccountModle {
	@Autowired
	public MemberAccountDao memberAccountDao;
	public String checkLoginInfo(String userID, String password) {
		java.util.List<Map<String, Object>> list = memberAccountDao.checkAccount(userID);
		String checkResult = null , ID = null, PWD = null;
		for (Map<String, Object> map : list) {
			ID = (String)map.get("username");
			PWD = (String) map.get("password");
	    }
		
		if(ID.equals(userID) & PWD.equals(password)) {
        	checkResult = "pass!";
		} 
		else {
        	checkResult = "User/Password error!";
        }
		return checkResult;
	}
	
	public String registerInfo(String userID, String password, String email, String cellphone, String address) {
		String result = null, Result = null;
		java.util.List<Map<String, String>> list = memberAccountDao.registerAccount(userID, password, email, cellphone, address);
		
		for (Map<String, String> map : list) {
			Result = (String)map.get("result");
	    }
		
		if(Result.equals("pass!")) {
			result = "pass!";
		} 
		else {
			result = "Create Failed!";
        }
		return result;
	}
}
