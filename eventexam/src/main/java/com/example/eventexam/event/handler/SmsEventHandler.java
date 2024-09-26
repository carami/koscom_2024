package com.example.eventexam.event.handler;

import com.example.eventexam.event.RegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SmsEventHandler {

    @EventListener // 1
    public void sendSms(RegisteredEvent event) {
        System.out.println("sendSms thread name : " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(event.getName() + "님에게 가입 축하 메세지를 전송했습니다.");
    }

    @EventListener
    public void makeCoupon(RegisteredEvent event) {

        System.out.println("makeCoupon thread name : " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(event.getName() + "님에게 쿠폰을 전송했습니다.");
    }
}