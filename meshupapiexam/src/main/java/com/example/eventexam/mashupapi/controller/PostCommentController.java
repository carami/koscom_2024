package com.example.eventexam.mashupapi.controller;

import com.example.eventexam.mashupapi.client.PostCommentService;
import com.example.eventexam.mashupapi.dto.Comment;
import com.example.eventexam.mashupapi.dto.Post;
import com.example.eventexam.mashupapi.dto.PostDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class PostCommentController {
    private final PostCommentService postCommentService;


    @GetMapping("/post-details/{postId}")
    public PostDetail getPostDetail(@PathVariable Long postId) {
        return postCommentService.getPostDetail(postId);
    }

    @GetMapping("/post-details2/{postId}")
    public PostDetail getPostDetail2(@PathVariable Long postId) throws ExecutionException, InterruptedException {
        return postCommentService.getPostDetail2(postId);
    }
}