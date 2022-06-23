package com.simplilearn.workshop;

import java.util.List;

import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.services.TodoService;
import com.simplilearn.workshop.services.TodoServiceImpl;

// console application
public class TodoApp {

	public static void main(String[] args) {
		
		TodoService theTodoService = new TodoServiceImpl();
		
		List<Todo> todos = theTodoService.findAll();
		
		for  ( Todo todo: todos) {
			System.out.println(todo.getDescription());
		}
		
		System.out.println("***************************************************");
		
		Todo theTodo = theTodoService.findById(1);
		System.out.println(theTodo.getDescription());

	}

}
