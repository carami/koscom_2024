package com.example.eventexam.controller;

import com.example.eventexam.service.AsyncTestService;
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
    private final AsyncTestService asyncTestService;

    @GetMapping("/register/{name}")
    public String register(@PathVariable String name) {
        System.out.println("register : " + Thread.currentThread().getName());
        service.register(name);
        System.out.println("회원가입을 완료했어요");
        return "회원가입을 완료했어요 :" + name;
    }

    @GetMapping("/test1")
    public String test1(){
        return asyncTestService.executeWithoutAsync();
    }


    @GetMapping("/test2")
    public String test3(){
        return asyncTestService.executeWithCompletableFuture();
    }

    @GetMapping("/test3")
    public String test2(){
        return asyncTestService.executeWithAsync();
    }

}