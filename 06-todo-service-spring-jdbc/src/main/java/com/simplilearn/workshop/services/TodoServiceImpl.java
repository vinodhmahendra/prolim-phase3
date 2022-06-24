package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.repository.TodoRepository;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService {

	//depends on repository
	@Autowired
	private TodoRepository theTodoRepository;
	
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
