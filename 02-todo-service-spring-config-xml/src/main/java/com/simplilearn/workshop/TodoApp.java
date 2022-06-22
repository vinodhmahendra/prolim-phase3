package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.services.TodoService;

// console application
public class TodoApp {

	public static void main(String[] args) {
		
		//instantiating a container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		TodoService theTodoService = new TodoServiceImpl();
		//retrieve configured instance
		TodoService theTodoService = context.getBean("todoService", TodoService.class);
		
		List<Todo> todos = theTodoService.findAll();
		
		for  ( Todo todo: todos) {
			System.out.println(todo.getDescription());
		}

	}

}
