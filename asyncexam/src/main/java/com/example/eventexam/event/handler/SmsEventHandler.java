package com.example.eventexam.event.handler;

import com.example.eventexam.event.RegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SmsEventHandler {

    @Async
    @EventListener // 1
    public void sendSms(RegisteredEvent event) throws InterruptedException{
        Thread.sleep(3000);
        System.out.println("sendSms : " + Thread.currentThread().getName());
        System.out.println(event.getName() + "님에게 가입 축하 메세지를 전송했습니다.");
    }

    @Async
    @EventListener
    public void makeCoupon(RegisteredEvent event) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("makeCoupon : " + Thread.currentThread().getName());
        System.out.println(event.getName() + "님에게 쿠폰을 전송했습니다.");
    }
}