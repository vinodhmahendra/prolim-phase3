package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simplilearn.workshop.config.TodoAppConfig;
import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.services.TodoService;

// console application
public class TodoApp {

	public static void main(String[] args) {

//		ApplicationContext context = new AnnotationConfigApplicationContext(TodoAppConfig.class, InfraStructureConfig.class); bad practice

		ApplicationContext context = new AnnotationConfigApplicationContext(TodoAppConfig.class);

		TodoService theTodoService = context.getBean("todoService", TodoService.class);

		List<Todo> todos = theTodoService.findAll();

		for (Todo todo : todos) {
			System.out.println(todo.getDescription());
		}

		System.out.println("***************************************************");

		Todo theTodo = theTodoService.findById(1);
		System.out.println(theTodo.getDescription());

		System.out.println("Delete Operation");
		theTodoService.deleteById(1);

		todos = theTodoService.findAll();

		for (Todo todo : todos) {
			System.out.println(todo.getDescription());
		}

	}

}
