package com.example.eventexam.mashupapi.dto;

import lombok.Data;

@Data
public class Comment {
    private Long id;
    private Long postId;
    private String author;
    private String content;
}
