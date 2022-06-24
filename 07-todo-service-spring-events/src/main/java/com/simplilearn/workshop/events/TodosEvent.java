package com.simplilearn.workshop.events;

import org.springframework.context.ApplicationEvent;

import com.simplilearn.workshop.repository.TodoRepository;

public class TodosEvent extends ApplicationEvent {

	private String eventType;
	private TodoRepository todoRepository;

	public TodosEvent(Object source, String eventType, TodoRepository todoRepository) {
		super(source);
		this.eventType = eventType;
		this.todoRepository = todoRepository;
	}

	public String getEventType() {
		return eventType;
	}

	public TodoRepository getTodoRepository() {
		return todoRepository;
	}
}
