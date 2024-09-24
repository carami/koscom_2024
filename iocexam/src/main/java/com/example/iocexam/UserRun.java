package com.example.iocexam;

import com.example.iocexam.config.UserConfig;
import com.example.iocexam.domain.User;
import com.example.iocexam.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserRun {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setName("carami");
        user.setEmail("carami@gmail.com");
        user.setPassword("1234");

        userService.joinUser(user);
    }
}
