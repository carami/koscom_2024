package com.example.eventexam.service;

import com.example.eventexam.event.RegisteredEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RegisterEventService {

    @Autowired
    ApplicationEventPublisher publisher;

    public void register(String name) {
        // 회원가입 처리 로직
        System.out.println("회원 추가 완료");

        publisher.publishEvent(new RegisteredEvent(name)); // 2
    }
}