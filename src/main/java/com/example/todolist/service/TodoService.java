package com.example.todolist.service;

import com.example.todolist.entity.TodoEntity;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoEntity> getList(){
        return this.todoRepository.findAll();
    }

    public void create(String content){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setContent(content);
        todoEntity.setCompleted(false);
        this.todoRepository.save(todoEntity);
    }

    @Transactional
    public void delete(Integer id){
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Data about this Id -> " + id));

        this.todoRepository.delete(todoEntity);
    }

}
