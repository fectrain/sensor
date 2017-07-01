package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.JdbcTemplateDao;

@Repository
public class BlogService {
	
	@Autowired
	JdbcTemplateDao template;
	
	public void addBlog(String blogTitle ,String blogContent) {
		template.insertData(blogTitle, blogContent);
	}
	
}
