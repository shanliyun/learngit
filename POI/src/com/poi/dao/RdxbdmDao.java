package com.poi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poi.bean.Rdxbdm;
@Repository
public class RdxbdmDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(Rdxbdm rdxbdm){
		String sql = "INSERT INTO rdxbdm VALUES(null,?,?)";
		jdbcTemplate.update(sql, rdxbdm.getDm(),rdxbdm.getMc());
	}
}
