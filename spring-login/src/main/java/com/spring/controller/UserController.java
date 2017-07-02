package com.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.LoginService;

@Controller
public class UserController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping("/login")
	public String login (HttpServletRequest request,
			HttpServletResponse response) {
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		if(userName!=null && passWord!=null){
			String userPassword = service.getPassword(userName);
			if( !userPassword.equals("") && service.validate(userPassword,passWord)) {
				//登录成功 
				request.getSession().setAttribute("userName", userName);
				//相对路径跳转
				return "redirect:user";
			}
			//登录失败 绝对路径跳转
			return "redirect:/index.html";
		}else {
			
			return "error";
		}
		
	}
	
	@RequestMapping("/user")
	public String user (HttpServletRequest request,ModelMap map) {
		Object userName = request.getSession().getAttribute("userName");
		if(userName!=null) {
			map.addAttribute("userName",userName.toString());
			return "user";
		} else {
			return "error";
		}
	}
	
}
