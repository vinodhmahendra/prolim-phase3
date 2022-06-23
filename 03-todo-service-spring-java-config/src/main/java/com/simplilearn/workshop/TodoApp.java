package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simplilearn.workshop.config.TodoAppConfig;
import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.services.TodoService;

// console application
public class TodoApp {
;
	public static void main(String[] args) {
		
		//intiate the container
		ApplicationContext context = new AnnotationConfigApplicationContext(TodoAppConfig.class);
		
		
//		Retrieve the configured instance
		TodoService theTodoService = context.getBean("todoService", TodoService.class);
		
		
		List<Todo> todos = theTodoService.findAll();
		
		for  ( Todo todo: todos) {
			System.out.println(todo.getDescription());
		}

	}

}
