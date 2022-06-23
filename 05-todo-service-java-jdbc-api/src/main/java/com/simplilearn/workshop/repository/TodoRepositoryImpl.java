package com.simplilearn.workshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.utils.ConnectionUtils;

public class TodoRepositoryImpl implements TodoRepository {

	@Override
	public List<Todo> findAll() {
		List<Todo> todos = new ArrayList<>();
		try {
			Connection connection = ConnectionUtils.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from todos");
			while ( rs.next() ) {
				Todo theTodo = new Todo();
				theTodo.setId(rs.getLong("id"));
				theTodo.setDescription(rs.getString("description"));
				theTodo.setUsername(rs.getString("username"));
				theTodo.setTargetDate(rs.getDate("target_date"));
				theTodo.setDone(rs.getBoolean("is_done"));
				
				// add to the list
				todos.add(theTodo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return todos ;
	}

	@Override
	public Todo findById(long theId) {
		Todo theTodo = new Todo();
		try {
			Connection connection = ConnectionUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from todos where id = ?");
			preparedStatement.setLong(1, theId);
			
			ResultSet rs = preparedStatement.executeQuery();
			if ( rs.next() ) {
				theTodo.setId(rs.getLong("id"));
				theTodo.setDescription(rs.getString("description"));
				theTodo.setUsername(rs.getString("username"));
				theTodo.setTargetDate(rs.getDate("target_date"));
				theTodo.setDone(rs.getBoolean("is_done"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return theTodo;
	}

	@Override
	public Todo deleteById(long theId) {
		// Assignment
		return null;
	}

	@Override
	public Todo save(Todo theTodo) {
		// Assignment
		return null;
	}



}
