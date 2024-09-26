package com.example.eventexam.service;

import com.example.eventexam.dto.Todo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodosProxyService {

    private final String todosUrl = "http://localhost:8080/todos";
    private final RestTemplate restTemplate;

    public TodosProxyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retryable(
            value = {HttpStatusCodeException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000)
    )
    @GetMapping
    public List<Todo> getTodos() {
        System.out.println("proxy service getTodos");
        ResponseEntity<Todo[]> response = restTemplate.getForEntity(todosUrl, Todo[].class);
        return Arrays.asList(response.getBody());
    }

    @Recover
    public List<Todo>  recover(HttpStatusCodeException e) {
        System.out.println("recover");
        // 대안 흐름을 실행
        return new ArrayList<>();
    }
}
