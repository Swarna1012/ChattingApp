package com.example.chatting.controller;

import com.example.chatting.dto.PostDto;
import com.example.chatting.dto.ResponseDto;
import com.example.chatting.dto.UserInfoDto;
import com.example.chatting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping("/{userId}")
    public ResponseEntity<ResponseDto> addPost(@RequestBody PostDto postDto, @PathVariable Long userId){
        return postService.addPost(postDto,userId);
    }

    @PostMapping("/edit/{postId}")
    public ResponseEntity<ResponseDto> editPost(@RequestBody PostDto postDto, @PathVariable Long postId){
        return postService.editPost(postDto,postId);
    }

    @PostMapping("/delete/{postId}")
    public ResponseEntity<ResponseDto> deletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }


}
