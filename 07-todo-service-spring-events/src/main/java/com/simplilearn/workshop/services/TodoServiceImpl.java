package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.events.TodosEvent;
import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.repository.TodoRepository;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService,ApplicationEventPublisherAware {

	//depends on repository
	@Autowired
	private TodoRepository theTodoRepository;
	private ApplicationEventPublisher eventPublisher;
	
	@Override
	public List<Todo> findAll() {
		eventPublisher.publishEvent(new TodosEvent(this, "FINDALL", theTodoRepository));
		return theTodoRepository.findAll();
	}

	@Override
	public Todo findById(long theId) {
		eventPublisher.publishEvent(new TodosEvent(this, "FINDBYID", theTodoRepository));
		return theTodoRepository.findById(theId);
	}

	@Override
	public Todo deleteById(long theId) {
		eventPublisher.publishEvent(new TodosEvent(this, "DELETEBYID", theTodoRepository));
		return theTodoRepository.deleteById(theId);
	}

	@Override
	public Todo save(Todo theTodo) {
		eventPublisher.publishEvent(new TodosEvent(this, "SAVE", theTodoRepository));
		return theTodoRepository.save(theTodo);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
		
	}

}
