package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	public List<Todo> findAll();
	
	public Todo findById(long theId);
	
	public Todo deleteById(long theId);
	
	public Todo save(Todo theTodo);
}
