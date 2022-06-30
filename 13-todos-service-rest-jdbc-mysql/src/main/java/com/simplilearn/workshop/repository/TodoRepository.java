package com.simplilearn.workshop.repository;

import java.util.List;

import com.simplilearn.workshop.model.Todo;

public interface TodoRepository {
	
	public List<Todo> findAll();
	
	public Todo findById(long theId);
	
	public Todo deleteById(long theId);
	
	public Todo save(Todo theTodo);
}
