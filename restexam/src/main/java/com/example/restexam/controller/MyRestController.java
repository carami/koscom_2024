package com.example.restexam.controller;

import com.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api/v1/")
@RestController
public class MyRestController {
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/users")
    public String addUser(){
        //각 메소드들을 약속에 맞게 구현해 줘야한다.
         return "addUser";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id){
        return "getUser "+id+" user 정보입니다.";

    }

    @GetMapping(value = "/products/{id}", produces = "application/xml")
    public Product getProduct(@PathVariable("id") int id){
        return new Product(id, "pen",9.99);
    }

    //URi를 통해서 자원을 나타낸다.

    // http://localhost/shop/api/users      --

    //method 를통해서 행위를 정의함.
    //get  --  read
    // http://localhost/shop/api/users      --  get ( r )   --  userList 정보를 읽어온다.
    // http://localhost/shop/api/users/{id}  --  get (r)   -- id에 해당하는 User 정보읽어옴
    // http://localhost/shop/api/users     -- post (c ) --  user 정보 생성(저장)
    // http://localhost/shop/api/users    -- delete  (d)  --  user 정보 삭제
    // http://localhost/shop/api/users    -- put  (u)   -- user 정보 수정  (전체적으로 수정)
    // http://localhost/shop/api/users    --patch (u)  -- -- user 정보 수정  (부분만 수정)
}
//http://localhost/shop/api/posts/{id}/replys -- get