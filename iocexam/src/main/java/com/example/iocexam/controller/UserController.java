package com.example.iocexam.controller;

import com.example.iocexam.domain.User;
import com.example.iocexam.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        System.out.println("UserController 생성");
        this.userService = userService;
    }

    public void joinUser( ) {
        //실제 동작할 때는 사용자로부터 정보를 받아온다.
        User user = new User();
        user.setName("carami");
        user.setEmail("carami@gmail.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }
}
