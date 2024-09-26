package com.example.eventexam.controller;

import com.example.eventexam.service.RegisterEventService;
import com.example.eventexam.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final RegisterEventService service;

    @GetMapping("/hello")
    public String hello(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hello : " + Thread.currentThread().getName();
    }


    @GetMapping("/register/{name}")
    public void register(@PathVariable String name) {
        service.register(name);
        System.out.println("회원가입을 완료했어요");
    }

}