package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.repository.TodoRepository;
import com.simplilearn.workshop.repository.TodoRepositoryImpl;

public class TodoServiceImpl implements TodoService {

	
//	private TodoRepository theTodoRepository = new TodoRepositoryImpl(); // BUG

	// the TodoServiceImpl has a dependency on a TodoRepository
//	private final TodoRepository theTodoRepository; 
	
	private  TodoRepository theTodoRepository; 
	
	//no argument constructor ( NOTE : setter DI )
	public TodoServiceImpl() {
		
	}
	
	public void setTheTodoRepository(TodoRepository theTodoRepository) {
		System.out.println("setter");
		this.theTodoRepository = theTodoRepository;
	}



	// a constructor so that  the spring container can inject a TodoRepository
	public TodoServiceImpl(TodoRepository theTodoRepository) {
		System.out.println("constructor");
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
