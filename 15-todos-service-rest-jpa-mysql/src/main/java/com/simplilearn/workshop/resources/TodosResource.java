package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.errors.TodoNotFoundException;
import com.simplilearn.workshop.model.Todo;
import com.simplilearn.workshop.services.TodoService;

@RestController
public class TodosResource {

	@Autowired
	private TodoService todoService;

	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getAllTodos() {
		return todoService.findAll();
	}

	@GetMapping(path = "/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		Todo theTodo = todoService.findById(id);
		
		if  ( theTodo == null ) {
			throw new TodoNotFoundException("id - "+id);
		}
		return theTodo;
	}

	@PostMapping(path = "/users/{username}/todos")
	public ResponseEntity createTodo(@PathVariable String username,@Valid @RequestBody Todo theTodo) {
		Todo savedTodo = todoService.save(theTodo);

		// Response Header : location
		// Status Code : 201
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTodo.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path = "/users/{username}/todos/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long id,@RequestBody Todo theTodo){
		Todo savedTodo = todoService.save(theTodo);
		return new ResponseEntity(theTodo,HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Todo> deleteTodo(@PathVariable String username,@PathVariable long id){
		Todo theTodo = todoService.deleteById(id);
		return  ResponseEntity.notFound().build();
	}

}
