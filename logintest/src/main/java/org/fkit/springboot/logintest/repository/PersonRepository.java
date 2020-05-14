package org.fkit.springboot.logintest.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.fkit.springboot.logintest.bean.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {

	@Resource
	JdbcTemplate jdbcTemplate;
	
	public int insertPerson() {
		String sql = "insert into tb_person(login_name,username,password)" +
				     "values(?,?,?),(?,?,?)";
		Object[] args = new Object[] {"tom","Thomas","123","jack","jackson","123"};
		return jdbcTemplate.update(sql, args);
	}
	
	public Person findByUsername(String username) {
		String sql = "select * from tb_person where username = ?";
		RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
		return jdbcTemplate.queryForObject(sql, new Object[] {username}, rowMapper);
	}
	
	public Person insertGetKey(Person person) {
		String sql = "insert into tb_person(login_name,username,password) values(?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stat = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stat.setString(1, "test");
				stat.setString(2, "Test");
				stat.setString(3, "123");
				return stat;
			}
		}, holder);
		
		int id = holder.getKey().intValue();
		person.setId(id);
		return person;
	}
}
