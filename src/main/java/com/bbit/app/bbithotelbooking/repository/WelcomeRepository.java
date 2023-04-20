package com.bbit.app.bbithotelbooking.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bbit.app.bbithotelbooking.dto.Employee;
import com.bbit.app.bbithotelbooking.util.Queries;

@Repository
public class WelcomeRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public String getWelcomeUser() {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id", 1);
		return namedParameterJdbcTemplate.queryForObject(Queries.GET_EMP_BY_ID, mapSqlParameterSource,	String.class);
	}

	public void createEmployee(Employee employee) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id", employee.getId());
		mapSqlParameterSource.addValue("name", employee.getName());
		mapSqlParameterSource.addValue("age", employee.getAge());
		
		namedParameterJdbcTemplate.update(Queries.INSERT_EMPLOYEE, mapSqlParameterSource);
		
	}

}
