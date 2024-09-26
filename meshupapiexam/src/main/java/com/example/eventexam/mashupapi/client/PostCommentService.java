package com.example.eventexam.mashupapi.client;

import com.example.eventexam.mashupapi.dto.Comment;
import com.example.eventexam.mashupapi.dto.Post;
import com.example.eventexam.mashupapi.dto.PostDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class PostCommentService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String postServiceUrl = "http://localhost:8081/posts";
    private final String commentServiceUrl = "http://localhost:8083/comments/by-post";

    public PostDetail getPostDetail(@PathVariable Long postId) {
        ResponseEntity<Post> postResponse = restTemplate.getForEntity(postServiceUrl + "/" + postId, Post.class);
        Post post = postResponse.getBody();

        ResponseEntity<Comment[]> commentResponse = restTemplate.getForEntity(commentServiceUrl + "/" + postId, Comment[].class);
        List<Comment> comments = Arrays.asList(commentResponse.getBody());

        return new PostDetail(post, comments);
    }

    public PostDetail getPostDetail2(@PathVariable Long postId) throws ExecutionException, InterruptedException {

        // api를 호출하는 부분은 동시에 실행되는 코드
        CompletableFuture<Post> postFuture = CompletableFuture.supplyAsync(() -> {
            ResponseEntity<Post> postResponse = restTemplate.getForEntity(postServiceUrl + "/" + postId, Post.class);
            return postResponse.getBody();
        });

        CompletableFuture<List<Comment>> commentsFuture = CompletableFuture.supplyAsync(() -> {
            ResponseEntity<Comment[]> commentResponse = restTemplate.getForEntity(commentServiceUrl + "/" + postId, Comment[].class);
            return Arrays.asList(commentResponse.getBody());
        });

        CompletableFuture.allOf(postFuture, commentsFuture).join();

        // 아래부분은 순차적으로 실행되는 코드. 아무리 노력해도 시간을 줄일 수 없는 부분은 있다. : 암달의 법칙(Amdahl's law)
        Post post = postFuture.get();
        List<Comment> comments = commentsFuture.get();

        return new PostDetail(post, comments);
    }
}
