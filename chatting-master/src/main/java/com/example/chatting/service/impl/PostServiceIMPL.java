package com.example.chatting.service.impl;

import com.example.chatting.dto.PostDto;
import com.example.chatting.dto.ResponseDto;
import com.example.chatting.entity.Post;
import com.example.chatting.entity.UserInfo;
import com.example.chatting.repository.PostRepository;
import com.example.chatting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PostServiceIMPL implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public ResponseEntity<ResponseDto> addPost(PostDto postDto, Long userId) {
        Post post = new Post();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        post.setUserId(userInfo);
        post.setPostTitle(postDto.getPostTitle());
        post.setPostMedia(postDto.getPostMedia());
        post.setDescription(postDto.getDescription());
        post.setPath(postDto.getPath());
        post.setPostedAt(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"posted successfully",post));
    }

    @Override
    public ResponseEntity<ResponseDto> editPost(PostDto postDto, Long postId) {
        Post post = postRepository.findById(postId).get();
        post.setPostTitle(postDto.getPostTitle());
        post.setPostMedia(postDto.getPostMedia());
        post.setDescription(postDto.getDescription());
        post.setPath(postDto.getPath());
//        post.setPostedAt(new Timestamp(System.currentTimeMillis()));
        postRepository.save(post);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"posted successfully",post));
    }

    @Override
    public ResponseEntity<ResponseDto> deletePost(Long postId) {
        postRepository.deleteById(postId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"post deleted successfully",""));
    }
}
