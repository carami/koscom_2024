package com.example.restexam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/api/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/api/Users")
    public String addUser(){
        //각 메소드들을 약속에 맞게 구현해 줘야한다.
         return "addUser";
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