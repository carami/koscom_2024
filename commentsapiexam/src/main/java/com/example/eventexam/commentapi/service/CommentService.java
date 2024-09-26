package com.example.eventexam.commentapi.service;

import com.example.eventexam.commentapi.domain.Comment;
import com.example.eventexam.commentapi.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<Comment> getComments(Long postId){
        return commentRepository.findByPostId(postId);
    }

    @Transactional
    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
