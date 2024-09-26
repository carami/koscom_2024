package com.example.restexam.service;

import com.example.restexam.domain.Todo;
import com.example.restexam.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getTodos(){
        return todoRepository.findAll(Sort.by("id").descending());
    }
    @Transactional(readOnly = true)
    public Todo getTodo(Long id){
        return todoRepository.findById(id).get();
    }
    @Transactional
    public Todo addTodo(String todo){
        System.out.println("test");
        return todoRepository.save(new Todo(todo));
    }
    @Transactional
    public void deleteTodo(Long id){
        Optional<Todo> findTodo =  todoRepository.findById(id);
        if(findTodo.isEmpty())
            return;
        todoRepository.delete(findTodo.get());
    }
    @Transactional
    public Todo updateTodo(Long id){
        //id에 해당하는 todo 의  done 값을 토글하도록 구현
        Todo updateTodo = null;
        try{
            updateTodo = todoRepository.findById(id).orElseThrow();
            updateTodo.setDone(!updateTodo.isDone());
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateTodo;
    }

    @Transactional
    public Todo updateTodo(Todo todo){
        //id에 해당하는 Todo 정보를 수정
        Todo updateTodo = null;
        try{
            updateTodo = todoRepository.save(todo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateTodo;
    }

}
