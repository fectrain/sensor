package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.JdbcTemplateDao;

@Repository
public class LoginService {
	
	@Autowired
	JdbcTemplateDao template;
	
	public String getPassword(String userName) {
		return template.selectData(userName);
	}
	public boolean validate(String userPassword,String passWord) {
		if (userPassword.equals(passWord)) {
			return true;
		}else{
			return false;
		}
	}
	
}
