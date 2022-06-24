package com.simplilearn.workshop.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TodosEventsProcessor implements ApplicationListener<TodosEvent>{

	@Override
	public void onApplicationEvent(TodosEvent event) {
		System.out.println("Todo : " + event.getEventType() + " event triggered ");
	}

}
