package com.example.chatting.service;

import com.example.chatting.dto.PostDto;
import com.example.chatting.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity<ResponseDto> addPost(PostDto postDto, Long userId);

    ResponseEntity<ResponseDto> editPost(PostDto postDto, Long postId);

    ResponseEntity<ResponseDto> deletePost(Long postId);
}
