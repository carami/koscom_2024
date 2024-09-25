package com.example.jpaexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class JpaexamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaexamApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        //1. 사용자 추가
//        User user = new User("carami22","carami@gmail.com");
//        User user2 = new User("abcdUser22","abcdUser@gmail.com");
//
//        userRepository.save(user);
//        userRepository.save(user2);

//        //2. 모든 사용자 조회
//        userRepository.findAll().forEach(System.out::println);
//
//        //3. ID에 해당하는 사용자 찾기
//        User findUser = userRepository.findById(1L).orElseThrow(()->new RuntimeException("User Not Found"));
//        System.out.println(findUser);
//        log.info(findUser.toString());
//
//
//        //4.사용자 정보 수정
//        findUser.setName("kangkyungmi");
//
//        userRepository.save(findUser);
//
//        //5. 사용자 삭제
//        log.info("사용자삭제");
//        userRepository.delete(findUser);
//
//        userRepository.findAll().forEach(System.out::println);

        List<User> users = userRepository.findByEmail("abcdUser@gmail.com");
//        System.out.println("findByEmail:::"+user);
        users.forEach(System.out::println);

    }

//    @Bean
//    public CommandLineRunner run(UserRepository userRepository) {
//        return args -> {
//
//        };
//    }
}
