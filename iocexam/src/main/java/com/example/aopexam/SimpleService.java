package com.example.aopexam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public void hello(){
        System.out.println("hello method run!!!");
//        if(1==1)
//            throw new RuntimeException("hello method run!!!");
    }

    public String doSomething(){
        System.out.println("SimpleService doSomething run!!!");
        return "do something ... ";
    }

    public void setName(String name){
        System.out.println("SimpleService setName run!!!");
    }
}
