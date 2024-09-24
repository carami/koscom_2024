package com.example.iocexam.controller;

import com.example.iocexam.domain.User;
import com.example.iocexam.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    public UserController() {
        System.out.println("UserController() 실행!!");
    }

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        //해당 빈이 생성 된 직후에 해야하는 일이 있다면...
        System.out.println("PostConstruct 실행!!");
    }
    
    @PreDestroy
    public void destroy(){
        //빈이 소멸되기 직전에 해야하는 일이 있다면 여기에 구현.. 
        System.out.println("PreDestory 실행!!");
    }

//    public UserController(UserService userService) {
//        System.out.println("UserController 생성");
//        this.userService = userService;
//    }

    public void joinUser( ) {
        //실제 동작할 때는 사용자로부터 정보를 받아온다.
        User user = new User();
        user.setName("carami");
        user.setEmail("carami@gmail.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }
}
