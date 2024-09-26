package com.example.eventexam.controller;

import com.example.eventexam.dto.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/todos")
@RestController
public class TodosController {
    private List<Todo> todos;
    private static int ID = 1;

    public TodosController() {
        todos = new ArrayList<>();
        todos.add(new Todo(ID++, "낮잠자기", false));
        todos.add(new Todo(ID++, "비타민먹기", false));
        todos.add(new Todo(ID++, "사과먹기", false));
        todos.add(new Todo(ID++, "책읽기", false));
        todos.add(new Todo(ID++, "청소하기", true));
    }

    @GetMapping
    public List<Todo> getTodos(){
        // 나중에 일부러 Exception을 발생하도록 한다.
        if(1==1)
            throw new RuntimeException();
        return todos;
    }

    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") int id){
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public Todo delete(@PathVariable("id") int id){
        Todo deletedTodo = todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);

        if (deletedTodo != null) {
            todos.remove(deletedTodo);
        }

        return deletedTodo;
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        todo.setId(ID++);
        todos.add(todo);
        return todo;
    }

    @PutMapping
    public Todo updateTodo(@RequestBody Todo todo) {
        Todo updatedTodo = todos.stream()
                .filter(t -> t.getId() == todo.getId())
                .findFirst()
                .orElse(null);

        if (updatedTodo != null) {
            updatedTodo.setTitle(todo.getTitle());
            updatedTodo.setDone(todo.isDone());
        }

        return updatedTodo;
    }
}
