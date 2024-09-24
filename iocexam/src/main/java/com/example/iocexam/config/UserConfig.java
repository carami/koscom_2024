package com.example.iocexam.config;

import com.example.iocexam.dao.UserDao;
import com.example.iocexam.dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class UserConfig {
    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }
}
