package com.example.eventexam.controller;

import com.example.eventexam.dto.Todo;
import com.example.eventexam.service.TodosProxyService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import java.util.List;

@RestController
@RequestMapping("/todos-proxy")
@RequiredArgsConstructor
public class TodosProxyController {
    private final TodosProxyService todosProxyService;

    @GetMapping
    public List<Todo> getTodos() {
        return todosProxyService.getTodos();
    }

}
