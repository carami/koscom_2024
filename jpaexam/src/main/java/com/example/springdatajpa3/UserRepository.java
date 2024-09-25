package com.example.springdatajpa3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryCustom {
}
