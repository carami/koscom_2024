package com.example.postsapi.service;

import com.example.postsapi.domain.Post;
import com.example.postsapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<Post> getPages(int page, int size){
        return postRepository.findAll(PageRequest.of(page, size));
    }


    @Transactional(readOnly = true)
    public Post getPost(Long id){
        return postRepository.findById(id).orElse(null);
    }

    @Transactional
    public Post addPost(Post post){
        return postRepository.save(post);
    }


    @Transactional
    public void updatePost(Post postParam){
        Post post = postRepository.findById(postParam.getId()).orElseThrow();
        post.setContent(postParam.getContent());
        post.setTitle(postParam.getTitle());
    }

    @Transactional
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

}
