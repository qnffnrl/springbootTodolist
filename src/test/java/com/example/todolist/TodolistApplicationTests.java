package com.example.todolist;

import com.example.todolist.entity.TodoEntity;
import com.example.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Access;

@SpringBootTest
class TodolistApplicationTests {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void testJpa() {

		TodoEntity todo1 = new TodoEntity();
		todo1.setContent("todo1");
		todo1.setCompleted(Boolean.TRUE);
		this.todoRepository.save(todo1);

		TodoEntity todo2 = new TodoEntity();
		todo2.setContent("todo2");
		todo2.setCompleted(Boolean.FALSE);
		this.todoRepository.save(todo2);
	}

}
