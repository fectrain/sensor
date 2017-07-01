package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.LoginService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping("/login")
	public String login (HttpServletRequest request,
			HttpServletResponse response) {
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		String userPassword = service.getPassword(userName);
		if(!userPassword.equals("") && service.validate(userPassword,passWord)) {
			return "/user";
		}else {
			return "/error";
		}
		
	}
	
	
	
	
	/*
	@RequestMapping("/register")
	public String register(User user,HttpServletRequest request,HttpServletResponse response){
		boolean is = userService.addUser(user);
		if (is) {
			return VIEW;
		}else{
			return null;
		}
	}
	*/
	
	
	
}
