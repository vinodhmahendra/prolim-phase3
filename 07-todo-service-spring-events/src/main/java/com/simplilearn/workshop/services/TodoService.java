package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Todo;

public interface TodoService {
	public List<Todo> findAll();

	public Todo findById(long theId);

	public Todo deleteById(long theId);

	public Todo save(Todo theTodo);
}
