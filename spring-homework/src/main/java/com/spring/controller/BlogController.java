package com.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired
	BlogService service;
	
	@RequestMapping("/blogInfo")
	public ResponseEntity<String> post(@RequestParam String blogTitle, @RequestParam String blogContent)
			throws IOException {
		
		ResponseEntity<String> result;
		
		if(blogTitle.length()>20 || blogContent.length() > 100) {
			result = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} else {
			service.addBlog(blogTitle, blogContent);
			result = new ResponseEntity<String>(HttpStatus.OK);
		}
		return result;
	}
}
