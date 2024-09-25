package com.example.aopexam;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimpleService {
//    Logger log = LoggerFactory.getLogger(SimpleService.class);
    public void hello(){
        System.out.println("hello method run!!!");
//        if(1==1)
//            throw new RuntimeException("hello method run!!!");
    }

    public String doSomething(){
        System.out.println("SimpleService doSomething run!!!");
        log.info("SimpleService doSomething run!!!");
        return "do something ... ";
    }

    public void setName(String name){
        log.info("SimpleService setName run!!!");
        System.out.println("SimpleService setName run!!!");
    }
}
