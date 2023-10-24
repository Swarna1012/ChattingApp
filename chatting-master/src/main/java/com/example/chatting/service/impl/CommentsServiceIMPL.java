package com.example.chatting.service.impl;

import com.example.chatting.dto.CommentsDto;
import com.example.chatting.dto.ResponseDto;
import com.example.chatting.entity.Comments;
import com.example.chatting.entity.Post;
import com.example.chatting.entity.UserInfo;
import com.example.chatting.repository.CommentsRepository;
import com.example.chatting.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CommentsServiceIMPL implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Override
    public ResponseEntity<ResponseDto> addComments(CommentsDto commentsDto) {
        Comments comments = new Comments();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(commentsDto.getUserId());
        comments.setUserId(userInfo);
        Post post = new Post();
        post.setPostId(commentsDto.getPostId());
        comments.setPostId(post);
        comments.setComment(commentsDto.getComment());
        comments.setCommentedAt(new Timestamp(System.currentTimeMillis()));
        commentsRepository.save(comments);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK,"commented successfully",comments));
    }
}
