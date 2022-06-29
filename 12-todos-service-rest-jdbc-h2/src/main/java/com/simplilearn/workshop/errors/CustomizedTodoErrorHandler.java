package com.simplilearn.workshop.errors;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.simplilearn.workshop.model.Todo;

@RestControllerAdvice
public class CustomizedTodoErrorHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Todo> handleAllException(Exception ex,WebRequest request) throws Exception{
		TodoErrorResponse errorResponse =
				new TodoErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TodoNotFoundException.class)
	public final ResponseEntity<Todo> handleTodoNotFoundException(Exception ex,WebRequest request) throws Exception{
		TodoErrorResponse errorResponse =
				new TodoErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		TodoErrorResponse errorResponse =
				new TodoErrorResponse(new Date(), "Validation Failled", ex.getBindingResult().toString());
		return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
	}

}
