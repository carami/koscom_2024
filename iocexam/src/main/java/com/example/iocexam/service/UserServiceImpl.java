package com.example.iocexam.service;

import com.example.iocexam.dao.UserDao;
import com.example.iocexam.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("caramiDao")
    private UserDao userDao;

//    public UserServiceImpl(UserDao userDao) {
//        System.out.println("UserServiceImpl 생성");
//        this.userDao = userDao;
//    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl() 생성");
    }
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void joinUser(User user) {
        //회원가입에 필요한 비지니스 코드가 작성되어야함.

        //비지니스가 만족되면 저장해야함.
        userDao.addUser(user);

    }
}
