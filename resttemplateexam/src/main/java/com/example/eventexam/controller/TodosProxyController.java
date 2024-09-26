package com.example.eventexam.controller;

import com.example.eventexam.dto.Todo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todos-proxy")
public class TodosProxyController {

    private final String todosUrl = "http://localhost:8080/todos";
    private final RestTemplate restTemplate;

    public TodosProxyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Todo> getTodos() {
        ResponseEntity<Todo[]> response = restTemplate.getForEntity(todosUrl, Todo[].class);
        return Arrays.asList(response.getBody());
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") int id) {
        ResponseEntity<Todo> response = restTemplate.getForEntity(todosUrl + "/" + id, Todo.class);
        return response.getBody();
    }

    @DeleteMapping("/{id}")
    public Todo delete(@PathVariable("id") int id) {
        ResponseEntity<Todo> response = restTemplate.exchange(todosUrl + "/" + id, HttpMethod.DELETE, null, Todo.class);
        return response.getBody();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        ResponseEntity<Todo> response = restTemplate.postForEntity(todosUrl, todo, Todo.class);
        return response.getBody();
    }

    @PatchMapping
    public Todo updateTodo(@RequestBody Todo todo) {

        HttpEntity<Todo> requestEntity = new HttpEntity<>(todo);
        ResponseEntity<Todo> response = restTemplate.exchange(todosUrl, HttpMethod.PATCH, requestEntity, Todo.class);
        return response.getBody();
    }
}
