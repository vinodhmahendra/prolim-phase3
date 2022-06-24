package com.simplilearn.workshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.utils.ConnectionUtils;

@Repository(value = "todoRepository")
public class TodoRepositoryImpl implements TodoRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TodoRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	class TodoRowMapper implements RowMapper<Todo>{
		@Override
		public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Todo theTodo = new Todo();
			theTodo.setId(rs.getLong("id"));
			theTodo.setDescription(rs.getString("description"));
			theTodo.setUsername(rs.getString("username"));
			theTodo.setTargetDate(rs.getDate("target_date"));
			theTodo.setDone(rs.getBoolean("is_done"));
			return theTodo;
		}
		
	}
	
	private final RowMapper<Todo> todoRowMapper = (rs,rowNum) -> {
		Todo theTodo = new Todo();
		theTodo.setId(rs.getLong("id"));
		theTodo.setDescription(rs.getString("description"));
		theTodo.setUsername(rs.getString("username"));
		theTodo.setTargetDate(rs.getDate("target_date"));
		theTodo.setDone(rs.getBoolean("is_done"));
		return theTodo;
	};
	
	@Override
	public List<Todo> findAll() {
		String sql = "select * from todos";
		List<Todo> todos = this.jdbcTemplate.query(sql , todoRowMapper);
		return todos;
	}

	@Override
	public Todo findById(long theId) {
		String sql ="select * from  todos where id = ?";
		Todo theTodo = this.jdbcTemplate.queryForObject(sql , todoRowMapper,theId);
		return theTodo;
	}

	@Override
	public Todo deleteById(long theId) {
		String sql = "delete from todos where id = ?";
		this.jdbcTemplate.update(sql, Long.valueOf(theId));
		return null;
	}

	@Override
	public Todo save(Todo theTodo) {
		// Assignment
		return null;
	}



}
