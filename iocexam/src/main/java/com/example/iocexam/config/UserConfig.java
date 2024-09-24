package com.example.iocexam.config;

import com.example.iocexam.controller.UserController;
import com.example.iocexam.dao.UserDao;
import com.example.iocexam.dao.UserDaoImpl;
import com.example.iocexam.service.UserService;
import com.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.example.iocexam")
public class UserConfig {
//    @Bean
//    public UserDao userDao() {
//        return new UserDaoImpl();
//    }
//
//    @Bean
//    public UserService userService(UserDao userDao) {
////        return new UserServiceImpl(userDao);
//        UserServiceImpl userServie = new UserServiceImpl();
//        userServie.setUserDao(userDao);
//        return userServie;
//    }
//
//    @Bean
//    public UserController userController(UserService userService) {
//        return new UserController(userService);
//    }
}
