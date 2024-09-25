package com.example.jpaexam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByNameAndEmail(String name, String Email);

    List<User> findByEmailContaining(String email);


    @Query("select u from User u where u.email like %:email% ")
    List<User> findByEmailLike(@Param("email") String email);

    @Modifying
    @Query("UPDATE User u set u.email= :email where u.id = :id")
    int updateUserEmail(@Param("id") Long id, @Param("email") String email);


    @Query(value = "select * from jpa_user where email like %:email% ",nativeQuery = true)
    List<User> findByEmailLike2(@Param("email") String email);
}
