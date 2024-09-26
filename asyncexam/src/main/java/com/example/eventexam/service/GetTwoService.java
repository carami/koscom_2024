package com.example.eventexam.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class GetTwoService {
    public String getTwo(){
        try{
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("getTwo : " + Thread.currentThread().getName());
        return "two";
    }

    @Async
    public Future<String> getAsyncTwo(){
        try{
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("getTwo : " + Thread.currentThread().getName());
        return new AsyncResult<>("two");
    }
}
