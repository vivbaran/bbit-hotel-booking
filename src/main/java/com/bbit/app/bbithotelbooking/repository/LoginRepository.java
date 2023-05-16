package com.bbit.app.bbithotelbooking.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bbit.app.bbithotelbooking.dto.User;
import com.bbit.app.bbithotelbooking.util.Queries;

@Repository
public class LoginRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void register(User user) {
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("firstName", user.getFirstName());
		mapSqlParameterSource.addValue("lastName", user.getLastName());
		mapSqlParameterSource.addValue("age", user.getAge());
		mapSqlParameterSource.addValue("email", user.getEmail());
		mapSqlParameterSource.addValue("mobileNumber", user.getMobileNumber());
		mapSqlParameterSource.addValue("gender", user.getGender());
		mapSqlParameterSource.addValue("city", user.getCity());
		mapSqlParameterSource.addValue("isAdmin", user.getIsAdmin());
		mapSqlParameterSource.addValue("password", user.getPassword());
		
		
		namedParameterJdbcTemplate.update(Queries.INSERT_USER, mapSqlParameterSource);
	}


	public String checkUserLoginPassword(String email) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("email", email);
		
		return namedParameterJdbcTemplate.queryForObject(Queries.GET_PASSWORD_BY_EMAIL, mapSqlParameterSource,String.class);
	}

}
