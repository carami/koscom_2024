package com.example.iocexam;

import com.example.iocexam.config.UserConfig;
import com.example.iocexam.controller.UserController;
import com.example.iocexam.domain.User;
import com.example.iocexam.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        System.out.println("ApplicationContext 실행전");
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        System.out.println("ApplicationContext 실행후");
//        UserService userService = context.getBean(UserService.class);
//        User user = new User();
//        user.setName("carami");
//        user.setEmail("carami@gmail.com");
//        user.setPassword("1234");
//
//        userService.joinUser(user);

        UserController userController = context.getBean(UserController.class);
        userController.joinUser();
    }
}
