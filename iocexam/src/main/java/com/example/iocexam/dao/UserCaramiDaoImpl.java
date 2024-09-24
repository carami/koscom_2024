package com.example.iocexam.dao;

import com.example.iocexam.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("caramiDao")
public class UserCaramiDaoImpl implements UserDao{
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
        System.out.println(user+"carami Dao를 이용해서 저장했습니다.");
    }
}
