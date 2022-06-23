package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService {

	//depends on repository
	private TodoRepository theTodoRepository ;
	public void setTheTodoRepository(TodoRepository theTodoRepository) {
		System.out.println("setter");
		this.theTodoRepository = theTodoRepository;
	}
	
	@Override
	public List<Todo> findAll() {
		return theTodoRepository.findAll();
	}

	@Override
	public Todo findById(long theId) {
		return theTodoRepository.findById(theId);
	}

	@Override
	public Todo deleteById(long theId) {
		return theTodoRepository.deleteById(theId);
	}

	@Override
	public Todo save(Todo theTodo) {
		return theTodoRepository.save(theTodo);
	}

}
