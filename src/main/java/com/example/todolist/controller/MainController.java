package com.example.todolist.controller;

import com.example.todolist.entity.TodoEntity;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final TodoService todoService;

    /**
     *  메인 페이지 이동 및 data 조회
     */
    @RequestMapping("/main")
    public String main(Model model){
        List<TodoEntity> todoEntityList = this.todoService.getList();
        model.addAttribute("toDoEntityList", todoEntityList);

        return "main";
    }

    /**
     *  Todo 등록
     */
    @PostMapping("/create")
    public String todoCreate(@RequestParam String content){

        this.todoService.create(content);
        return "redirect:/main";
    }




    /**
     *  root URL로 접속 시 main으로 리다이렉션
     */
    @RequestMapping("/")
    public String root(){
        return "redirect:/main";
    }
}
