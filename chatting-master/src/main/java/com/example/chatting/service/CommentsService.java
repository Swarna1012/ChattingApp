package com.example.chatting.service;

import com.example.chatting.dto.CommentsDto;
import com.example.chatting.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface CommentsService {
    ResponseEntity<ResponseDto> addComments(CommentsDto commentsDto);
}
