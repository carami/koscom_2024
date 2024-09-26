package com.example.eventexam.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class GetOneService {
    public String getOne(){
        try{
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("getOne : " + Thread.currentThread().getName());
        return "one";
    }

    @Async
    public Future<String> getAsyncOne(){
        try{
            Thread.sleep(2000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("getOne : " + Thread.currentThread().getName());
        return new AsyncResult<>("one");
    }
}
