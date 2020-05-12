package com.syuanrujhu.website.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.syuanrujhu.website.modle.MemberAccountModle;

@Repository
public class MemberAccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> checkAccount(String userID) {
		System.out.println("EXCUTE GET MEMBER INFO：" + userID);
		List<Map<String, Object>> results = 
			    (List<Map<String, Object>>) jdbcTemplate.queryForList(
			        "SELECT username, password FROM account WHERE username=?", userID);
		System.out.println("results:" + results);
		if(!results.isEmpty()) {
			return results;
		}
		else {
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("username", "null");
			map.put("password", "null");
			results.add(map);
			return results;
		}
	}
	
	public List<Map<String, String>> registerAccount(String userID, String password, String email, String cellphone, String address) {
		System.out.println("EXCUTE Register INFO：" + userID + ":" + password + ":" + cellphone + ":" + email + ":" + address);
//		List<Map<String, Object>> results = 
//			    (List<Map<String, Object>>) jdbcTemplate.queryForMap(
//			        "insert into account (username, password, phone, mail, address) values ('" 
//			    + userID + "','" + password +"','"+ cellphone +"','"+ email +"','"+ address+ "')");
//		System.out.println("results:" + results);
//		if(!results.isEmpty()) {
//			return results;
//		}
//		else {
//			Map<String,Object> map = new HashMap<String, Object>();
//			map.put("result", "pass!");
//			results.add(map);
//			return results;
//		}
		
		List<Map<String, String>> results = new ArrayList<Map<String, String>>();
		try {
			System.out.println("insert into account (username, password, phone, mail, address) values ('" 
				    + userID + "','" + password +"','"+ cellphone +"','"+ email +"','"+ address+ "')");
			jdbcTemplate.execute("insert into account (username, password, phone, mail, address) values ('" 
				    + userID + "','" + password +"','"+ cellphone +"','"+ email +"','"+ address+ "')");
			
			System.out.println("Send Sql Finished");
			Map<String,String> map = new HashMap<String, String>();
			map.put("result", "pass!");
			results.add(map);
			System.out.println("results:" + results);
			return results;
		}catch(Exception e){
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "Create Fail!");
			results.add(map);
			System.out.println("results:" + results);
			return results;
		}finally{
			System.out.println("results:" + results);
		}
	}
}
