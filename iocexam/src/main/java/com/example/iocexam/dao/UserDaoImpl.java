package com.example.iocexam.dao;

import com.example.iocexam.domain.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl(){
        System.out.println("UserDaoImpl 생성!!");
    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+"의 정보가 잘 저장되었습니다.");
    }
}
