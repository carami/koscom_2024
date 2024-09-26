package com.example.eventexam.service;

import com.example.eventexam.dto.Todo;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodosProxyService {

    private final String todosUrl = "http://localhost:8080/todos";
    private final RestTemplate restTemplate;
    private final Retry retry;

    public TodosProxyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(1000))
                .retryExceptions(HttpStatusCodeException.class, RestClientException.class) // RestTemplate에서 발생하는 Exception은 RestClientException
                .build();

        this.retry = Retry.of("todosProxyService", retryConfig);
    }

    public List<Todo> getTodos() {
        CheckedFunction0<List<Todo>> getTodosSupplier = Retry.decorateCheckedSupplier(retry, this::getTodosInternal);
        return Try.of(getTodosSupplier)
                .recover(throwable -> this.recover((RestClientException) throwable))
                .get();
    }

    private List<Todo> getTodosInternal() {
        System.out.println("getTodosInternal");
        ResponseEntity<Todo[]> response = restTemplate.getForEntity(todosUrl, Todo[].class);
        return Arrays.asList(response.getBody());
    }

    public List<Todo> recover(RestClientException e) {
        // 대안 흐름을 실행
        System.out.println("recover");
        return new ArrayList<>();
    }
}