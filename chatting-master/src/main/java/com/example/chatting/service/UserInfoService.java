package com.example.chatting.service;


import com.example.chatting.dto.ResponseDto;
import com.example.chatting.dto.UserInfoDto;
import org.springframework.http.ResponseEntity;

public interface UserInfoService {
    ResponseEntity<ResponseDto> newUser(UserInfoDto userInfoDto);

    ResponseEntity<ResponseDto> getUser(Long userId);
}

