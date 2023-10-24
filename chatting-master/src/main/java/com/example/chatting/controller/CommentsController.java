package com.example.chatting.controller;

import com.example.chatting.dto.CommentsDto;
import com.example.chatting.dto.PostDto;
import com.example.chatting.dto.ResponseDto;
import com.example.chatting.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping()
    public ResponseEntity<ResponseDto> addComments(@RequestBody CommentsDto commentsDto){
        return commentsService.addComments(commentsDto);
    }
}
