package com.example.todolist.controller;

import com.example.todolist.entity.TodoEntity;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final TodoService todoService;

    @RequestMapping("/main")
    public String main(Model model){
        List<TodoEntity> todoEntityList = this.todoService.getList();
        model.addAttribute("toDoEntityList", todoEntityList);

        return "main";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/main";
    }
}
