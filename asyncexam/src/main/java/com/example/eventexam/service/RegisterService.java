package com.example.eventexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    public void register(String name) {
        // 회원가입 처리 로직
        System.out.println("회원 추가 완료");

        // 가입 축하 메세지 전송
        System.out.println(name + "님에게 가입 축하 메세지를 전송했습니다.");

        // 가입 축하 쿠폰 발급
        System.out.println(name + "님에게 쿠폰을 전송했습니다.");
    }
}