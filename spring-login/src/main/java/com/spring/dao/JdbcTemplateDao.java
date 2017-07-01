package com.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String selectData(String userName) {
		return this.jdbcTemplate.query("select userPassword from user where userName ='" +userName +"'",new ResultSetExtractor<String>() {  
            public String extractData(ResultSet rs) throws SQLException, DataAccessException {  
                String passWord = "";
            	while (rs.next()) {  
                	passWord = rs.getString("userPassword");
                }  
                return passWord;  
            }  
        });  
	}
	
}
