package com.example.iocexam.config;

import com.example.iocexam.dao.UserDao;
import com.example.iocexam.dao.UserDaoImpl;
import com.example.iocexam.service.UserService;
import com.example.iocexam.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class UserConfig {
    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Bean
    public UserService userService(UserDao userDao) {
//        return new UserServiceImpl(userDao);
        UserServiceImpl userServie = new UserServiceImpl();
        userServie.setUserDao(userDao);
        return userServie;
    }
}
